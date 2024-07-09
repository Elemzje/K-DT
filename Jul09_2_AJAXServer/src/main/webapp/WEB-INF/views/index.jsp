<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- 
		MyBatis + Spring MVC 활용
		e_what - e_where 의 형태로 출력
	 -->
	
	<c:forEach var="e" items="${errors }">
		<h1> ${e.e_what } - ${e.e_where } </h1>
	</c:forEach>
	
	
</body>
</html>