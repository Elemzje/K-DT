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
	<form action="Base.Calculate" name="BaseForm">
		<table id="BaseTbl">
			<tr>
				<td>
					기존값 : 
				</td>
				<td>
					<input name="b_integer">
				</td>
			</tr>
			<tr>
				<td>
					변환진수 : 
				</td>
				<td>
					<input name="b_afterBase">
					<input name="r_type" value="Base" hidden="">
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