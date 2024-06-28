<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/index.css">
<script type="text/javascript" src="js/MinjuValidChecker.js"></script>
<script type="text/javascript" src="js/regValidChecker.js"></script>
<script type="text/javascript" src="js/login.js"></script>
</head>
<body>
	<table id="siteMenuTbl">
		<tr>
			<td align="center" colspan="2"><a href="HomeController">Title</a></td>
		</tr>
		<tr>
			<td align="center">메뉴1</td>
			<td align="center">메뉴2</td>
		</tr>
	</table>
	<table id="siteLoginTbl">
		<tr>
			<td>
				<jsp:include page="${loginPage }" />
			</td>
		</tr>
	</table>
	<table id="siteContentTbl">
		<tr>
			<td>
				<jsp:include page="${contentPage }" />
			</td>
		</tr>
	</table>
</body>
</html>