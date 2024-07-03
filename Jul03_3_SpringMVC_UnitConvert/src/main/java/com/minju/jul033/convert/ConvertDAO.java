package com.minju.jul033.convert;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Service;

@Service
public class ConvertDAO {
	
	private HashMap<Integer, String> unit;
	
	public void setUnit(HashMap<Integer, String> unit) {
		this.unit = unit;
	}

	public static void unitConverter(ConvertResult cr, HttpServletRequest req) {
		double beforeNum = cr.getBeforeNum();
		int convertType = cr.getConvertType();
		String beforeUnitType = null;
		String afterUnitType = null;
		double afterNum = 0;
		String color = null;
		switch (convertType) {
		case 1:
			beforeUnitType = "cm";
			afterNum = beforeNum / 2.54;
			afterUnitType = "inch";
			color = "red";
			break;
		case 2:
			beforeUnitType = "㎡";
			afterNum = beforeNum * 0.3025;
			afterUnitType = "평";
			color = "green";
			break;
		case 3:
			beforeUnitType = "℃";
			afterNum = (beforeNum * (9 / 5)) + 32;
			afterUnitType = "℉";
			color = "blue";
			break;
		case 4:
			beforeUnitType = "mi/h";
			afterNum = beforeNum * 1.60934;
			afterUnitType = "km/h";
			color = "pink";
			break;
		}
		String afterNumStr = String.format("%.2f", afterNum);
		req.setAttribute("color", color);
		req.setAttribute("beforeNum", beforeNum);
		req.setAttribute("beforeUnitType", beforeUnitType);
		req.setAttribute("afterNum", afterNumStr);
		req.setAttribute("afterUnitType", afterUnitType);
	}
}
