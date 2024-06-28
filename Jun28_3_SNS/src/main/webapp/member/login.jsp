<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="LoginController" method="post" onsubmit="login">
	<table>
		<tr>
			<th>
				Login
			</th>
		</tr>			
		<tr>
			<td><input name="id" value="${cookie.lastLoginId.value }" placeholder="ID"></td>
		</tr>			
		<tr>
			<td><input name="pw" type="password" placeholder="Password"></td>
		</tr>
		<tr>
			<td><button>Login</button>&nbsp;&nbsp;&nbsp;<a href="RegiController">Sign Up</a></td>
		</tr>
	</table>
	</form>
</body>
</html>