<%@ page language="java" contentType="text/html; charset=,UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table id="appleTbl">
		<tr>
			<td align="right">${r }<a href="AppleRegController">등록</a></td>
		</tr>
		<tr>
			<td id="appleBoard" align="center">
				<table id="appleContext">
					<tr>
						<th>지역</th>
						<th>가격</th>
					</tr>
					<c:forEach var="apple" items="${apples }">
						<tr class="dataTr">
							<td>${apple.a_location }</td>
							<td><fmt:formatNumber value="${apple.a_price }" type="number" /></td>
						</tr>
					</c:forEach>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>