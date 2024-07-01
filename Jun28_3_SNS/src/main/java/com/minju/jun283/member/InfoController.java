package com.minju.jun283.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import oracle.net.aso.m;

@WebServlet("/InfoController")
public class InfoController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (MemberDAO.getMemberDAO().loginCheck(request)) {
			request.getSession().getAttribute("m");
			request.setAttribute("contentPage", "member/userInfo.jsp");
		} else {
			request.setAttribute("contentPage", "home.jsp");
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (MemberDAO.getMemberDAO().loginCheck(request)) {
			MemberDAO.getMemberDAO().update(request);
			MemberDAO.getMemberDAO().getInfo(request);
			request.setAttribute("contentPage", "member/result.jsp");
		} else {
			request.setAttribute("r", "부정한 방법으로 접근했습니다");
			request.setAttribute("contentPage", "member/result.jsp");
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
