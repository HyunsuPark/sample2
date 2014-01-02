<%@ page language="java" contentType="text/html; charset=utf-8" %>
<% request.setCharacterEncoding("utf-8"); %>
<% response.setContentType("text/html; charset=utf-8");%>
<table>
	<tr>
		<td><b>성적관리</b></td>
	</tr>
	<tr>
		<td><a href="./menu_control.jsp?command=thisgrade">금학기성적조회</a></td>
	</tr>
	<tr>
		<td><a href="./menu_control.jsp?command=allgrade">전체학기성적조회</a></td>
	</tr>

</table>