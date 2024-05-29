package com.minju.may225.bite;

// 클래스 : 멤버변수, 메소드

// 추상메소드 : 멤버변수, 메소드, 추상메소드
//			=> 객체생성 불가능

// 인터페이스 : 추상메소드, 멤버 상수
//			=> 객체생성 불가


public interface Bite {
//	private int a;		// 멤버변수 X
	public static final int B = 3;	// 멤버상수 O
	
//	public void c() {
//		System.out.println("c");
//	}	// 메소드 X
	
	public abstract void bite();
}
