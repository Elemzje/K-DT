<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<td rowspan="2"><img src="img/${sessionScope.m.m_img }"></td>
			<td>${sessionScope.m.m_id }</td>
		</tr>
		<tr>
			<td>${sessionScope.m.m_name }님</td>
		</tr>
		<tr>
			<td>어서오세요</td>
		</tr>
		<tr>
			<td>
				<button onclick="goInfo();">정보</button>
			</td>
			<td>
				<button onclick="logOut();">로그아웃</button>
			</td>
		</tr>
	</table>
</body>
</html>