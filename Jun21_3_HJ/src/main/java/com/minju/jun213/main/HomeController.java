package com.minju.jun213.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (!request.getParameterNames().hasMoreElements()) {
			request.setAttribute("com", "question");
			request.setAttribute("user", "question");
		} else {
			HJGameEngine.getHge().doHJ(request);
		}
		request.getRequestDispatcher("View.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HJGameEngine.getHge().reset(request);
		request.setAttribute("com", "question");
		request.setAttribute("user", "question");
		request.getRequestDispatcher("View.jsp").forward(request, response);
	}

}
