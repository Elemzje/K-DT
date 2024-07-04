package com.minju.jul042.test;

import java.math.BigDecimal;
import java.util.Date;


public class Test {
	private BigDecimal t_no;
	private String t_subject;
	private String t_y;
	private String t_m;
	private String t_d;
	private Date t_date;
	
	public Test() {
		// TODO Auto-generated constructor stub
	}

	public Test(BigDecimal t_no, String t_subject, String t_y, String t_m, String t_d, Date t_date) {
		super();
		this.t_no = t_no;
		this.t_subject = t_subject;
		this.t_y = t_y;
		this.t_m = t_m;
		this.t_d = t_d;
		this.t_date = t_date;
	}

	public BigDecimal getT_no() {
		return t_no;
	}

	public void setT_no(BigDecimal t_no) {
		this.t_no = t_no;
	}

	public String getT_subject() {
		return t_subject;
	}

	public void setT_subject(String t_subject) {
		this.t_subject = t_subject;
	}

	public String getT_y() {
		return t_y;
	}

	public void setT_y(String t_y) {
		this.t_y = t_y;
	}

	public String getT_m() {
		return t_m;
	}

	public void setT_m(String t_m) {
		this.t_m = t_m;
	}

	public String getT_d() {
		return t_d;
	}

	public void setT_d(String t_d) {
		this.t_d = t_d;
	}

	public Date getT_date() {
		return t_date;
	}

	public void setT_date(Date t_date) {
		this.t_date = t_date;
	}

	
}
