<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="resources/js/jQuery.js"></script>
<script type="text/javascript" src="resources/js/MinjuValidChecker.js"></script>
<script type="text/javascript" src="resources/js/indexEvent.js"></script>
<script type="text/javascript" src="resources/js/indexValidChecker.js"></script>
<link rel="stylesheet" href="resources/css/index.css">
<link rel="stylesheet" href="resources/css/mainmenu.css">
</head>
<body>
	<c:if test="${sessionScope.loginMember.m_id == null }">
		<a href="login.do" class="login1"><img title="로그인" src="resources/img/login.png"></a>
		<a href="signin.do" class="login2"><img title="회원가입" src="resources/img/signin.png"></a>
	</c:if>
	<c:if test="${sessionScope.loginMember.m_id != null }">
		<a href="userInfo.show" class="login1"><img title="정보 수정 / 탈퇴" src="resources/img/userinfo.png"></a>
		<a href="logout.do" class="login2"><img title="로그아웃" src="resources/img/logout.png"></a>
	</c:if>
	<table id="siteMenuTbl">
		<tr>
			<th class="titleTh" colspan="4">
				<div id="titleDiv" name="홈으로 돌아가기">Useful Calculators <span>${r }</span></div>
			</th>
		</tr>
		<tr>
			<td class="menuTd">
				<div class="menuDiv" id="BMI">BMI 계산기</div>
			</td>
			<td class="menuTd">
				<div class="menuDiv" id="Base">진수 변환기</div>
			</td>
			<td class="menuTd">
				<div class="menuDiv" id="Unit">단위 계산기</div>
			</td>
			<td class="menuTd">
				<div class="menuDiv" id="ASCII">ASCII Code 변환기</div>
			</td>
		</tr>
	</table>
	<table id="siteContentTbl">
		<tr>
			<td>
				<jsp:include page="${contentPage }" />
			</td>
		</tr>
	</table>
</body>
</html>