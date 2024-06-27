<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>Apple Information</h2>
	<table id="detailTbl">
	<form action="AppleDetailController" method="post">
		<tr>
			<td>
				지역 :
			</td>
			<td>
				<input readonly="readonly" name="a_location" 
				value="${apple.a_location }">
			</td>
		</tr>
		<tr>
			<td>
				색깔 :
			</td>
			<td>
				<input name="a_color" maxlength="10" autofocus="autofocus" 
				autocomplete="off" value="${apple.a_color }">
			</td>
		</tr>
		<tr>
			<td>
				맛 :
			</td>
			<td>
				<input autocomplete="off" name="a_flavor" maxlength="10" value="${apple.a_flavor }">
			</td>
		</tr>
		<tr>
			<td>
				가격 :
			</td>
			<td>
				<input autocomplete="off" name="a_price" maxlength="5" value="${apple.a_price }">
			</td>
		</tr>
		<tr>
			<td>
				소개
			</td>
			<td>
				<textarea autocomplete="off" maxlength="100" name="a_introduce">${apple.a_introduce }</textarea>
			</td>
		</tr>
		<tr>
			<td align="center" colspan="2">
				<button>Update</button>
	</form>
				<button onclick="deleteApple('${apple.a_location}');">Delete</button>
				<button onclick="history.back();">뒤로</button>
			</td>
		</tr>
	</table>
</body>
</html>