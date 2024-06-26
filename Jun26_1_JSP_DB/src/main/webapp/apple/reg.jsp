<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/MinjuValidChecker.js"></script>
<script type="text/javascript" src="js/AppleRegChecker.js"></script>
</head>
<body>
	<form name="appleForm" method="post" action="AppleRegController" onsubmit="return regCheck();">
	<table>
		<tr>
			<td>
				지역 <input name="a_location" autofocus="autofocus" maxlength="10">
			</td>
		</tr>
		<tr>
			<td>
				색깔 <input name="a_color" maxlength="10">
			</td>
		</tr>
		<tr>
			<td>
				맛 <input name="a_flavor" maxlength="10">
			</td>
		</tr>
		<tr>
			<td>
				가격 <input name="a_price" placeholder="숫자만 입력" maxlength="5">
			</td>
		</tr>
		<tr>
			<td>
				소개 <textarea rows="10" cols="10" name="a_introduce"></textarea>
			</td>
		</tr>
		<tr>
			<td>
				<button>등록</button>
			</td>
		</tr>
	</table>
	</form>
</body>
</html>