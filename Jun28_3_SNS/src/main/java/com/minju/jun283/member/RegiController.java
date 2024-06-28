package com.minju.jun283.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RegiController")
public class RegiController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("contentPage", "member/register.jsp");
		request.setAttribute("loginPage", "member/login.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO.getMemberDAO().register(request);
		request.setAttribute("contentPage", "member/result.jsp");
		request.setAttribute("loginPage", "member/login.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
