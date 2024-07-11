package com.minju.jul103.calculate;

public class BMI {
	private double b_height;
	private double b_weight;
	public BMI() {
		// TODO Auto-generated constructor stub
	}
	public BMI(double b_height, double b_weight) {
		super();
		this.b_height = b_height;
		this.b_weight = b_weight;
	}
	public double getB_height() {
		return b_height;
	}
	public void setB_height(double b_height) {
		this.b_height = b_height;
	}
	public double getB_weight() {
		return b_weight;
	}
	public void setB_weight(double b_weight) {
		this.b_weight = b_weight;
	}
}
