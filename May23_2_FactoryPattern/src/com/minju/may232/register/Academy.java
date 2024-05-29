package com.minju.may232.register;

// 공장 역할을 할 클래스
public class Academy {
	private int studentCount;
	
	// 객체 만들때 사용할 메소드
	public Student consult(String name, int age) {
		studentCount++;
		Student s = new Student(name, age, studentCount);
		return s;
	}
}
