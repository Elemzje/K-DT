package com.minju.jun261.apple;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AppleRegController")
public class AppleRegController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("apple/reg.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		AppleDAO.getAppledao().reg(request);
		AppleDAO.getAppledao().getAllApple(request);
		request.setAttribute("contentPage", "apple/apple.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
