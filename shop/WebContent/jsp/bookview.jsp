<%-- bookview.jsp --%>
<%@page  contentType="text/html;charset=euc-kr"%>
<%@page import="java.sql.*,java.net.*,pjsp.shopmall.util.*" %>
<%@page import="pjsp.shopmall.beans.*" %>
<%
	LoginInfoBean user = (LoginInfoBean)session.getAttribute("userInfo");
	if(user == null) {
		response.sendRedirect("main.jsp");
		return;
	} 
%>
<jsp:useBean id="database" class="pjsp.shopmall.beans.PoolManagerBean" scope="application" />
<jsp:useBean id="utils" class="pjsp.shopmall.util.UtilBean" scope="application" />
<jsp:useBean id="cart" class="pjsp.shopmall.beans.CartBean" scope="session" />

<jsp:setProperty name="cart" property="prevParam" value="<%=request.getQueryString() %>" /> 
<%
	String category = request.getParameter("category");
	String isbn = request.getParameter("isbn");
	String title = request.getParameter("title");
	category = utils.asc2ksc(category);
	isbn = utils.asc2ksc(isbn);
	title = utils.asc2ksc(title);
	
	Connection connection = database.getConnection();
	Statement stmt = connection.createStatement();
	String query;
	if(isbn != null) {
		query = 
		"Select * from books where title=" + utils.makeSQL(title) + 
		" and category=" + utils.makeSQL(category) + 
		" and isbn=" + utils.makeSQL(isbn);
	} else {
		query = 
		"Select * from books where title=" + utils.makeSQL(title) + 
		" and category=" + utils.makeSQL(category) ;
	}
	ResultSet rset = stmt.executeQuery(query);
	int price = 0;
	String author = null;
	int remaining = 0;
	String publisher = null;
	while(rset.next()) {
		price = rset.getInt("price");
		author = rset.getString("author");
		remaining = rset.getInt("remaining");
		String description = rset.getString("description");
		publisher = rset.getString("publisher");
		isbn = rset.getString("isbn");
%>
<HTML><HEAD><TITLE> �оߺ� å��� (<%= title %>) </TITLE></HEAD>
<BODY BGCOLOR="WHITE" TEXT="BLACK" LINK="BLUE" VLINK="PURPLE" ALINK="RED">
<CENTER>
<%@include file="rotator.jsp"%> 
<BR><BR>
<H2>Java Power Group &nbsp;&nbsp; �¶��� ���� ���θ� </H2>
<BR>
<FONT SIZE="+2" COLOR="BLUE"><%= title %></FONT> &nbsp;&nbsp; By <%= author %><HR>
</CENTER>
����: <%= price %> �� <BR>
���: <%= remaining > 0 ? "" + remaining + " ��": "����" %><BR>
���ǻ�: <%= publisher %> <BR><P>
<B>����:</B><P> <%= description %> <BR>
<%
	}
	try {
		rset.close();
		stmt.close();
	} finally {
		database.releaseConnection(connection);
	}
%> 		
<BR><BR><BR>
<BR>
<% 
	if(remaining > 0) {
%>
<TABLE ALIGN="CENTER" BORDER="0" WIDTH="500" CELLPADDING="10">
<TR>
	<FORM  ACTION="order.jsp" >
	<INPUT TYPE="HIDDEN" NAME="price" VALUE="<%=price%>">
	<INPUT TYPE="HIDDEN" NAME="author" VALUE="<%=author%>">
	<INPUT TYPE="HIDDEN" NAME="title" VALUE="<%=title%>">
	<INPUT TYPE="HIDDEN" NAME="publisher" VALUE="<%=publisher%>">
	<INPUT TYPE="HIDDEN" NAME="remaining" VALUE="<%=remaining%>">
	<INPUT TYPE="HIDDEN" NAME="isbn" VALUE="<%=isbn%>">
	<INPUT TYPE="HIDDEN" NAME="category" VALUE="<%=category%>">
	<INPUT TYPE="HIDDEN" NAME="order" VALUE="addcart" >
	<TD ALIGN="RIGHT" WIDTH="50%">
	<INPUT TYPE="SUBMIT" VALUE="����īƮ�� �߰�">
	</TD>
	<TD>����: <INPUT TYPE="TEXT" NAME="quantity" SIZE="3"></TD>
	</FORM>
	<FORM  ACTION="order.jsp"> 
	<INPUT TYPE="HIDDEN" NAME="order" VALUE="cartview" >
	<TD ALIGN="LEFT" >
	<INPUT TYPE="SUBMIT" VALUE="����īƮ ����">
	</TD>
	</FORM>
	
</TR>
</TABLE>
<%
	}
%>
<P ALIGN="CENTER"><A HREF="main.jsp">����</A>���� ����&nbsp;&nbsp; 
<A HREF="categoryview.jsp?category=<%=URLEncoder.encode(category)%>">����</A> 
&nbsp;&nbsp;
<A HREF="logout.jsp?logout=true">�α׾ƿ�</A></P>
<%@ include file="footer.html" %>
</BODY>
</HTML>     
