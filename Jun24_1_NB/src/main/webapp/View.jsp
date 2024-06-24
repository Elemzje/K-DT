<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/View.css">
<script type="text/javascript" src="js/MinjuValidChecker.js"></script>
<script type="text/javascript" src="js/NBValidChecker.js"></script>
</head>
<body>
	<table>
		<tr>
			<th align="center" class="text">숫자야구 게임</th>
		</tr>
		<tr>
			<td align="center" class="text">
				<div>컴퓨터가 랜덤하게 뽑아낸 3자리 숫자를 맞추는 게임!</div>
				<div>맞는 숫자가 있고, 그 자리가 다르면 볼!</div>
				<div>맞는 숫자가 있고, 그 자리가 같으면 스트라이크!</div>
				<div>3스트라이크가 나오면 승리!</div>
			</td>
		</tr>
		<tr>
			<td align="center">
				<form name="ff" action="HomeController" onsubmit="return check();">
					<input maxlength="3" name="guess" autocomplete="off" autofocus="autofocus" placeholder="3자리 숫자 입력">
					<button>전송</button>
				</form>
			</td>
		</tr>
		<tr>
			<td align="center" class="text">${t }턴 ${guess } : ( ${strike }S / ${ball }B ) ${com } ${r }</td>
		</tr>
		<tr>
			<td align="center"><form action="HomeController" method="post">
				<button>다시하기</button>
			</form></td>
		</tr>
	</table>
	${con }
</body>
</html>