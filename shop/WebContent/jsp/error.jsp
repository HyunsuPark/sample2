<%-- error.jsp --%>
<%@ page isErrorPage="true" contentType="text/html;charset=euc-kr"%>
<HTML><HEAD><TITLE>오류 발생</TITLE></HEAD>
<BODY BGCOLOR="WHITE" TEXT="BLACK" LINK="BLUE" VLINK="PURPLE" ALINK="RED">
<CENTER>
<% 
	if(exception instanceof java.sql.SQLException ) {
%>
		죄송합니다. 데이터 베이스 오류: <FONT COLOR="RED" ><%= exception.getMessage() %></FONT>
<%
	} else {
%>	
	<%= exception.toString() %>	
	오류 내용:&nbsp;&nbsp;<%= exception.getMessage()%>
<%
	}
%>
</CENTER>
</BODY>
</HTML>