<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/index.css">
<script type="text/javascript" src="js/MinjuValidChecker.js"></script>
<script type="text/javascript" src="js/regValidChecker.js"></script>
<script type="text/javascript" src="js/login.js"></script>
<script type="text/javascript" src="js/board.js"></script>
</head>
<body>
	<table id="whole">
		<tr><td id="siteMenuTd" colspan="2">
			<table id="siteMenuTbl">
				<tr>
					<th align="center" colspan="2"><a href="HomeController">Title</a></th>
				</tr>
				<tr>
					<td align="center"><a href="BoardController">Board</a></td>
					<td align="center">메뉴2</td>
				</tr>
			</table>
		</td></tr>
		<tr><td>
			<table id="siteLoginTbl">
				<tr>
					<td>
						<jsp:include page="${loginPage }" />
					</td>
				</tr>
			</table>
		</td><td align="center">
			<table id="siteContentTbl">
				<tr>
					<td>
						<jsp:include page="${contentPage }" />
					</td>
				</tr>
			</table>
		</td></tr>
	</table>
</body>
</html>