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
	<form action="InfoController" method="post" name="regForm" enctype="multipart/form-data" onsubmit="return regCheck();">
		<tr>
			<td colspan="2"><h1>유저 정보</h1></td>
		</tr>
		<tr>
			<td>ID</td>
			<td><input readonly="readonly" spellcheck="false" name="id" value="${sessionScope.m.m_id }"></td>
		</tr>
		<tr>
			<td>PW</td>
			<td><input name="pw" type="password" spellcheck="false" autocomplete="off" value="${sessionScope.m.m_pw }" placeholder="PW"></td>
		</tr>
		<tr>
			<td>PW Check</td>
			<td><input name="pwchk" type="password" spellcheck="false" autocomplete="off" value="${sessionScope.m.m_pw }" placeholder="PW check"></td>
		</tr>
		<tr>
			<td>Name</td>
			<td><input name="name" autocomplete="off" spellcheck="false" value="${sessionScope.m.m_name }" placeholder="Name"></td>
		</tr>
		<tr>
			<td>Phone Number</td>
			<td><input name="phoneNum" autocomplete="off" spellcheck="false" value="${sessionScope.m.m_phone_no }" placeholder="PhoneNumber"></td>
		</tr>
		<tr>
			<td>Birthday</td>
			<td><input name="birthday" autocomplete="off" spellcheck="false" value="${sessionScope.m.m_birthday }" placeholder="PhoneNumber"></td>
		</tr>
		<tr>
			<td colspan="2">
				<img src="img/${sessionScope.m.m_img }">
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<label for="file">사진 변경</label>
				<input id="file" name="img" type="file" autocomplete="off" style="display: none;">
			</td>
		</tr>
		<tr>
			<td>
				<button type="submit">Update</button>
			</td>
	</form>
			<td>
				<button onclick="deleteInfo();">Delete</button>
			</td>
		</tr>
	</table>
</body>
</html>