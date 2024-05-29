package com.minju.may291.main;

import java.util.ArrayList;

// ArrayList
//	요소를 인덱스로 사용하는 것이 배열과 유사
//	배열 : 사이즈가 고정 => 데이터의 수가 배열의 크기보다 많아지면 저장이 불가능!
//	ArrayList : 저장되는 데이터의 수에 따라서 크기가 자동적으로 변경
//				요소가 가득차게 되면 ArrayList의 크기를 동적으로 증가시키고,
//				그 반대도 마찬가지!
//				자료형을 섞어서 데이터를 넣는게 가능 - 좋다? => 흠...

// 자료형을 통일하고 싶다 !
// <  > : generic
//		자료형을 고정하는 역할
//		클래스명<자료형의 객체형> 값을 넣으면 됨!

public class ListMain {
	public static void main(String[] args) {
		ArrayList test = new ArrayList();
		test.add("수요일");
		test.add(529);
		test.add("무 야 호");
		test.add(5.29);
		test.add(true);
		for (Object object : test) {	// 자료형이 통일되지 않아서 Object라는게 헷갈림
			System.out.println(object);
		}
		System.out.println("------------------");
		
		ArrayList<String> al = new ArrayList<>();
		al.add("파인애플");
//		System.out.println(al);
//		al.add(1);
		
		ArrayList<Integer> al2 = new ArrayList<Integer>();
		al2.add(new Integer(100));
		al2.add(50); // Auto-Boxing
		
		System.out.println(al2.get(0));
		System.out.println(al2.size());
		System.out.println("------------------");
		for (int i = 0; i < al2.size(); i++) {
			System.out.println(al2.get(i));
		}
		System.out.println("------------------");
		
		
	}
}
