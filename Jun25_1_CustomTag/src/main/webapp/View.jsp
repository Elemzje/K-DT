<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/MinjuValidChecker.js"></script>
<script type="text/javascript" src="js/CalcValidChecker.js"></script>
<link rel="stylesheet" href="css/calc.css">
<link rel="stylesheet" href="css/View.css">
</head>
<body>
	<table>
		<tr>
			<td>
				<a href="HomeController">Home</a>
			</td>
			<td>
				<a href="CalcController">사칙연산</a>
			</td>
			<td>
				<a href="JSTLCController">JSTL-C</a>
			</td>
			<td>
				<a href="JSTLFController">JSTL-F</a>
			</td>
		</tr>
		<tr>
			<td colspan="4">
				<jsp:include page="${contentPage }"></jsp:include>
			</td>
		</tr>
	</table>
</body>
</html>