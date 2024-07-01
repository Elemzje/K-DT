<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="RegiController" name="regForm" method="post" enctype="multipart/form-data" onsubmit="return regCheck();">
	<table id="regiTbl">
		<tr>
			<th colspan="2"><h1>회원가입</h1></th>
		</tr>
		<tr>
			<td>ID </td>
			<td><input name="id" autofocus="autofocus" autocomplete="off" 
			maxlength="12" placeholder="4 ~ 12자, 영어 대소문자, 숫자만 입력 가능" ></td>
		</tr>
		<tr>
			<td>PW </td>
			<td><input name="pw" maxlength="12" autocomplete="off"
			placeholder="3 ~ 12자, 특수문자/숫자 포함"></td>
		</tr>
		<tr>
			<td>PW check </td>
			<td><input name="pwchk" maxlength="12" autocomplete="off"
			placeholder="비밀번호 중복확인"></td>
		</tr>
		<tr>
			<td>Name </td>
			<td><input name="name" maxlength="5" autocomplete="off"></td>
		</tr>
		<tr>
			<td>Phone </td>
			<td><input name="phoneNum" maxlength="13" autocomplete="off"
			placeholder="010-XXXX-XXXX"></td>
		</tr>
		<tr>
			<td>Birthday </td>
			<td><input name="birthday" maxlength="10" autocomplete="off"
			placeholder="YYYY-MM-DD"></td>
		</tr>
		<tr>
			<td>Image </td>
			<td>
				<label for="imageFile">업로드</label>
				<input id="imageFile" style="display: none;" type="file" autocomplete="off" name="image">
			</td>
		</tr>
		<tr>
			<td align="right"><button>회원 가입</button></td>
			<td><span onclick="history.back();">취소</span></td>
		</tr>
	</table>
	</form>
</body>
</html>