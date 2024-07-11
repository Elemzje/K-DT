<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="Unit.Calculate" name="UnitForm">
		<table id="UnitTbl">
			<tr>
				<td>
					단위 변환 선택
				</td>
				<td>
					<select name="u_unit">
						<option value="1">km/h → m/s</option>
						<option value="2">㎡ → 평</option>
						<option value="3">m → yd</option>
						<option value="4">kg → lb</option>
					</select>
				</td>
			</tr>
			<tr>
				<td>
					값 : 
 				</td>
				<td>
					<input name="u_value">
					<input name="r_type" value="Unit" hidden="">
					<input name="token" value="${generatedToken }" hidden="">
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<button>계산하기</button>
				</td>
			</tr>
			<c:if test="${cr == 1}">
			<tr>
				<td>
					결과 : 
				</td>
				<td>
					${r_calcstr }
				</td>
			</tr>
			</c:if>
		</table>
	</form>
</body>
</html>