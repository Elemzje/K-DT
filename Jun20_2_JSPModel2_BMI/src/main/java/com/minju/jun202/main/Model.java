package com.minju.jun202.main;

import java.net.URLEncoder;

import javax.servlet.http.HttpServletRequest;

import com.oreilly.servlet.MultipartRequest;

public class Model {
	public static void calcBMI(HttpServletRequest request, MultipartRequest mr) {
		try {
			String name = mr.getParameter("name");
			double w = Double.parseDouble(mr.getParameter("weight"));
			double h = Double.parseDouble(mr.getParameter("height")) / 100;
			double bmi = w / (h * h);
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
			String bmis = String.format("%.2f", bmi);
			double bmi2 = Double.parseDouble(bmis);
			String photo = mr.getFilesystemName("photo");
			photo = URLEncoder.encode(photo, "UTF-8");
			photo = photo.replace("+", " ");
			Guest g = new Guest(name, h, w, bmi2, result, photo);
			// mr.setAttribute("g", g);
			//	MultipartRequest는 단순히 form의 내용과 파일 등을 받아오기 위한 용도
			// HttpServletRequest 클래스를 활용해서만 attribute를 생성할 수 있음 !!
			request.setAttribute("g", g);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
}
