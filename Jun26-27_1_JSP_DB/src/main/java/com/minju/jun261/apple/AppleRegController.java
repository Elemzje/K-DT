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

	// 등록하기
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// DB에 등록
		AppleDAO.getAppledao().reg(request);
		
		// 게시판에 나올 데이터 가지고
//		AppleDAO.getAppledao().getAllApple(request);
		AppleDAO.getAppledao().getPage(1, request);
		
		// 보여줄 페이지로 이동
		request.setAttribute("contentPage", "apple/apple.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
