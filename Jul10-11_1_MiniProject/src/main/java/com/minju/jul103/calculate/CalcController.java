package com.minju.jul103.calculate;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.minju.jul103.member.MemberDAO;

@Controller
public class CalcController {
	
	@Autowired
	private CalcDAO cDAO;
	@Autowired
	private MemberDAO mDAO;
	@Autowired
	private TokenManager tm;
	
	@RequestMapping(value="/calcpage.show", method=RequestMethod.GET)
	public String showCalculatePage(HttpServletRequest req) {
		if (mDAO.loginCheck(req)) {
			String type = req.getParameter("r_type");
			if ("BMI".equals(type)) {
			    req.setAttribute("contentPage", "BMIPage.jsp");
			} else if ("Base".equals(type)) {
			    req.setAttribute("contentPage", "BasePage.jsp");
			} else if ("Unit".equals(type)) {
			    req.setAttribute("contentPage", "UnitPage.jsp");
			} else if ("ASCII".equals(type)) {
			    req.setAttribute("contentPage", "ASCIIPage.jsp");
			} else {
			    req.setAttribute("r", "잘못된 접근");
			    req.setAttribute("contentPage", "mainmenu.jsp");
			}
			tm.make(req);
		} else {
			req.setAttribute("r", "로그인이 필요한 시스템입니다");
			req.setAttribute("contentPage", "mainmenu.jsp");
		}
		return "index";
	}
	
	@RequestMapping(value="/BMI.Calculate", method=RequestMethod.GET)
	public String insertBMIResult(BMI b, Result r, HttpServletRequest req) {
		if (mDAO.loginCheck(req)) {
			cDAO.calcBMI(b, req);
			cDAO.insertResult(r, req);
			req.setAttribute("contentPage", "BMIPage.jsp");
		} else {
			req.setAttribute("r", "로그인이 필요한 시스템입니다");
			req.setAttribute("contentPage", "mainmenu.jsp");
		}
		tm.make(req);
		return "index";
	}
	
	@RequestMapping(value="/Base.Calculate", method=RequestMethod.GET)
	public String insertBaseResult(Base b, Result r, HttpServletRequest req) {
		if (mDAO.loginCheck(req)) {
			cDAO.calcBase(b, req);
			cDAO.insertResult(r, req);
			req.setAttribute("contentPage", "BasePage.jsp");
		} else {
			req.setAttribute("r", "로그인이 필요한 시스템입니다");
			req.setAttribute("contentPage", "mainmenu.jsp");
		}
		tm.make(req);
		return "index";
	}
	
	@RequestMapping(value="/Unit.Calculate", method=RequestMethod.GET)
	public String insertUnitResult(Unit u, Result r, HttpServletRequest req) {
		if (mDAO.loginCheck(req)) {
			cDAO.calcUnit(u, req);
			cDAO.insertResult(r, req);
			req.setAttribute("contentPage", "UnitPage.jsp");
		} else {
			req.setAttribute("r", "로그인이 필요한 시스템입니다");
			req.setAttribute("contentPage", "mainmenu.jsp");
		}
		tm.make(req);
		return "index";
	}
	
	@RequestMapping(value="/ASCII.Calculate", method=RequestMethod.GET)
	public String insertASCIIResult(ASCII a, Result r, HttpServletRequest req) {
		if (mDAO.loginCheck(req)) {
			cDAO.calcASCII(a, req);
			cDAO.insertResult(r, req);
			req.setAttribute("contentPage", "ASCIIPage.jsp");
		} else {
			req.setAttribute("r", "로그인이 필요한 시스템입니다");
			req.setAttribute("contentPage", "mainmenu.jsp");
		}
		tm.make(req);
		return "index";
	}
	
	
	@RequestMapping(value="/result.show", method=RequestMethod.GET)
	public String showResult(@RequestParam(defaultValue="1") int p, Result r, HttpServletRequest req) {
		if (mDAO.loginCheck(req)) {
			cDAO.getUserResult(p, r, req);
			req.setAttribute("contentPage", "result.jsp");
		} else {
			req.setAttribute("r", "로그인이 필요한 시스템입니다");
			req.setAttribute("contentPage", "mainmenu.jsp");
		}
		tm.make(req);
		return "index";
	}
	
}
