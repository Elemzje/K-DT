<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/view.css">
</head>
<body>
	<table>
		<tr>
			<th colspan="2" align="center">
				홀짝 게임
			</th>
		</tr>
		<tr>
			<td colspan="2" align="center" class="td1">
				<div>컴퓨터가 1 ~ 100까지의 숫자 중 하나를 랜덤하게 고릅니다</div>
				<div>유저는 컴퓨터가 고른 숫자를 예상해서 홀/짝을 선택합니다</div>
				<div>유저가 컴퓨터의 홀/짝 여부를 맞추면 승리!</div>
			</td>
		</tr>
		<tr>
			<td align="center"><a href="HomeController?user=even"><img src="css/even.png"></a></td>
			<td align="center"><a href="HomeController?user=odd"><img src="css/odd.png"></a></td>
		</tr>
		<tr>
			<td align="center" class="td1">유저 ↓</td>
			<td align="center" class="td1">컴퓨터 ↓</td>
		</tr>
		<tr>
			<td align="center"><img src="css/${user }.png"></td>
			<td align="center"><img src="css/${com }.png"></td>
		</tr>
		<tr>
			<td colspan="2" align="center" class="td1">
				<div>결과 : ${r }</div>
				<div>전적 ${t }전 ${w }승 ${l }패, 승률 ${wr }%</div>
			</td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<form action="HomeController" method="post">
					<button>전적 초기화</button>
				</form>
			</td>
		</tr>
	</table>
</body>
</html>