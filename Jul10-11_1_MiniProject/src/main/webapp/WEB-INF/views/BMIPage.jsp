<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="BMI.Calculate" name="BMIForm">
		<table id="BMITbl">
			<tr>
				<td>
					키 : 
				</td>
				<td>
					<input name="b_height">
				</td>
			</tr>
			<tr>
				<td>
					체중 : 
				</td>
				<td>
					<input name="b_weight">
					<input name="r_type" value="BMI" hidden="">
					<input name="token" value="${generatedToken }" hidden="">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<button>계산하기</button>
				</td>
			</tr>
			<c:if test="${cr == 1}">
			<tr>
				<td>
					결과 : 
				</td>
				<td>
					${r_calcstr }
				</td>
			</tr>
			</c:if>
		</table>
	</form>
</body>
</html>