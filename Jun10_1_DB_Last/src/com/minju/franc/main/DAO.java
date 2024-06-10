package com.minju.franc.main;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.minju.db.manager.MinjuDBManager;
import com.minju.franc.reservation.Reservation;
import com.minju.franc.restaurant.Restaurant;

public class DAO {
	// MVC패턴의 M
	//		DAO / DTO 패턴
	//		DAO (Data Access Object)
	//			: M 중에서 DB관련한 작업을 전담하는 클래스
	//		DTO (Data Transfer / Temp Object)
	//			: DAO의 작업결과를 표현하는 클래스 (Reservation / Restaurant)
	
	//	java.util.Date - 주력 (Spring에서는 이걸 원함)
	//	java.sql.Date - JDBC에서는 이걸 원함
	
	//	java.util.Date => java.sql.Date
	//		: new Date(클래스명.get날짜관련멤버변수명().getTime());
	
	//	java.sql.Date => java.util.Date : 알아서 바꿔줌
	
	// 1. 예약하기
	public static String book(Reservation rsv) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = MinjuDBManager.connect();
			String sql = "insert into jun10_reservation "
					+ "values(jun10_reservation_seq.nextval, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, rsv.getName());
			pstmt.setDate(2, new Date(rsv.getWhen().getTime()));
			pstmt.setString(3, rsv.getPhoneNum());
			pstmt.setString(4, rsv.getLocation());
			
			if (pstmt.executeUpdate() == 1) {
				return "예약 성공";
			}
			return ""; // Java문법상 필요해서 억지로 넣은 것!
		} catch (Exception e) {
			e.printStackTrace();
			return "예약 실패";
		} finally {
			MinjuDBManager.close(con, pstmt, null);
		}
	}
	
	// 2. 매장 등록
	public static String registerRst(Restaurant rst) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = MinjuDBManager.connect();
			String sql = "insert into jun10_restaurant "
					+ "values(?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, rst.getLocation());
			pstmt.setString(2, rst.getOwner());
			pstmt.setInt(3, rst.getSeat());
			
			if (pstmt.executeUpdate() == 1) {
				return "매장 등록 성공";
			}
			return "";
		} catch (Exception e) {
			e.printStackTrace();
			return "매장 등록 실패";
		} finally {
			MinjuDBManager.close(con, pstmt, null);
		}
	}
	
	// 3. 전체 예약 확인 (예약번호 오름차순 정렬)
	public static ArrayList<Reservation> getAllRsv() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = MinjuDBManager.connect();
			String sql = "select * from jun10_reservation order by r_no";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			ArrayList<Reservation> rsvs = new ArrayList<Reservation>();
			Reservation r = null;
			while (rs.next()) {
				// Reservation 클래스의 멤버변수 X
				//	DB의 컬럼명 - O !
				r = new Reservation();
				r.setNo(rs.getInt("r_no"));
				r.setName(rs.getString("r_name"));
				r.setWhen(rs.getDate("r_time"));
				r.setPhoneNum(rs.getString("r_phone"));
				r.setLocation(rs.getString("r_location"));
				rsvs.add(r);
			}
			return rsvs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			MinjuDBManager.close(con, pstmt, rs);
		}
	}
	
	// 4. 전체 매장 확인 (지점명 오름차순 정렬)
	public static ArrayList<Restaurant> getAllRst() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = MinjuDBManager.connect();
			String sql = "select * from jun10_restaurant order by r_location";
			pstmt = con.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
			ArrayList<Restaurant> rsts = new ArrayList<Restaurant>();
			Restaurant r = null;
			while (rs.next()) {
				r = new Restaurant();
				r.setLocation(rs.getString("r_location"));
				r.setOwner(rs.getString("r_owner"));
				r.setSeat(rs.getInt("r_seat"));
				rsts.add(r);
			}
			return rsts;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			MinjuDBManager.close(con, pstmt, rs);
		}
	}
	
	// 5. 매장 찾기 (입력한 좌석 수 이상을 가지고 있는 매장, 지점명 오름차순 정렬)
	public static ArrayList<Restaurant> searchRst(int minSeat) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = MinjuDBManager.connect();
			String sql = "select * from jun10_restaurant where r_seat >= ? order by r_location";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, minSeat);
			rs = pstmt.executeQuery();
			ArrayList<Restaurant> rsts = new ArrayList<Restaurant>();
			
//			Restaurant r = null;
//			while (rs.next()) {
//				r = new Restaurant();
//				r.setLocation(rs.getString("r_location"));
//				r.setOwner(rs.getString("r_owner"));
//				r.setSeat(rs.getInt("r_seat"));
//				rsts.add(r);
//			}
			while (rs.next()) {
				rsts.add(new Restaurant(rs.getString("r_location"), rs.getString("r_owner"), rs.getInt("r_seat")));
			}
			return rsts;
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			MinjuDBManager.close(con, pstmt, rs);
		}	
	}
	
	// 6. 예약 찾기 (예약자의 이름으로 찾기, 예약번호 오름차순 정렬)
	public static ArrayList<Reservation> searchRsv(String name) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = MinjuDBManager.connect();
			String sql = "select * from jun10_reservation where r_name like '%'||?||'%' order by r_no";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, name);
			rs = pstmt.executeQuery();
			ArrayList<Reservation> rsvs = new ArrayList<Reservation>();
			while (rs.next()) {
				rsvs.add(new Reservation(rs.getInt("r_no"), rs.getString("r_name"), rs.getDate("r_time"), rs.getString("r_phone"), rs.getString("r_location")));
			}
			return rsvs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			MinjuDBManager.close(con, pstmt, rs);
		}
	}
	
	// 7. 예약정보수정 (예약자의 전화번호 수정하기)
	public static String updateRsv(Reservation r) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = MinjuDBManager.connect();
			String sql = "update jun10_reservation set r_phone = ? where r_no = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, r.getPhoneNum());
			pstmt.setInt(2, r.getNo());
			if (pstmt.executeUpdate() == 1) {
				return "예약 정보 수정 성공";
			}
			return "예약 정보 없음";
		} catch (Exception e) {
			e.printStackTrace();
			return "예약 정보 수정 실패";
		} finally {
			MinjuDBManager.close(con, pstmt, null);
		}
	}
	
	// 8. 예약 취소 (예약 번호로 취소하기)
	public static String deleteRsv(int no) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = MinjuDBManager.connect();
			String sql = "delete from jun10_reservation where r_no = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, no);
			if (pstmt.executeUpdate() == 1) {
				return "예약 취소 성공";
			}
			return "예약 정보 없음";
		} catch (Exception e) {
			e.printStackTrace();
			return "예약 취소 실패";
		} finally {
			MinjuDBManager.close(con, pstmt, null);
		}
	}
	
	
	
	
	
	
	
	
	
}
