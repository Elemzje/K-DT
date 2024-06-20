<%@page import="com.minju.jun202.main.Guest"%>
<%@page import="java.net.URLEncoder"%>
<%@page import="com.oreilly.servlet.multipart.DefaultFileRenamePolicy"%>
<%@page import="com.oreilly.servlet.MultipartRequest"%>
<%@page import="org.omg.CosNaming._NamingContextExtStub"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/doctor.css">
</head>
<body>
	<% 
		request.setCharacterEncoding("UTF-8");
		Guest g = (Guest) request.getAttribute("g");
	%>
	
	<table id="docTbl">
		<tr>
			<td class="tblHeader" align="center">이름</td>	
			<td class="tblDescription" align="center"><%=g.getName() %></td>	
		</tr>
		<tr>
			<td class="tblHeader" align="center">키</td>	
			<td class="tblDescription" align="center"><%=g.getHeight() * 100 %>cm</td>	
		</tr>
		<tr>
			<td class="tblHeader" align="center">몸무게</td>	
			<td class="tblDescription" align="center"><%=g.getWeight() %>kg</td>	
		</tr>
		<tr>
			<td class="tblHeader" align="center">BMI</td>	
			<td class="tblDescription" align="center"><%=g.getBmi() %></td>	
		</tr>
		<tr>
			<td class="tblDescription" colspan="2" align="center"><marquee>
			당신은 <%=g.getResult() %>입니다.
			</marquee>
			</td>	
		</tr>
		<tr>
			<td class="tblHeader" colspan="2" align="center">
				<img src="img/<%=g.getPhoto() %>" style="max-width: 40%;">
			</td>	
		</tr>
	</table>
	
</body>
</html>