package com.minju.franc.main;

import java.util.ArrayList;

import com.minju.franc.reservation.Reservation;
import com.minju.franc.restaurant.Restaurant;

public class Controller {
	// MVC 패턴 의 C - 실행과 코드의 흐름을 관리
//	if (번호 == 1) {
//		consolescreen.예약하기 기능 (입력)
//		dao.db관련 예약기능 (insert)
//		결과보여주기 (성공 or 실패)
//	}
	public static void main(String[] args) {
		int menu = 0;
		String result = null;
		Reservation rsv = null;
		Restaurant rst = null;
		ArrayList<Reservation> rsvResult = null;
		ArrayList<Restaurant> rstResult = null;
		int minSeat = 0;
		String name = null;
		int rNo = 0;
		System.out.println("<< 예약 프로그램 >>");
		while (true) {
			try {
				menu = ConsoleScreen.showMainMenu();
				if (menu == 1) {
					rsv = ConsoleScreen.showRsvMenu();
					result = DAO.book(rsv);
					ConsoleScreen.printResult(result);
				} else if (menu == 2) {
					rst = ConsoleScreen.showRstMenu();
					result = DAO.registerRst(rst);
					ConsoleScreen.printResult(result);
				} else if (menu == 3) {
					rsvResult = DAO.getAllRsv();
					ConsoleScreen.showRsvResultMenu(rsvResult);
				} else if (menu == 4) {
					rstResult = DAO.getAllRst();
					ConsoleScreen.showRstResultMenu(rstResult);
				} else if (menu == 5) {
					minSeat = ConsoleScreen.showSearchRstMenu();
					rstResult = DAO.searchRst(minSeat);
					ConsoleScreen.showRstResultMenu(rstResult);
				} else if (menu == 6) {
					name = ConsoleScreen.showSearchRsvMenu();
					rsvResult = DAO.searchRsv(name);
					ConsoleScreen.showRsvResultMenu(rsvResult);
				} else if (menu == 7) {
					rsvResult = DAO.getAllRsv();
					ConsoleScreen.showRsvResultMenu(rsvResult);
					
					rsv = ConsoleScreen.showUpdateRsvMenu();
					result = DAO.updateRsv(rsv);
					ConsoleScreen.printResult(result);
					
					rsvResult = DAO.getAllRsv();
					ConsoleScreen.showRsvResultMenu(rsvResult);
				} else if (menu == 8) {
					rsvResult = DAO.getAllRsv();
					ConsoleScreen.showRsvResultMenu(rsvResult);
					
					rNo = ConsoleScreen.showDeleteRsvMenu();
					result = DAO.deleteRsv(rNo);
					ConsoleScreen.printResult(result);
				} else if (menu == 9) {
					System.out.println("프로그램을 종료합니다.");
					break;
				} else {
					System.err.println("올바른 번호를 입력하세요");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
