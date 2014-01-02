<%-- categoryview.jsp --%>
<%@page errorPage="error.jsp" contentType="text/html;charset=euc-kr"%>
<%@page import="java.sql.*,java.net.*,pjsp.shopmall.util.*" %>
<%@page import="pjsp.shopmall.beans.*" %>
<%
	LoginInfoBean user = (LoginInfoBean)session.getAttribute("userInfo");
	if(user == null) {
		response.sendRedirect("main.jsp");
		return;
	}
%> 
<jsp:useBean id="database" class="pjsp.shopmall.beans.PoolManagerBean" scope="application"/>
<jsp:useBean id="utils" class="pjsp.shopmall.util.UtilBean" scope="application" />
<HTML><HEAD><TITLE>분야별 책목록 (<%= request.getParameter("category") %>) </TITLE></HEAD>
<BODY BGCOLOR="WHITE" TEXT="BLACK" LINK="BLUE" VLINK="PURPLE" ALINK="RED">
<CENTER>
<%@include file="rotator.jsp"%> 
<BR><BR>
<H2>Java Power Group &nbsp;&nbsp; 온라인 서적 쇼핑몰 </H2>
<BR>
<FONT SIZE="+2" COLOR="MAGENTA"><%= request.getParameter("category")%></FONT>&nbsp;  에 대한 서적 목록입니다.
</CENTER>
<UL>
<TABLE BORDER="0" ALIGN="CENTER" CELLPADDING="10" CELLSPACING="5" WIDTH="650" >
<TR>
<%
	
	String category = request.getParameter("category");
	category = utils.asc2ksc(category);
	Connection connection = database.getConnection();
	Statement stmt = null;
	ResultSet rset  = null;
	try {
		stmt = connection.createStatement();
		rset = 
		stmt.executeQuery("Select title from books where category=" +utils.makeSQL(category));
		int count = 0;
		while(rset.next()) {
			String title = rset.getString(1);
			if(++count % 2 != 0) {
%>
</TR>
<TR>
<%
			}
%>
	<TD>
		<LI><A HREF="bookview.jsp?title=<%= URLEncoder.encode(title) %>&category=<%= URLEncoder.encode(category) %>"> <%= title %></A>
	</TD>
<%
		}
		rset.close(); stmt.close();
	} finally {
		database.releaseConnection(connection);
	}
%>
</TR>
</TABLE>
</UL>
<BR><BR><BR>
<CENTER><A HREF="main.jsp">메인</>으로 </A>&nbsp;&nbsp;
<A HREF="logout.jsp?logout=true">로그아웃</A>
</CENTER>
<%@ include file="footer.html" %>
</BODY>
</HTML>     