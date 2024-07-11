<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="userInfo.update" method="post" name="userInfoForm" id="userInfoForm">
	<table id="userInfoTbl">
		<tr>
			<td>
				ID :
			</td>
			<td>
				<input name="m_id" class="m_id" readonly="readonly" value="${sessionScope.loginMember.m_id }">
			</td>
		</tr>
		<tr>
			<td>
				PW : 
			</td>
			<td>
				<input class="m_pw" name="m_pw" autocomplete="off" placeholder="비밀번호 입력" type="password" value="${sessionScope.loginMember.m_pw }">
			</td>
		</tr>
		<tr>
			<td>
				PW확인 : 
			</td>
			<td>
				<input class="m_pwCheck" name="m_pwCheck" autocomplete="off" placeholder="비밀번호 재입력" type="password" value="${sessionScope.loginMember.m_pw }">
			</td>
		</tr>
		<tr>
			<td>
				소속 : 
			</td>
			<td>
				<input class="m_affiliation" name="m_affiliation" autocomplete="off" placeholder="회사 / 학교명 입력" value="개인"  value="${sessionScope.loginMember.m_affiliation }">
			</td>
		</tr>
		<tr>
			<td><button type="submit">정보 수정</button></td>
	</form>
			<td><button onclick="history.back();">돌아가기</button></td>
		</tr>
		<tr>
			<td colspan="2"><button type="button" id="delete">회원 탈퇴</button></td>
		</tr>
	</table>
</body>
</html>