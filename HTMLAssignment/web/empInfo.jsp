<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<% 
request.setCharacterEncoding("utf-8");
response.setContentType("text/html;charset=utf-8");

String id = request.getParameter("id");
String name = new String(request.getParameter("name").getBytes("ISO-8859-1"), "UTF-8");
String jik = new String(request.getParameter("jik").getBytes("ISO-8859-1"), "UTF-8");
String tel = request.getParameter("tel");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
				<h2>직원 정보 조회</h2>
				<table border="1">
					<tr>
						<th>사번</th>
						<td><%= id %></td>
					</tr>
					<tr>
						<th>이름</th>
						<td><%= name %></td>
					</tr>
					<tr>
						<th>직위</th>
						<td><%= jik %></td>
					</tr>
					<tr>
						<th>전화번호</th>
						<td><%= tel %></td>
					</tr>
				</table>
			</div>
</body>
</html>