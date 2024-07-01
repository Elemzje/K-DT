package com.minju.jun283.board;

import java.util.Date;

public class Board {
	private int b_no;
	private String b_m_id;
	private String b_content;
	private Date b_time;
	private String m_img;
	
	public Board() {
		// TODO Auto-generated constructor stub
	}

	public Board(int b_no, String b_m_id, String b_content, Date b_time, String m_img) {
		super();
		this.b_no = b_no;
		this.b_m_id = b_m_id;
		this.b_content = b_content;
		this.b_time = b_time;
		this.m_img = m_img;
	}

	public int getB_no() {
		return b_no;
	}

	public void setB_no(int b_no) {
		this.b_no = b_no;
	}

	public String getB_m_id() {
		return b_m_id;
	}

	public void setB_m_id(String b_m_id) {
		this.b_m_id = b_m_id;
	}

	public String getB_content() {
		return b_content;
	}

	public void setB_content(String b_content) {
		this.b_content = b_content;
	}

	public Date getB_time() {
		return b_time;
	}

	public void setB_time(Date b_time) {
		this.b_time = b_time;
	}

	public String getM_img() {
		return m_img;
	}

	public void setM_img(String m_img) {
		this.m_img = m_img;
	}
	
	
	
}
