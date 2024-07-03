<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="resources/css/input.css">
</head>
<body>
	<table>
	<tr>
	<td align="center">
		<h1 style="color:${color }">변환 결과</h1>
		<input class="pl" readonly="readonly" value="${beforeNum } ${beforeUnitType }">
		<input style="margin-top: 15px;" class="pl" readonly="readonly" value=" ↓ ">
		<input style="margin-top: 15px;" class="pl" readonly="readonly" value="${afterNum } ${afterUnitType }">
		<button onclick="history.back();">돌아가기</button>
	</td>
	</tr>
	</table>
</body>
</html>