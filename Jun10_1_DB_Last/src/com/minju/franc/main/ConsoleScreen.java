package com.minju.franc.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import com.minju.franc.reservation.Reservation;
import com.minju.franc.restaurant.Restaurant;

@SuppressWarnings("resource")
public class ConsoleScreen {
	// 사용자가 콘솔을 볼 수 있거나, 콘솔에 입력할 수 있게 (MVC의 V)
	// 아래 메뉴를 볼 수 있는 기능도 있었으면 !
	public static int showMainMenu() {
		Scanner k = new Scanner(System.in);
		System.out.println("=============================");
		System.out.println("메뉴");
		System.out.println("1. 예약");
		System.out.println("2. 매장 등록(사장님)");
		System.out.println("3. 예약 확인");
		System.out.println("4. 매장 조회");
		System.out.println("5. 매장 찾기");
		System.out.println("6. 예약 찾기");
		System.out.println("7. 예약 정보 수정");
		System.out.println("8. 예약 취소");
		System.out.println("9. 프로그램 종료");
		System.out.println("=============================");
		System.out.print("메뉴 선택> ");
		return k.nextInt();
	}
	
	public static void printResult(String result) {
		System.out.println(result);
	}
	
	// 1. 예약하기 (직접 입력, 날짜는 연-월-일/시:분)
	public static Reservation showRsvMenu() throws ParseException {
		Scanner k = new Scanner(System.in);
		System.out.print("예약자 : ");
		String name = k.next();
		
		System.out.print("예약 날짜(YYYY-MM-DD/HH:mm) : ");
		String when = k.next();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd/HH:mm");
		Date when2 = sdf.parse(when);
		
		System.out.print("연락처 : ");
		String phoneNum = k.next();
		
		System.out.print("예약 지점명 : ");
		String location = k.next();
		
		Reservation r = new Reservation(0, name, when2, phoneNum, location);
		return r;
	}
		
	// 2. 매장등록 (지점명, 지점장, 좌석수)
	public static Restaurant showRstMenu() {
		Scanner k = new Scanner(System.in);
		System.out.print("지점명 : ");
		String location = k.next();
		
		System.out.print("지점장 : ");
		String owner = k.next();
		
		System.out.print("좌석 수 : ");
		int seat = k.nextInt();
		
		Restaurant r = new Restaurant(location, owner, seat);
		return r;
	}
	
	// 3. 전체 예약 확인 (날짜는 연-월-일 요일 오전/오후 시:분)
	public static void showRsvResultMenu(ArrayList<Reservation> rsvs) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd E a HH:mm");
		for (Reservation r : rsvs) {
			System.out.printf("%d) ", r.getNo());
			System.out.printf("[%s - ", r.getName());
			System.out.printf("%s] - ", r.getPhoneNum());
			System.out.print(r.getLocation() + " - ");
			System.out.println(sdf.format(r.getWhen()));
		}
	}
	
	// 4. 전체 매장 조회 ( 위치(좌석 수) - 사장님 이름 의 형식)
	public static void showRstResultMenu(ArrayList<Restaurant> rsts) {
		for (Restaurant r : rsts) {
			System.out.printf("%s(%d) - %s\n", r.getLocation(), r.getSeat(), r.getOwner());
		}
	}
	
	// 5. 매장 찾기 (최소 좌석 수 입력 => 좌석 수 이상의 매장의 정보를 출력
	public static int showSearchRstMenu() {
		Scanner k = new Scanner(System.in);
		System.out.println("입력한 좌석 수 이상의 매장을 보여드립니다");
		System.out.print("좌석 수> ");
		return k.nextInt();
	}
	
	
	// 6. 예약 찾기 (예약자 이름 입력) 
	public static String showSearchRsvMenu() {
		Scanner k = new Scanner(System.in);
		System.out.print("예약자> ");
		return k.next();
	}
	
	// 7. 예약 정보 수정 (예약번호를 입력하면, 연락처를 변경)
	public static Reservation showUpdateRsvMenu() {
		Scanner k = new Scanner(System.in);
		System.out.print("예약 번호 : ");
		Reservation r = new Reservation();
		r.setNo(k.nextInt());
		System.out.print("연락처 변경 : ");
		r.setPhoneNum(k.next());
		return r;
	}
	
	// 8. 예약 취소 (예약번호로 취소)
	public static int showDeleteRsvMenu() {
		Scanner k = new Scanner(System.in);
		System.out.print("예약 번호 : ");
		return k.nextInt();
	}
	
	// 9. 종료
	
}
