<%-- search.jsp --%>
<%@page errorPage="error.jsp" contentType="text/html;charset=euc-kr"%>
<%@page import="java.sql.*,java.net.*,pjsp.shopmall.beans.*" %>
<%
	LoginInfoBean user = (LoginInfoBean)session.getAttribute("userInfo");
	if(user == null) {
		response.sendRedirect("main.jsp");
		return;
	} 
%>
<jsp:useBean id="database" class="pjsp.shopmall.beans.PoolManagerBean" scope="application" />
<jsp:useBean id="utils" class="pjsp.shopmall.util.UtilBean" scope="application" />
<HTML><HEAD><TITLE> 분야별 검색 목록 (<%= utils.asc2ksc(request.getParameter("category")) %>) </TITLE></HEAD>
<BODY BGCOLOR="WHITE" TEXT="BLACK" LINK="BLUE" VLINK="PURPLE" ALINK="RED">
<CENTER>
<%@include file="rotator.jsp"%> 
<BR><BR>
<H2>Java Power Group &nbsp;&nbsp; 온라인 서적 쇼핑몰 </H2>
<BR>
<FONT SIZE="+2" COLOR="BLUE"><%= utils.asc2ksc(request.getParameter("category"))%></FONT> 서적 목록
</CENTER>
<%
	String category = request.getParameter("category");
	String isbn = request.getParameter("isbn");
	category = utils.asc2ksc(category);
	isbn = utils.asc2ksc(isbn);
	
	Connection connection = database.getConnection();
	Statement stmt = null;
	ResultSet rset = null;
	String query = "select * from books where category=" + utils.makeSQL(category) + " and isbn=" + utils.makeSQL(isbn); 
	try {
		stmt = connection.createStatement();
		rset = stmt.executeQuery(query);
		if(rset.next()) {
			String title = rset.getString("title");
%>
<jsp:forward page="bookview.jsp">
<jsp:param name="title" value='<%=title%>' />
</jsp:forward>
<%
		}
	} finally {
		rset.close();
		stmt.close();
		database.releaseConnection(connection);
	}		
%>
<P ALIGN="CENTER"> <B>해당 분야에 등록된 서적중 ISBN 이 <%= isbn%> 인 서적이 없습니다.</B>
<P ALIGN="CENTER"><A HREF="main.jsp"> 메인</A>으로 </P>
<BR><BR><BR>
<%@ include file="footer.html" %>
</BODY>
</HTML>

