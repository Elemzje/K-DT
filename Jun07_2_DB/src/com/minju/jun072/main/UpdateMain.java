package com.minju.jun072.main;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UpdateMain {
	public static void main(String[] args) {
		// 매장명입력 => 그 단어를 포함하는 모든 매장의 상품을 20% 할인된 가격으로 바꾸기
		Connection con = null;
		PreparedStatement pstmt = null;
		Scanner k = new Scanner(System.in);
		try {
			String addr = "jdbc:oracle:thin:@192.168.0.13:1521:xe";
			con = DriverManager.getConnection(addr, "minju", "3045");
			// 문제점 : 여기는 자바의 영역이기 때문에 !
			//	% (formatting) -> %?% => X !
			String sql = "update jun07_product set p_price = p_price * 0.8 where p_m_no in "
					+ "(select m_no from jun07_market "
					+ "where m_name like ?)";
//			+ "where m_name like '%'||?||'%')";
			// TODO pstmt.setString(1, name);
			pstmt = con.prepareStatement(sql);
			System.out.print("매장명 : ");
			String name = k.next();
			pstmt.setString(1, "%" + name + "%");
			if (pstmt.executeUpdate() >= 1) {
				System.out.println("Success !");
			} else {
				System.out.println("그런 매장 없습니다 ~");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		try {
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		k.close();
	}
}
