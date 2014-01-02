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
	
<table width="200" border='0'>
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
<!-- 	<tr height='5'><td>&nbsp;</td></tr> -->
	<tr>
		<td><br>
			<table border='0' width="100%" cellspacing='0' cellpadding="0">
				<tr>
					<td id='menuB'><a href="./menu_control.jsp?command=classapply">● 수강신청</a></td>
				</tr>
				<tr height='5'><td>&nbsp;</td></tr>
				<tr>
					<td id='menuB'><a href="./menu_control.jsp?command=classapplysearch">● 수강신청내역조회</a></td>
				</tr>
				<tr height='5'><td>&nbsp;</td></tr>
				<tr>
					<td id='menuB'><a href="./menu_control.jsp?command=studentschedule">● 학생별시간표조회</a></td>
				</tr>		
			</table>
		</td>
	</tr>
</table>