package com.minju.may232.register;

public class Student {
	private String name;
	private int age;
	private int number;
	
	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(String name, int age, int number) {
		super();
		this.name = name;
		this.age = age;
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	public int getNumber() {
		return number;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	public void printInfo() {
		System.out.println(name);
		System.out.println(age);
		System.out.println(number);
	}
	
}
