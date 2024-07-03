<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/js/MinjuValidChecker.js"></script>
<script type="text/javascript" src="resources/js/input.js"></script>
<link rel="stylesheet" href="resources/css/input.css">
</head>
<body>
	<table>
	<tr>
	<td align="center" valign="top" style="margin-top: 30px;">
	<h1>단위 변환기</h1>
	<form action="unit.convert" name="convertForm" onsubmit="return inputCheck();">
		<input class="pl" name="beforeNum"> <p>
		<input class="pl" name="convertType" readonly="readonly" value="변환 단위 선택">
		<ul >
			<li onclick="setConvertType(1);"><span>1. cm → inch</span></li>
			<li onclick="setConvertType(2);"><span>2. ㎡ → 평</span></li>
			<li onclick="setConvertType(3);"><span>3. ℃ → ℉</span></li>
			<li onclick="setConvertType(4);"><span>4. mi/h → km/h</span></li>
		</ul>
		<!-- <select name="convertType"> 
			<option disabled="disabled" selected="selected" hidden="">변환 단위 선택</option>
			<option value="1">cm → inch</option>
			<option value="2">㎡ → 평</option>
			<option value="3">℃ → ℉</option>
			<option value="4">mi/h → km/h</option>
		</select> <p> -->
		
		<button>변환</button>
	</form>
	</td>
	</tr>
	</table>
</body>
</html>