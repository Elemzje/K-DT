<%@page import="java.util.Random"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--
		랜덤한 숫자(1 ~ 100)를 넣었을 때, 짝인지 홀인지 알려주는 기능
		뽑은 숫자와 홀짝여부를 웹페이지에 출력
	 --%>
	<% 
		Random r = new Random();
		int a = r.nextInt(100) + 1;
		String res = a % 2 == 0 ? "짝" : "홀";
	%>
	<div>뽑은 숫자 <%=a %>, 결과 <%=res %></div>
	
</body>
</html>