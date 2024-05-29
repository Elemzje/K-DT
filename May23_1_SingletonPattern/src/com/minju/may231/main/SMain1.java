package com.minju.may231.main;

import com.minju.may231.human.Human;

// 원하는 객체 하나 생성
// 이름, 나이, 별명
// 출력

// 유일한 사람이었으면 좋겠음 !
// 디자인 패턴 프로그래밍 중에
//		*** 싱글톤 패턴 (Singleton Pattern)
// 클래스가 최초 한번만 메모리를 할당하고 (Static)
//		그 메모리에 객체를 만들어서 사용하는 디자인 패턴
// 고정된 메모리 영역을 얻으면서 하나의 객체를 사용하기 때문에
//		메모리 낭비를 방지할 수 있음
public class SMain1 {
	public static void main(String[] args) {
//		Human h1 = new Human("이민주", 21, "별종");
//		h1.printInfo();
//		System.out.println(h1);
//		System.out.println("--------------");
//		Human h2 = new Human("이민주", 21, "별종");
//		h2.printInfo();
//		System.out.println(h2);
//		System.out.println("--------------");
		
		Human h1 = Human.getHuman();
		h1.printInfo();
		System.out.println(h1);
		System.out.println("==============");
		Human h2 = Human.getHuman();
		h2.printInfo();
		System.out.println(h2);
		System.out.println("==============");
	}
}
