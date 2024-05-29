package com.minju.may234.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JLabel;
import javax.swing.JTextField;

// 계산
// String => double
//		=> Double.parseDouble();

// BMI : XX.X이고, 당신은 XX입니다.
// System.out.printf(); = String.format();
// String을 형식 잡아서 만들기

public class BMIFrame implements ActionListener {
	private JTextField f1;
	private JTextField f2;
	private JLabel f3;
	
	public BMIFrame() {
		// TODO Auto-generated constructor stub
	}

	public BMIFrame(JTextField f1, JTextField f2, JLabel f3) {
		super();
		this.f1 = f1;
		this.f2 = f2;
		this.f3 = f3;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		double height = Double.parseDouble(f1.getText());
		double weight = Double.parseDouble(f2.getText());
		double bmi = weight / ((height / 100) * (height / 100));
		String result = null;
		if (bmi < 18.5) {
			result = "저체중";
		} else if (bmi < 25) {
			result = "정상";
		} else if (bmi < 30) {
			result = "과체중";
		} else if (bmi < 35) {
			result = "경도비만";
		} else if (bmi < 40) {
			result = "중증도비만";
		} else {
			result = "고도비만";
		}
		String c = String.format("BMI : %.2f 이고, 당신은 %s입니다.", bmi, result); 
		f3.setText(c);
	}
}
