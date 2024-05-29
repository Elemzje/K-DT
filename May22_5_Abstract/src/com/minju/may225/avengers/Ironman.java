package com.minju.may225.avengers;

import com.minju.may225.driver.Driver;
import com.minju.may225.smoker.Smoker;

public class Ironman extends Avengers implements Smoker, Driver {
	private int property;
	
	public Ironman() {
		// TODO Auto-generated constructor stub
	}

	public Ironman(String name, int age, int property) {
		super(name, age);
		this.property = property;
	}

	public int getproperty() {
		return property;
	}

	public void setproperty(int property) {
		this.property = property;
	}
	
	@Override
	public void printInfo() {
		super.printInfo();
		System.out.println(property);
	}
	
	@Override
	public void attack() {
		System.out.println("빔~~");
	}
	
	@Override
	public void drive() {
		System.out.println("O");
	}
	
	@Override
	public void smoke() {
		System.out.println("O");
	}
}
