package com.minju.jun283.member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/InfoDeleteController")
public class InfoDeleteController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (MemberDAO.getMemberDAO().loginCheck(request)) {
			MemberDAO.getMemberDAO().delete(request);
			request.setAttribute("contentPage", "member/result.jsp");
		} else {
			request.setAttribute("contentPage", "home.jsp");
		} 
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
