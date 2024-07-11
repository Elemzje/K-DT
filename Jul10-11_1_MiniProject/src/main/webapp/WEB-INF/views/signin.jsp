<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="signin.insert" method="post" name="signinForm" id="signinForm">
	<table id="signinTbl">
		<tr>
			<td>
				ID : 
			</td>
			<td>
				<input class="m_id" name="m_id" autofocus="autofocus" placeholder="ID 입력">
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
			<td>
				PW확인 : 
			</td>
			<td>
				<input class="m_pwCheck" name="m_pwCheck" autocomplete="off" placeholder="비밀번호 재입력" type="password">
			</td>
		</tr>
		<tr>
			<td>
				소속 : 
			</td>
			<td>
				<input class="m_affiliation" name="m_affiliation" autocomplete="off" placeholder="회사 / 학교명 입력" value="개인">
			</td>
		</tr>
		<tr>
			<td><button>회원가입</button></td>
	</form>
			<td><button onclick="history.back();">취소</button></td>
		</tr>
	</table>
</body>
</html>