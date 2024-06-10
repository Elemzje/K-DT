package com.minju.franc.reservation;

import java.util.Date;

// DTO, VO, JavaBean
public class Reservation {
	private int no;
	private String name;
	private Date when;
	private String phoneNum;
	private String location;
	
	public Reservation() {
		// TODO Auto-generated constructor stub
	}

	public Reservation(int no, String name, Date when, String phoneNum, String location) {
		super();
		this.no = no;
		this.name = name;
		this.when = when;
		this.phoneNum = phoneNum;
		this.location = location;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getWhen() {
		return when;
	}

	public void setWhen(Date when) {
		this.when = when;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	
}
