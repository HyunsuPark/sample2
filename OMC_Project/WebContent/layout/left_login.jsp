<%@page import="com.OMC.dtos.LoginUserDto"%>
<%@ page language="java" contentType="text/html; charset=utf-8" %>
<% request.setCharacterEncoding("utf-8"); %>
<% response.setContentType("text/html; charset=utf-8");%>
<% Object obj = session.getAttribute("login"); 
LoginUserDto login = (LoginUserDto)obj;
if(login == null){

	response.sendRedirect("index.jsp");
}
%>
<link rel="stylesheet" type="text/css" href="./css/omc.css">
<table width="200">
	<tr>
		<td>
		<table width="100%" cellspacing='0' cellpadding='0' border="0">
		<tr>
			<td width="70%">
		<table width="100%" cellspacing='0' cellpadding='0' border="1" >
			<tr align="center">				
				<td><%=login.getKor_nm() %></td>
			</tr>
			<tr align="center">				
				<td><%=login.getStudent_cd() %></td>
			</tr>
		</table>
		</td>
		<td width="30%"><a href="./menu_control.jsp?command=logout"><img src='./images/button/btn_logout.gif' border='0'></a></td>
		</tr>
		</table>
		</td>
	</tr>
</table>