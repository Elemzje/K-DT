<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/View.css">
</head>
<body>
	<table>
		<tr>
			<td>
				<a href="HomeController">M1</a>
			</td>
			<td>
				<a href="HomeController?menu=m2">M2</a>
			</td>
			<td>
				<a href="HomeController?menu=m3">M3</a>
			</td>
			<td>
				<a href="HomeController?menu=m4">M4</a>
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