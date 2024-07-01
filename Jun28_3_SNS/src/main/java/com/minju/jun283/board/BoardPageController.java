package com.minju.jun283.board;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.minju.jun283.main.TokenManager;
import com.minju.jun283.member.MemberDAO;

@WebServlet("/BoardPageController")
public class BoardPageController extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		MemberDAO.getMemberDAO().loginCheck(request);
		int pageNum = Integer.parseInt(request.getParameter("page"));
		TokenManager.make(request);
		BoardDAO.getBoardDAO().getPage(pageNum, request);
		request.setAttribute("contentPage", "board/board.jsp");
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
