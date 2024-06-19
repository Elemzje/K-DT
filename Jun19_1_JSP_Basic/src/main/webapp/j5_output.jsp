<%@page import="java.util.StringTokenizer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function getRandomColor() {
		
		// Math.random()						=> 0 ~ 0.99999
		// Math.random() * 255					=> 0 ~ 254.99999
		// Math.round(Math.random() * 255)		=> 0 ~ 255
		
		let r = Math.round(Math.random() * 255);
		let g = Math.round(Math.random() * 255);
		let b = Math.round(Math.random() * 255);
		
		return "rgb(" + r + "," + g + "," + b + ")";
	}
	
	function init() {
		let cv = document.getElementById("cv");
		let pen = cv.getContext("2d");
		let x = 0;
		let y = 0;
		
		setInterval(() => {
			pen.save();
			pen.fillStyle = "rgba(0, 0, 0, 0.2)"; // a : 투명도 (0 ~ 1)
			pen.fillRect(0, 0, 500, 500);
			
			pen.shadowOffSetX = 0;
			pen.shadowOffSetY = 0;
			pen.shadowBlur = 5;
			pen.shadowColor = "white";
			
			x = Math.random() * 500;
			y = Math.random() * 500;
			pen.fillStyle = getRandomColor();
			pen.fillRect(x, y, 20, 20);
			
			pen.restore();
		}, 200);
	}
	
	
</script>
</head>
<body onload="init();">
	<canvas id="cv" width="500px" height="500px"></canvas>
	<hr>
	<%
		// response.sendRedirect("test.jsp");
		String line = request.getParameter("line");
		String[] arr = line.split(",");
		int sum = 0;
		for (String n : arr) {
			try {
				sum += Integer.parseInt(n);
			} catch (Exception e) {
				continue;
			}
		}
	%>
	<%
		String line2 = request.getParameter("line");
		StringTokenizer st = new StringTokenizer(line2, ",");
		int sum2 = 0;
		while (st.hasMoreTokens()) {
			try {
				sum2 += Integer.parseInt(st.nextToken());
			} catch (Exception e) {
				continue;
			}
		}
	%>
	<h1>split</h1>
	<h1><%=sum %></h1>
	<p>
	<h1>StringTokenizer</h1>
	<h1><%=sum2 %></h1>
</body>
</html>