package com.minju.may233.human;

import com.beaver.may233.Avengers.Avengers;

public class Human {
	private String name;
	private Avengers hero;
	
	public Human() {
		// TODO Auto-generated constructor stub
	}
	public Human(String name) {
		super();
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void printInfo() {
		System.out.println(name);
	}
	
	public void pick(Avengers a) {
		hero = a;
		System.out.println("ㄷㄷㄷㅈ");
	}
	
	public void sayHelp() {
		System.out.println("도와줘요!");
		hero.attack();
	}
}
