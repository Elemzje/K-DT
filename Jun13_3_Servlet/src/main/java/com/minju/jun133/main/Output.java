package com.minju.jun133.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/Output")
public class Output extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");
		String id = request.getParameter("id");
		String pw = request.getParameter("pw");
		String gender = request.getParameter("gender");
		String location = request.getParameter("location");
		String[] hobby = request.getParameterValues("hobby");
		String intro = request.getParameter("introduce");
		// textarea에서 엔터 : \r\n
		// 웹페이지에서 줄바꾸기 : <br>
		intro = intro.replace("\r\n", "<br>");
		PrintWriter out = response.getWriter();
		out.print("<html>");
		out.print("<head><title>정보</title><meta charset='UTF-8'></head>");
		out.print("<body>");
		out.printf("ID : %s<br>", id);
		out.printf("PW : %s<br>", pw);
		out.printf("Gender : %s<br>", gender);
		out.printf("Location : %s<br>", location);
		out.print("Hobby : ");
		if (hobby != null) {
			for (String i : hobby) {
				out.print(i);
				out.print(" ");
			}
		}
		out.print("<br>");
		out.printf("Self-Introduce : %s<br>", intro);
		out.print("</body>");
		out.print("</html>");
	}

}
