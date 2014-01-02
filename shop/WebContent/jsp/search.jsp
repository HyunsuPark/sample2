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
<HTML><HEAD><TITLE> �оߺ� �˻� ��� (<%= utils.asc2ksc(request.getParameter("category")) %>) </TITLE></HEAD>
<BODY BGCOLOR="WHITE" TEXT="BLACK" LINK="BLUE" VLINK="PURPLE" ALINK="RED">
<CENTER>
<%@include file="rotator.jsp"%> 
<BR><BR>
<H2>Java Power Group &nbsp;&nbsp; �¶��� ���� ���θ� </H2>
<BR>
<FONT SIZE="+2" COLOR="BLUE"><%= utils.asc2ksc(request.getParameter("category"))%></FONT> ���� ���
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
<P ALIGN="CENTER"> <B>�ش� �о߿� ��ϵ� ������ ISBN �� <%= isbn%> �� ������ �����ϴ�.</B>
<P ALIGN="CENTER"><A HREF="main.jsp"> ����</A>���� </P>
<BR><BR><BR>
<%@ include file="footer.html" %>
</BODY>
</HTML>

