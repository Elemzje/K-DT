package com.minju.may242.main;

// Wrapper Class : (자료형) 기본형들의 객체형 (포장객체)
//	Integer, Double, Long, Void, Boolean, ...
//	기본 자료형을 객체로 다루기 위해서 사용하는 Class
//	Java의 기본형은 값을 가지고 있는 객체 생성이 가능
//	기본형이 가지고 있는 값을 내부에 두고 그 위를 포장하는 방식

//	1. 객체나 클래스가 제공하는 method 사용할 때
//	2. 클래스가 제공하는 상수를 사용(MIN_VALUE, MAX_VALUE, ...)
//	3. 숫자, 문자로 형변환을 할 때 (v)

public class WMain {
	@SuppressWarnings({ "unused", "static-access" })
	public static void main(String[] args) {
		int a = 10;
		String a1 = "100";
//		double bb = (double) a;
//		double bbb = (double) a1;
		
		// Integer 객체를 생성 => 정수값을 넣어서 => int형으로 return
		Integer b = new Integer(a1);
		System.out.println(b.getClass());
		System.out.println(b.TYPE);
		b.intValue();
		System.out.println(b);
		System.out.println(b.TYPE);
		
		// 기본형 -> 객체형 (Boxing)
		double c = 123.456;
		Double d = new Double(c);
		
		// 객체형 -> 기본형 (Unboxing)
		Boolean e = new Boolean(true);
		boolean f = e.booleanValue();
		
		// 객체형 -> 기본형 (위의 과정을 자동으로 해줌 : Auto-Unboxing)
		Integer g = 10;
		
		// 기본형 -> 객체형 (위의 과정을 자동으로 해줌 : Auto-Boxing)
		int h = g;
		
		int max = Integer.MAX_VALUE;
		System.out.println(max);
		int min = Integer.MIN_VALUE;
		System.out.println(min);
		
		// int의 자료형을 String(문자열)로
		String num1 = Integer.toString(321);
		
		// String -> 기본형 (다이렉트로는 힘들고, 객체형을 거쳐야)
		// String -> 객체형 -> 기본형
		String k = "345.67";
		Double k2 = Double.parseDouble(k);
		double k3 = k2.doubleValue();
		
		// Auto-Unboxing에 의해서 지금처럼 표현 가능
		String m = "150";
		int m2 = Integer.parseInt(m);
		
		
		
		
		
	}
}
