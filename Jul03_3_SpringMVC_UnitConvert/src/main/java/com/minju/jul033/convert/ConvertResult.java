package com.minju.jul033.convert;

import org.springframework.stereotype.Service;

@Service
public class ConvertResult {
	private double beforeNum;
	private int convertType;
	
	public ConvertResult() {
		// TODO Auto-generated constructor stub
	}

	public ConvertResult(double beforeNum, int convertType) {
		super();
		this.beforeNum = beforeNum;
		this.convertType = convertType;
	}

	public double getBeforeNum() {
		return beforeNum;
	}

	public void setBeforeNum(double beforeNum) {
		this.beforeNum = beforeNum;
	}

	public int getConvertType() {
		return convertType;
	}

	public void setConvertType(int convertType) {
		this.convertType = convertType;
	}
	
}
