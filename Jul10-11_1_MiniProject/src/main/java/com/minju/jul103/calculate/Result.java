package com.minju.jul103.calculate;

import java.math.BigDecimal;
import java.util.Date;

public class Result {
	private BigDecimal r_no;
	private String r_type;
	private String r_calcstr;
	private Date r_when;
	private String r_user;
	private BigDecimal r_start;
	private BigDecimal r_end;
	
	public Result() {
		// TODO Auto-generated constructor stub
	}

	public Result(BigDecimal r_no, String r_type, String r_calcstr, Date r_when, String r_user, BigDecimal r_start,
			BigDecimal r_end) {
		super();
		this.r_no = r_no;
		this.r_type = r_type;
		this.r_calcstr = r_calcstr;
		this.r_when = r_when;
		this.r_user = r_user;
		this.r_start = r_start;
		this.r_end = r_end;
	}

	public BigDecimal getR_no() {
		return r_no;
	}

	public void setR_no(BigDecimal r_no) {
		this.r_no = r_no;
	}

	public String getR_type() {
		return r_type;
	}

	public void setR_type(String r_type) {
		this.r_type = r_type;
	}

	public String getR_calcstr() {
		return r_calcstr;
	}

	public void setR_calcstr(String r_calcstr) {
		this.r_calcstr = r_calcstr;
	}

	public Date getR_when() {
		return r_when;
	}

	public void setR_when(Date r_when) {
		this.r_when = r_when;
	}

	public String getR_user() {
		return r_user;
	}

	public void setR_user(String r_user) {
		this.r_user = r_user;
	}

	public BigDecimal getR_start() {
		return r_start;
	}

	public void setR_start(BigDecimal r_start) {
		this.r_start = r_start;
	}

	public BigDecimal getR_end() {
		return r_end;
	}

	public void setR_end(BigDecimal r_end) {
		this.r_end = r_end;
	}
	
}
