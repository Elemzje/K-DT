package com.minju.jun261.apple;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import com.minju.db.manager.MinjuDBManager;

public class AppleDAO {
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
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			request.setAttribute("r", "[등록 실패]");
		}
		MinjuDBManager.close(con, pstmt, null);
	}
}
