<%-- error.jsp --%>
<%@ page isErrorPage="true" contentType="text/html;charset=euc-kr"%>
<HTML><HEAD><TITLE>���� �߻�</TITLE></HEAD>
<BODY BGCOLOR="WHITE" TEXT="BLACK" LINK="BLUE" VLINK="PURPLE" ALINK="RED">
<CENTER>
<% 
	if(exception instanceof java.sql.SQLException ) {
%>
		�˼��մϴ�. ������ ���̽� ����: <FONT COLOR="RED" ><%= exception.getMessage() %></FONT>
<%
	} else {
%>	
	<%= exception.toString() %>	
	���� ����:&nbsp;&nbsp;<%= exception.getMessage()%>
<%
	}
%>
</CENTER>
</BODY>
</HTML>