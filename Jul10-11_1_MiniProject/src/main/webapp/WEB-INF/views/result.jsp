<%@ page language="java" contentType="text/html; charset=UTF-8"
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
	<c:if test="${p != 1 }"><a style="position: fixed; top: 50%; left: 20px; font-size: 50pt;">&lt;</a></c:if>
	<table>
	<c:forEach var="result" items="${results }">
		<tr>
			<td>
				${result.r_user }, ${result.r_no }
			</td>
			<td>
				${result.r_type }, ${result.r_calcstr }
			</td>
			<td align="right">
				<fmt:formatDate type="both" timeStyle="short" dateStyle="long" value="${result.r_when }"/>
			</td>
		</tr>
	</c:forEach>
	</table>
</body>
</html>