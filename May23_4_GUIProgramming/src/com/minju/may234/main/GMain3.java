package com.minju.may234.main;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.minju.may234.frame.TempFrame;

// 화씨온도 => 섭씨온도 변환기
public class GMain3 {
	public static void main(String[] args) {
		JFrame jf = new JFrame();
		JPanel jp = new JPanel();
		jf.add(jp);
		
		JLabel l1 = new JLabel("화씨온도 : ");
		JTextField f1 = new JTextField(15);
		JLabel l2 = new JLabel("섭씨온도 : ");
		JTextField f2 = new JTextField(15);
		JButton b = new JButton("변환");
		
		jp.add(l1);
		jp.add(f1);
		jp.add(l2);
		jp.add(f2);
		jp.add(b);
		
		TempFrame tFrame = new TempFrame(f1,f2);
		b.addActionListener(tFrame); // 버튼 눌렀을 때 기능 동작하게!
		
		jf.setSize(300, 150);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setTitle("온도 변환기");
		jf.setVisible(true);
	}
}
