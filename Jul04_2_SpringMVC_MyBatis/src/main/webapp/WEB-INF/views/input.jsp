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
	<form action="student.reg">
		이름 : <input name="s_name"> <p>
		별명 : <input name="s_nickname"> <p>
		<button>등록</button>
	</form>
	<hr>
	<c:forEach var="student" items="${students }">
		${student.s_no } : ${student.s_name }, ${student.s_nickname } <p>
	</c:forEach>
	<hr>
	<form action="test.reg">
		과목명 : <input name="t_subject"> <p>
		시험일
		<select name="t_y">
			<c:forEach var="year" begin="2024" end="2060">
				<option>${year }</option>
			</c:forEach>
		</select>년
		<select name="t_m">
			<c:forEach var="month" begin="1" end="12">
				<option>${month }</option>
			</c:forEach>
		</select>월
		<select name="t_d">
			<c:forEach var="day" begin="1" end="31">
				<option>${day }</option>
			</c:forEach>
		</select>일 <p>
		<button>등록</button>
	</form>
	<hr>
	<c:forEach var="test" items="${tests}">
		${test.t_subject } - <fmt:formatDate value="${test.t_date }" type="date" dateStyle="long"/> <p> 
	</c:forEach>
	<hr>	
	${r }
</body>
</html>