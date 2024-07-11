<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table id="siteMainContentTbl">
		<tr>
			<td class="mainContentDataTd">
				<div id="contentBMIDataDiv"><!-- ajax --></div>
			</td>
			<td class="mainContentDataTd">
				<div id="contentBaseDataDiv"><!-- ajax --></div>
			</td>
		</tr>
		<tr>
			<td class="mainContentTextTd">
				<a href="result.show?r_type=BMI">▶ 최근 BMI 계산 결과 전체 보기</a>
			</td>
			<td class="mainContentTextTd">
				<a href="result.show?r_type=Base">▶ 최근 진수 변환 결과 전체 보기</a> 
			</td>
		</tr>
		<tr>
			<td class="mainContentDataTd">
				<div id="contentUnitDataDiv"><!-- ajax --></div>
			</td>
			<td class="mainContentDataTd">
				<div id="contentASCIIDataDiv"><!-- ajax --></div>
			</td>
		</tr>
		<tr>
			<td class="mainContentTextTd">
				<a href="result.show?r_type=Unit">▶ 최근 단위 변환 결과 전체 보기</a> 
			</td>
			<td class="mainContentTextTd">
				<a href="result.show?r_type=ASCII">▶ 최근 ASCII 변환 결과 전체 보기</a>
			</td>
		</tr>
	</table>
</body>
</html>