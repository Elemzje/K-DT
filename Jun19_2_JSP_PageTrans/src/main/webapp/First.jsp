<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function gogo() {
		location.href = "Second.jsp?a=10&b=20";
	}
</script>
</head>
<body>
	<h1>First</h1>
	<hr>
	
	<!-- 
		First.jsp에서 두 숫자를 입력했을 때
		Second.jsp에서 각 숫자들 출력하기
	 -->
	 
	 <a href="Second.jsp?a=10&b=20">&lt;a&gt;로 [GET방식 요청]</a>
	 <hr>
	 <div onclick="gogo();">JavaScript로 [GET방식 요청]</div>
	 <hr>
	 <form action="Second.jsp">
	 a 입력 : <input name="a"><p>
	 b 입력 : <input name="b"><p>
	 <button>요청</button>
	 </form>
	 
</body>
</html>