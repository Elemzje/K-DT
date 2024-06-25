package com.minju.jun251.calc;

import javax.servlet.http.HttpServletRequest;

public class Calculator {
	public void calc(HttpServletRequest request) {
		int x = Integer.parseInt(request.getParameter("x"));
		int y = Integer.parseInt(request.getParameter("y"));
		request.setAttribute("plus", x + y);
		request.setAttribute("minus", x - y);
		request.setAttribute("multiply", x * y);
		request.setAttribute("divide", String.format("%.2f", (double) x / y));
	}
}
