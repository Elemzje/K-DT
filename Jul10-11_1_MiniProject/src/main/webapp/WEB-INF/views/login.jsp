<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table id="loginTbl">
	<form action="login.select" method="post" id="loginForm" name="loginForm">
		<tr>
			<td>
				ID : 
			</td>
			<td>
				<input class="m_id" name="m_id" autofocus="autofocus" placeholder="ID 입력" value="${cookie.lastLoginID.value }">
			</td>
		</tr>
		<tr>
			<td>
				PW : 
			</td>
			<td>
				<input class="m_pw" name="m_pw" autocomplete="off" placeholder="비밀번호 입력" type="password">
			</td>
		</tr>
		<tr>
			<td><button>로그인</button></td>
	</form>
			<td><button onclick="history.back();">취소</button></td>
		</tr>
	</table>
</body>
</html>