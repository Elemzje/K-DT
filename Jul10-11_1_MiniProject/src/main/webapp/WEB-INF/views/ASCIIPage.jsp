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
	<form action="ASCII.Calculate" name="ASCIIForm">
		<table id="ASCIITbl">
			<tr>
				<td>
					변환 방식
				</td>
				<td>
					<input id="stai" type="radio" checked="checked" name="a_type" value="1"><span id="sta">String to ASCII</span><br>
					<input id="atsi" type="radio" name="a_type" value="2"><span id="ats">ASCII to String</span>
				</td>
			</tr>
			<tr>
				<td>
					변환 전 : 
				</td>
				<td>
					<input name="a_str">
					<input name="r_type" value="ASCII" hidden="">
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