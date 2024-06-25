<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="CalcController" name="calcForm" onsubmit="return calcCheck();">
	<table id="calctbl">
		<tr>
			<td>
				x : <input name="x" autofocus="autofocus">
			</td>
		</tr>
		<tr>
			<td>
				y : <input name="y" autofocus="autofocus">
			</td>
		</tr>
		<tr>
			<td>
				<button class="btn" type="submit">계산</button>
			</td>
		</tr>
	</table>
	</form>
</body>
</html>