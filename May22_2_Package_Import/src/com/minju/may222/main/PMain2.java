package com.minju.may222.main;

import java.util.Random;
// PMain2.java에서 쓰는 Scanner는 무조건 이것만 사용하겠다
import java.util.Scanner;

import com.minju.may222.product.Computer;

// 패키지 : 클래스명이 중복될 때 구별할 수 있는 수단!!
//			모든 클래스는 패키지에 넣을 수 있도록!!!

// 패키지명이 중복? 똑같으면? => 방법이 없음
//		=> 전 세계적으로 패키지명이 중복 안되게
//	com.회사명.프로그램명.카테고리 (소문자!)
//	kr.co.회사명.프로그램명.카테고리

// 객체
//		패키지명.클래스명 변수명 = new 패키지명.생성자();

public class PMain2 {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		java.util.Random r = new java.util.Random();
		@SuppressWarnings("resource")
		Scanner k = new Scanner(System.in);
		
		com.minju.may222.product.Scanner s =
					new com.minju.may222.product.Scanner("test", 1000);
		
		// 객체 만들 때 패키지명을 생략 가능한 경우
		//		- 자바 기본 패키지(java.lang) 소속
		/* java.lang. */String ss = "ㅋ";
		/* java.lang. */System.out.println("a");
		
		// 같은 패키지 소속
		com.minju.may222.main.Minjuu m = new com.minju.may222.main.Minjuu();
		Minjuu m2 = new Minjuu();
		
		// 다른 패키지 소속
		com.minju.may222.product.Computer c = new Computer();
		Computer c2 = new Computer();
		
		
		// ctrl + shift + o 를 활용해서 : import 정리!
		Random r2 = new Random();
		
	}
}
