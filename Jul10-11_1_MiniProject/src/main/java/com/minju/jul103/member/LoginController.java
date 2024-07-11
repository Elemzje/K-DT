package com.minju.jul103.member;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	
	@Autowired
	private MemberDAO mDAO;
	
	@RequestMapping(value="/login.do", method=RequestMethod.GET)
	public String doLogin(HttpServletRequest req) {
		if (mDAO.loginCheck(req)) {
			req.setAttribute("r", "우예 들어왔음?");
			req.setAttribute("contentPage", "mainmenu.jsp");
		} else {
			req.setAttribute("contentPage", "login.jsp");
		}
		return "index";
	}
	
	@RequestMapping(value="/login.select", method=RequestMethod.POST)
	public String selectLogin(Member m, HttpServletRequest req, HttpServletResponse res) {
		mDAO.login(m, req, res);
		req.setAttribute("contentPage", "mainmenu.jsp");
		return "index";
	}
	
	@RequestMapping(value="/logout.do", method=RequestMethod.GET)
	public String doLogout(HttpServletRequest req) {
		if (mDAO.loginCheck(req)) {
			mDAO.logout(req);
		}
		req.setAttribute("contentPage", "mainmenu.jsp");
		return "index";
	}
	
	@RequestMapping(value="/signin.do", method=RequestMethod.GET)
	public String doSignin(HttpServletRequest req) {
		if (mDAO.loginCheck(req)) {
			req.setAttribute("r", "회원가입은 로그아웃 후 이용해주세요");
			req.setAttribute("contentPage", "mainmenu.jsp");
		} else {
			req.setAttribute("contentPage", "signin.jsp");
		}
		return "index";
	}
	
	@RequestMapping(value="/signin.insert", method=RequestMethod.POST)
	public String insertSignin(Member m, HttpServletRequest req) {
		mDAO.signin(m, req);
		req.setAttribute("contentPage", "mainmenu.jsp");
		return "index";
	}
	
	@RequestMapping(value="/userInfo.show", method=RequestMethod.GET)
	public String doUpdateInfo(HttpServletRequest req) {
		if (mDAO.loginCheck(req)) {
			req.setAttribute("contentPage", "userInfo.jsp");
		} else {
			req.setAttribute("r", "진짜 우예하는거임?");
			req.setAttribute("contentPage", "mainmenu.jsp");
		}
		return "index";
	}
	
	@RequestMapping(value="/userInfo.update", method=RequestMethod.POST)
	public String updateUserInfo(Member m, HttpServletRequest req) {
		mDAO.update(m, req);
		req.setAttribute("contentPage", "mainmenu.jsp");
		return "index";
	}
	
	@RequestMapping(value="/userInfo.delete", method=RequestMethod.GET)
	public String deleteUserInfo(Member m, HttpServletRequest req) {
		if (mDAO.loginCheck(req)) {
			m.setM_id(((Member) req.getSession().getAttribute("loginMember")).getM_id());
			mDAO.delete(m, req);
			req.getSession().setAttribute("loginMember", null);
		} else {
			req.setAttribute("r", "계정이 있어야 지우지..");
		}
		req.setAttribute("contentPage", "mainmenu.jsp");
		return "index";
	}
}
