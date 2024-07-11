package com.minju.jul103.calculate;

import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.minju.jul103.member.Member;

import oracle.net.aso.b;

@Service
public class CalcDAO {

	@Autowired
	private SqlSession ss;
	
	public void calcBMI(BMI b, HttpServletRequest req) {
		double h = b.getB_height() / 100;
		double w = b.getB_weight();
		double bmi = w / (h * h);
		String bmi2 = String.format("%.2f", bmi);
		String result = "저체중";
		if (bmi > 40) {
			result = "고도비만";
		} else if (bmi > 35) {
			result = "중증도비만";
		} else if (bmi > 30) {
			result = "경도비만";
		} else if (bmi > 25) {
			result = "과체중";
		} else if (bmi > 18) {
			result = "정상";
		}
		result = bmi2 + ", " + result;
		req.setAttribute("r_calcstr", result);
	}
	
	public void calcBase(Base b, HttpServletRequest req) {
		int aBase = b.getB_afterBase();
		int num = b.getB_integer();
		String result = null;
		if (aBase == 2) {
			result = Integer.toBinaryString(num);
		} else {
			result = Integer.toString(num, aBase).toUpperCase();
		}
		result = result + " (" + aBase + ")";
		req.setAttribute("r_calcstr", result);
	}
	
	public void calcUnit(Unit u, HttpServletRequest req) {
		int type = u.getU_unit();
		int num = u.getU_value();
		String name = "bmi";
		String result = null;
		switch (type) {
		case 1:
			result =String.format("%.2fm/s", (double) num / 3.6);
			break;
		case 2:
			result =String.format("%.2f평", (double) num / 3.306);
			break;
		case 3:
			result =String.format("%.2fyd", (double) num * 1.094);
			break;
		case 4:
			result =String.format("%.2flb", (double) num * 2.205);
			break;
		}
		req.setAttribute("r_calcstr", result);
	}

	public void calcASCII(ASCII a, HttpServletRequest req) {
		int type = a.getA_type();
		String str = a.getA_str();
		byte[] bytes = str.getBytes(StandardCharsets.US_ASCII);
		String[] strar;
		String result = "";
		if (type == 1) {
			for (int i = 0; i < bytes.length; i++) {
				result += Integer.toString(Byte.toUnsignedInt(bytes[i]), 16).toUpperCase() + " ";
			}
		} else if (type == 2) {
			strar = str.split(" ");
			for (int i = 0; i < strar.length; i++) {
				result += (char) Integer.parseInt(strar[i], 16);
			}
		}
		req.setAttribute("r_calcstr", result);
	}
	
	
	
	public void insertResult(Result r, HttpServletRequest req) {
		String r_user = ((Member) req.getSession().getAttribute("loginMember")).getM_id(); 
		r.setR_calcstr((String) req.getAttribute("r_calcstr"));
		r.setR_user(r_user);
		String token = req.getParameter("token");
		String formerToken = (String) req.getSession().getAttribute("formerToken");
		try {
			if (formerToken == null || !token.equals(formerToken)) {
				if (ss.getMapper(CalcMapper.class).insertResult(r) == 1) {
					req.setAttribute("cr", "1");
				} else {
					req.setAttribute("cr", "0");
				}
				req.getSession().setAttribute("formerToken", token);
			} else {
				req.setAttribute("cr", "0");
			}
		} catch (Exception e) {
			req.setAttribute("cr", "0");
			e.printStackTrace();
		}
	}
	
	private int userResultCount(Result r, HttpServletRequest req) {
		return ss.getMapper(CalcMapper.class).selectUserCount(r);
	}
	
	public void getUserResult(int p, Result r, HttpServletRequest req) {
		r.setR_user(((Member) req.getSession().getAttribute("loginMember")).getM_id());
		int userResult = userResultCount(r, req);
		int resultPerPage = 3;
		int pageCount = (int) Math.ceil(userResult / (double) resultPerPage);
		req.setAttribute("p", p);
		req.setAttribute("pageCount", pageCount);
		int start = (resultPerPage * (p - 1)) + 1;
		int end = (p == pageCount) ? userResult : (start + resultPerPage - 1);
		r.setR_start(BigDecimal.valueOf(start));
		r.setR_end(BigDecimal.valueOf(end));
		req.setAttribute("results", ss.getMapper(CalcMapper.class).selectAllResult(r));
	}
	
}
