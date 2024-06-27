<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/AppleDetail.js"></script>
<link rel="stylesheet" href="css/index.css">
<link rel="stylesheet" href="css/apple.css">
</head>
<body>
	<table id="siteTbl">
		<tr>
			<th id="siteTitleArea"><a href="HomeController">title here</a></th>
		</tr>
		<tr>
			<td id="siteContentArea" align="center">
				<jsp:include page="${contentPage }" />
			</td>
		</tr>
	</table>
	<table id="siteMenuTbl">
		<tr>
			<td align="center"><a href="AppleController">Apple</a></td>
			<td align="center"><a href="">Banana</a></td>
			<td align="center"><a href="">Cherry</a></td>
			<td align="center"><a href="DBCController">DB연결</a></td>
		</tr>
	</table>
</body>
</html>