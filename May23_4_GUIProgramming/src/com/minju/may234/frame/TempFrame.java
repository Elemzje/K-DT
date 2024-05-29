package com.minju.may234.frame;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;

import javax.swing.JTextField;

public class TempFrame implements ActionListener {
	private JTextField f1;
	private JTextField f2;
	
	public TempFrame() {
		// TODO Auto-generated constructor stub
	}

	public TempFrame(JTextField f1, JTextField f2) {
		super();
		this.f1 = f1;
		this.f2 = f2;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		double fahrenheit = Double.parseDouble(f1.getText());
		double celcius = (double) 5 / 9 * (fahrenheit - 32);
		
		String c = new DecimalFormat("##.####").format(celcius);
		f2.setText(c);
	}
}