<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<% 
	%>
	<table>
		<tr>
			<th colspan="3">가위바위보 게임</th>
		</tr>
		<tr> 
			<td>
				<a href="HomeController?rsp=1"><img src="css/1.png" width="100px"></a>
			</td>
			<td>
				<a href="HomeController?rsp=2"><img src="css/2.png" width="100px"></a>
			</td>
			<td>
				<a href="HomeController?rsp=3"><img src="css/3.png" width="100px"></a>
			</td>
		</tr>
		<tr>
			<td align="center" class="td2">유저(↓)</td>
			<td align="center" class="td2">승부</td>
			<td align="center" class="td2">상대(↓)</td>
		</tr>
		<tr>
			<td align="center" class="td1"><img src="css/${rsp }.png" width="100px"></td>
			<td align="center" class="td1"><img src="css/versus.jfif" width="100px"></td>
			<td align="center" class="td1"><img src="css/${comrsp }.png" width="100px"></td>
		</tr>
		<tr>
			<td colspan="3" align="center"><div>판정: ${result}</div>전적 ${t }전 ${win }승 ${draw }무 ${lose }패</td>
		</tr>
		<tr>
			<td colspan="3" align="center"><form method="post" action="HomeController">
				<button>다시하기</button>
			</form></td>
		</tr>
	
	</table>
</body>
</html>