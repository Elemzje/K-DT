package com.minju.jun241.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 숫자야구
//	3자리 숫자 (백의자리 숫자는 0 가능), 중복 숫자 X
//	입력 하는 부분
//		1. 숫자 아닌 거 입력 못하게 (값이 안넘어가게)
//		2. 중복 숫자 입력 다시 입력하게
//		3. 무조건 3자리 숫자여야 하도록
//		유효성 검사!

@SuppressWarnings("serial")
@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameterNames().hasMoreElements()) {
			NBGameEngine nge = NBGameEngine.getNGE();
			nge.judge(request);
		} 
		request.getRequestDispatcher("View.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		NBGameEngine nge = NBGameEngine.getNGE();
		nge.reset(request);
		request.getRequestDispatcher("View.jsp").forward(request, response);
	}

}
