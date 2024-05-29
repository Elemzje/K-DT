package com.minju.may234.main;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.minju.may234.frame.BMIFrame;

public class GMain4 {
	public static void main(String[] args) {
		// 제목이 BMI검사인 JFrame
		JFrame jf = new JFrame("BMI 검사");
		
		// 3행 2열짜리 GridLayout
		GridLayout gl = new GridLayout(3,2);
		
		// JFrame의 레이아웃 속성을 gl로 사용
		jf.setLayout(gl);
		
		JLabel l1 = new JLabel("키 (CM)");
		jf.add(l1);
		JTextField f1 = new JTextField(10);
		jf.add(f1);
		JLabel l2 = new JLabel("체중 (KG)");
		jf.add(l2);
		JTextField f2 = new JTextField(10);
		jf.add(f2);
		JLabel f3 = new JLabel();
		jf.add(f3);
		JButton b = new JButton("확인");
		jf.add(b);
		
		
		BMIFrame bFrame = new BMIFrame(f1, f2, f3);
		b.addActionListener(bFrame);
		
		jf.setSize(600, 400);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setVisible(true);
	}
}
