package com.minju.jun183.main;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

@SuppressWarnings("serial")
@WebServlet("/BMIOutput")
public class BMIOutput extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setCharacterEncoding("UTF-8");
		String path = request.getServletContext().getRealPath("img");
		
		MultipartRequest mr = new MultipartRequest(request, path, 
					30 * 1024 * 1024, "UTF-8", new DefaultFileRenamePolicy());

		String name = mr.getParameter("name");
		double height = Double.parseDouble(mr.getParameter("height"));
		double weight = Double.parseDouble(mr.getParameter("weight"));
		String fileName = mr.getFilesystemName("photo");
		fileName = URLEncoder.encode(fileName, "UTF-8");
		fileName = fileName.replace("+", " ");
		
		double heightMeter = height / 100;
		double bmi = weight / (heightMeter * heightMeter);

		String result = null;
		if (bmi < 18.5) {
			result = "저체중";
		} else if (bmi < 25) {
			result = "정상";
		} else if (bmi < 30) {
			result = "과체중";
		} else if (bmi < 35) {
			result = "경도비만";
		} else if (bmi < 40) {
			result = "중증도비만";
		} else if (bmi >= 40) {
			result = "고도비만";
		}
		
		PrintWriter out = response.getWriter();
		
		out.print("<html>");
		out.print("<head><meta charset='UTF-8'></head>");
		out.print("<body>");
		out.print("<h1>BMI 측정 결과</h1>");
		out.print("<table>");
		out.print("<tr><td>");
			out.print("이름");
		out.print("</td><td>");
			out.print(name);
		out.print("</td></tr>");
		out.print("<tr><td>");
			out.print("키");
		out.print("</td><td>");
		out.printf("%.1fcm", height);
		out.print("</td></tr>");
		out.print("<tr><td>");
			out.print("체중");
		out.print("</td><td>");
			out.printf("%.2fkg", weight);
		out.print("</td></tr>");
		out.print("<tr><td>");
			out.print("BMI 수치");
		out.print("</td><td>");
			out.printf("%.2f", bmi);
		out.print("</td></tr>");
		out.print("<tr><td>");
			out.print("결과");
		out.print("</td><td>");
			out.print("당신은 " + result + "입니다");
		out.print("</td></tr>");
		out.print("<tr><td colspan='2'>");
			out.printf("<img src='img/%s'>", fileName);
		out.print("</td></tr>");
		out.print("</table>");
		out.print("</body>");
		out.print("</html>");
	}

}
