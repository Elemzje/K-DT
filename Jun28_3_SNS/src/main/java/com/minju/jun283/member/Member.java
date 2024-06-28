package com.minju.jun283.member;

import java.util.Date;

public class Member {
	private String m_id;
	private String m_pw;
	private String m_name;
	private String m_phone_no;
	private Date m_birthday;
	private String m_img;
	
	public Member() {
		// TODO Auto-generated constructor stub
	}
	

	public Member(String m_id, String m_pw) {
		super();
		this.m_id = m_id;
		this.m_pw = m_pw;
	}


	public Member(String m_id, String m_pw, String m_name, String m_phone_no, Date m_birthday, String m_img) {
		super();
		this.m_id = m_id;
		this.m_pw = m_pw;
		this.m_name = m_name;
		this.m_phone_no = m_phone_no;
		this.m_birthday = m_birthday;
		this.m_img = m_img;
	}

	public String getM_id() {
		return m_id;
	}

	public void setM_id(String m_id) {
		this.m_id = m_id;
	}

	public String getM_pw() {
		return m_pw;
	}

	public void setM_pw(String m_pw) {
		this.m_pw = m_pw;
	}

	public String getM_name() {
		return m_name;
	}

	public void setM_name(String m_name) {
		this.m_name = m_name;
	}

	public String getM_phone_no() {
		return m_phone_no;
	}

	public void setM_phone_no(String m_phone_no) {
		this.m_phone_no = m_phone_no;
	}

	public Date getM_birthday() {
		return m_birthday;
	}

	public void setM_birthday(Date m_birthday) {
		this.m_birthday = m_birthday;
	}

	public String getM_img() {
		return m_img;
	}

	public void setM_img(String m_img) {
		this.m_img = m_img;
	}
}
