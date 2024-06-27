package com.minju.jun261.apple;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.apache.jasper.tagplugins.jstl.core.ForEach;

import com.minju.db.manager.MinjuDBManager;

public class AppleDAO {
	private int allAppleCount;
	
	private static final AppleDAO APPLEDAO = new AppleDAO();
	
	private AppleDAO() {
	}
	
	public static AppleDAO getAppledao() {
		return APPLEDAO;
	}
	
	// 모든 사과 데이터 다 가져오기
	public void getAllApple(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = MinjuDBManager.connect("minjuPool");
			
			// sql문 작성
			String sql = "select * from jun26_apple order by a_price";
			pstmt = con.prepareStatement(sql);
			
			// C / U / D : pstmt.executeUpdate()로 실행
			//		=> 데이터 몇 개 영향을 받았는지
			// R : pstmt.executeQuery()로 실행
			//		=> select 결과를 ResultSet으로 보냄
			rs = pstmt.executeQuery();
			ArrayList<Apple> apples = new ArrayList<Apple>();
			Apple apple = null;
			while (rs.next()) {
				apple = new Apple(rs.getString("a_location"), rs.getString("a_color"), rs.getString("a_flavor"), rs.getInt("a_price"), rs.getString("a_introduce"));
				apples.add(apple);
			}
			request.setAttribute("apples", apples);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 등록하기
	public void reg(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		
		
		try {
			con = MinjuDBManager.connect("minjuPool");
			
			// 데이터 입력한거 받아오기
			request.setCharacterEncoding("UTF-8");
			String a_location = request.getParameter("a_location");
			String a_color = request.getParameter("a_color");
			String a_flavor = request.getParameter("a_flavor");
			int a_price = Integer.parseInt(request.getParameter("a_price"));
			
			// <textArea>에서 엔터친거 : \r\n
			// 웹페이지에서 줄바꾸기 : <br>
			String a_introduce = request.getParameter("a_introduce");
			a_introduce = a_introduce.replace("\r\n", "<br>");
			
			// sql문 작성
			String sql = "insert into jun26_apple values("
					+ "?, ?, ?, ?, ?)";
			
			// DB관련 총괄매니저
			pstmt = con.prepareStatement(sql);
			
			// sql완성
			pstmt.setString(1, a_location);
			pstmt.setString(2, a_color);
			pstmt.setString(3, a_flavor);
			pstmt.setInt(4, a_price);
			pstmt.setString(5, a_introduce);
			
			// sql문 실행
			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "[등록 성공]");
				allAppleCount++;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "[등록 실패]");
		}
		MinjuDBManager.close(con, pstmt, null);
	}
	
	// 총 데이터가 몇 개 인지
	
	public void getAllAppleCount() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = MinjuDBManager.connect("minjuPool");
			String sql = "select count(*) from jun26_apple";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rs.next();
			allAppleCount = rs.getInt("count(*)");
			MinjuDBManager.close(con, pstmt, rs);
		} catch (Exception e) {
		}
	}
	
	// DB에 데이터가 100개 있다 ? => 해당 페이지 번호에 맞는 데이터만 가져오기
	
	public void getPage(int pageNum, HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = MinjuDBManager.connect("minjuPool");
			
			// allAppleCount : 전체 사과 데이터 수
			int applePerPage = 4; // 한 페이지당 보여줄 사과 데이터 수
			
			// 페이지 갯수 가져오기
			// Math.ceil : 숫자 올림 (반올림 X)
			int pageCount = (int) Math.ceil(allAppleCount / (double) applePerPage);
			request.setAttribute("pageCount", pageCount);
			/////////////////////////////////////////////////////////////////////
			int start = (applePerPage * (pageNum - 1)) + 1;
			int end = (pageNum == pageCount) ? allAppleCount : (start + applePerPage - 1);
			
			String sql = "select * from (select rownum rn, a_location, a_color, a_flavor, a_price, a_introduce from "
					+ "(select * from jun26_apple order by a_price)"
					+ ") where rn between ? and ?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			
			ArrayList<Apple> apples = new ArrayList<Apple>();
			Apple apple = null;
			
			while (rs.next()) {
				apple = new Apple(rs.getString("a_location"), rs.getString("a_color"), rs.getString("a_flavor"), rs.getInt("a_price"), rs.getString("a_introduce"));
				apples.add(apple);
			}
			request.setAttribute("apples", apples);
			MinjuDBManager.close(con, pstmt, rs);
		} catch (Exception e) {
			e.printStackTrace();
		}
				
	}
	
	// 상세정보 가져오기 (Primary key)
	// 제대로 데이터를 가져왔으면 : true
	// 실패했으면 : false
	
	public boolean getDetail(HttpServletRequest request) {
		String location = request.getParameter("d");
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			con = MinjuDBManager.connect("minjuPool");
			String sql = "select * from jun26_apple where a_location = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, location);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				Apple apple = new Apple(rs.getString("a_location"), rs.getString("a_color"), rs.getString("a_flavor"), rs.getInt("a_price"), rs.getString("a_introduce"));
				request.setAttribute("apple", apple);
				return true;
			}
			return false;	// ex) 다른 사람이 그 데이터를 지웠으면 : 데이터 없음
		} catch (Exception e) {
			e.printStackTrace();
			return false;	// DB서버 상태가 안좋음 (ex : 서버가 안켜짐)
		} finally {
			MinjuDBManager.close(con, pstmt, rs);
		}
	}
	
	public boolean updateDetail(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			request.setCharacterEncoding("UTF-8");
			con = MinjuDBManager.connect("minjuPool");
			String sql = "update jun26_apple set a_color = ?, "
					+ "a_flavor = ?, a_price = ?, a_introduce = ? "
					+ "where a_location = ?";
			String introduce = request.getParameter("a_introduce");
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, request.getParameter("a_color"));
			pstmt.setString(2, request.getParameter("a_flavor"));
			pstmt.setInt(3, Integer.parseInt(request.getParameter("a_price")));
			pstmt.setString(4, introduce);
			pstmt.setString(5, request.getParameter("a_location"));
			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "[수정 성공]");
				return true;
			} else {
				request.setAttribute("r", "[수정 실패]");
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "[수정 실패]");
			return false;
		} finally {
			MinjuDBManager.close(con, pstmt, null);
		}
	}
	
	public void delete(HttpServletRequest request) {
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = MinjuDBManager.connect("minjuPool");
			String location = request.getParameter("d");
			String sql = "delete from jun26_apple where a_location = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, location);
			
			if (pstmt.executeUpdate() == 1) {
				request.setAttribute("r", "[삭제 성공]");
				allAppleCount--;
			} else {
				request.setAttribute("r", "[삭제 실패]");
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "[삭제 실패]");
		}
		MinjuDBManager.close(con, pstmt, null);
	}
	
}
