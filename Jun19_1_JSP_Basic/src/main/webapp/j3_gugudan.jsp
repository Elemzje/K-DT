<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style type="text/css">
	#tbl {
		float: left;
		margin-right: 10px;
	}
</style>
</head>
<body>
	<%	
		String dan = "<tr>";
		for (int i = 2; i < 10; i ++) {
			dan += "<th>" + i + "단</th>";
		}
		dan += "</tr>";
	%>
	<%
		String gugudan = "";
		int num = 0;
		for (int i = 1; i < 10; i++) {
			gugudan += "<tr>";
			for (int j = 2; j < 10; j++) {
				num = i * j;
				gugudan += String.format("<td>%d X %d = %d</td>", j, i, num); 
			}
			gugudan += "</tr>";
		}
	%>
	<table>
		<%=dan %>
		<%=gugudan %>
	</table>
	
	<table>
		<tr>
		<% for (int i = 2; i < 10; i++) { %>
			<th><%=i %>단</th>
		<%}%>
		</tr>
		<% for (int i = 1; i < 10; i++) { %>
			<tr>
				<%for (int j = 2; j < 10; j++) { %>
					<td><%=j %> X <%=i %> = <%=j*i %></td>
				<%} %>
			</tr>
		<%} %>
	</table>
	
	<% for (int i = 2; i < 10; i ++) { %>
	<table id="tbl">
		<tr>
			<th><%=i %>단</th>
		</tr>
		<% for (int j = 1; j < 10; j++) { %>
		<tr>
			<td>
				<%=i %> X <%=j %> = <%=i*j %>
			</td>
		<tr>
		<%} %>
	</table>
	<%} %>
</body>
</html>