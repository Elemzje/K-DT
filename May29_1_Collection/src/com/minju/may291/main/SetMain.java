package com.minju.may291.main;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;

// Set 계열
//		가변사이즈
//		중복데이터 자동 삭제
//			같은 데이터 여러번 들어가면 하나만 남김
//		순서가 랜덤
//		HashSet, TreeSet, ...
//			=> 실전에서는 그닥 유용하지 않음

public class SetMain {
	public static void main(String[] args) {
		HashSet<String> hs = new HashSet<String>();
		hs.add("ㅁㅁ");
		hs.add("ㄴㄴ");
		hs.add("ㅎㅎ");
		hs.add("ㄹㄹ");
		hs.add("ㅎㅎ");
		hs.add("ㄹㄹ");
		System.out.println(hs.size());
		System.out.println("-----------------------");
		for (String s : hs) {
			System.out.println(s);
		}
		System.out.println("-----------------------");
		
		// ArrayList로 데이터를 넣자! => 정수 10개 (같은 값이 있도록)
		// 중복 제거해서
		// 내림차순 정렬 출력
		
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(14);
		al.add(15);
		al.add(25);
		al.add(36);
		al.add(52);
		al.add(14);
		al.add(171);
		al.add(1);
		al.add(124);
		al.add(171);
		HashSet<Integer> hs2 = new HashSet<Integer>(al);
		for (Integer i : hs2) {
			System.out.println(i);
		}
		Comparator<Integer> c = new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o2.compareTo(o1);
			}
		};
		al = new ArrayList<Integer>(hs2);
		al.sort(c);
		System.out.println(al);
	}
}
