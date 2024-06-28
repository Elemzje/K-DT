package com.minju.jun283.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO.getMemberDAO().login(request, response);
		
		if (MemberDAO.getMemberDAO().loginCheck(request)) {
			request.setAttribute("r", "[로그인 성공]");
			request.setAttribute("contentPage", "member/result.jsp");
			request.setAttribute("loginPage", "member/loginInfo.jsp");
		} else {
			request.setAttribute("r", "[로그인 실패]");
			request.setAttribute("contentPage", "member/result.jsp");
			request.setAttribute("loginPage", "member/login.jsp");
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
