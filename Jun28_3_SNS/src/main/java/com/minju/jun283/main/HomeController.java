package com.minju.jun283.main;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.minju.jun283.board.BoardDAO;
import com.minju.jun283.member.MemberDAO;

@WebServlet("/HomeController")
public class HomeController extends HttpServlet {
	public HomeController() {
		BoardDAO.getBoardDAO().countBoard();
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (MemberDAO.getMemberDAO().loginCheck(request)) {
			request.setAttribute("contentPage", "home.jsp");
			request.setAttribute("loginPage",  "member/loginInfo.jsp");
		} else {
			request.setAttribute("contentPage", "home.jsp");
			request.setAttribute("loginPage", "member/login.jsp");
		}
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
