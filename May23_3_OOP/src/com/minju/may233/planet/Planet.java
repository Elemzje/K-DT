package com.minju.may233.planet;

import com.minju.may233.human.Human;

public class Planet {
	private String name;
	private int size;
	private boolean seeable;
	
	public Planet() {
		// TODO Auto-generated constructor stub
	}

	public Planet(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public boolean isSeeable() {
		return seeable;
	}

	public void setSeeable(boolean seeable) {
		this.seeable = seeable;
	}
	
	public void printInfo() {
		System.out.println(name);
		System.out.println(size);
		System.out.println(seeable);
	}
	
	public void add(Human h) {
		System.out.printf("%s에 어서오세요 %s님\n", this.name, h.getName());
	}
}
