package com.minju.jun132.main;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@SuppressWarnings("serial")
@WebServlet("/Calculator")
public class Calculator extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		PrintWriter out = response.getWriter();
		String x = request.getParameter("x");
		String y = request.getParameter("y");
		int xnum = Integer.parseInt(x);
		int ynum = Integer.parseInt(y);
		out.print("<html>");
		out.print("<head><title>Hello !</title><meta charset='UTF-8'></head>");
		out.print("<body>");
		out.print("<table border='1'><tr><td>");
		out.print(x + "+" + y);
		out.print("</td>");
		out.print("<td>");
		out.print(xnum + ynum);
		out.print("</td></tr>");
		out.print("<tr><td>");
		out.print(x + "-" + y);
		out.print("</td>");
		out.print("<td>");
		out.print(xnum - ynum);
		out.print("</td></tr>");
		out.print("<tr><td>");
		out.print(x + "*" + y);
		out.print("</td>");
		out.print("<td>");
		out.print(xnum * ynum);
		out.print("</td></tr>");
		out.print("<tr><td>");
		out.print(x + "/" + y);
		out.print("</td>");
		out.print("<td>");
		out.printf("%.2f", (double) xnum / ynum);
		out.print("</td></tr>");
		out.print("</table>");
		out.print("</body>");
		out.print("</html>");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
