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
	<table>
	<tr>
	<td>
	<c:choose>
	<c:when test="${sessionScope.m == null }">
		<span>게시글을 작성하려면 로그인하세요.</span>
	</c:when>
	<c:otherwise>
		<form action="BoardWriteController">
		<input name="token" value="${generatedToken }" type="hidden">
		<textarea name="content" placeholder="작성!" autofocus="autofocus"></textarea>
		<button>게시</button>
		</form>
	</c:otherwise>
	</c:choose>
	</td>
	</tr>
	<tr>
		<td>
			<form action="BoardSearchController">
			<input name="search" autocomplete="off" placeholder="내용 검색" spellcheck="false">
			<button onclick="goSearch();">검색</button>
			</form>
		</td>
	</tr>
	<c:forEach var="board" items="${boards }">
		<tr>
			<td>
				<table>
					<tr>
						<td rowspan="2">
							<img src="img/${board.m_img }">
						</td>
						<td>
							- ${board.b_m_id } -
							<div align="right">${board.b_time }</div>
						</td>
					</tr>
					<tr>
						<td>
							${board.b_content }
						</td>
					</tr>
					<c:if test="${board.b_m_id == sessionScope.m.m_id }">
						<tr>
							<td colspan="2" align="right" class="boardBtn">
								<button onclick="boardUpdate(${board.b_no});">수정</button>
								<button onclick="boardDelete(${board.b_no});">삭제</button>
							</td>
						</tr>
					</c:if>
				</table>
			</td>
		</tr>
	</c:forEach>
	<tr>
		<c:choose>
		<c:when test="${pageCount <= 5 }">
		<td>
		<c:forEach var="s" begin="1" end="${pageCount }" step="1">
		<a href="BoardPageController?page=${s }">${s } </a>
		</c:forEach>
		</td>
		</c:when>
		<c:otherwise>
			<c:choose>
				<c:when test="${pageNum <= 3 }">
					<td>
						<c:forEach var="s" begin="1" end="4" step="1">
							<a href="BoardPageController?page=${s }">${s } </a>
						</c:forEach>
						...
						<a href="BoardPageController?page=${pageCount }">${pageCount } </a>
					</td>
				</c:when>
				<c:when test="${pageNum > pageCount - 3 }">
					<td>
						<a href="BoardPageController?page=1">1 </a>
						...
						<c:forEach var="s" begin="${pageCount - 3 }" end="${pageCount }">
							<a href="BoardPageController?page=${s }">${s } </a>
						</c:forEach>
					</td>
				</c:when>
				<c:otherwise>
					<td>
						<a href="BoardPageController?page=1">1 </a>
						...
						<c:forEach var="s" begin="${pageNum - 1 }" end="${pageNum + 1 }">
							<a href="BoardPageController?page=${s }">${s } </a>
						</c:forEach>
						...
						<a href="BoardPageController?page=${pageCount }">${pageCount } </a>
					</td>
				</c:otherwise>
			</c:choose>
		</c:otherwise>
		</c:choose>
	</tr>
	</table>
</body>
</html>