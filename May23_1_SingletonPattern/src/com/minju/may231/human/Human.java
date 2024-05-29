package com.minju.may231.human;

public class Human {
	private String name;
	private int age;
	private String nickname;
	
	private static final Human HUMAN = new Human("주민", 25, "마을주민");
	
	
	public static Human getHuman() {
		return HUMAN;
	}

	public Human() {
		// TODO Auto-generated constructor stub
	}

	public Human(String name, int age, String nickname) {
		super();
		this.name = name;
		this.age = age;
		this.nickname = nickname;
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

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	
	public void printInfo() {
		System.out.println(name);
		System.out.println(age);
		System.out.println(nickname);
	}
}
