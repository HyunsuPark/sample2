<%@page  contentType="text/html;charset=euc-kr" errorPage="error.jsp" %>
<%@page import="java.net.*,pjsp.shopmall.beans.*,java.sql.*,java.util.*"  %>
<jsp:useBean id="database" class="pjsp.shopmall.beans.PoolManagerBean" scope="application">
<%
	String filePath = application.getRealPath("/jsp/prop/db.properties");
	database.setPath(filePath); 
	database.setUp(); 
%>  
<!-- Initialized Connection Pool -->
</jsp:useBean>
<jsp:useBean id="utils" class="pjsp.shopmall.util.UtilBean" scope="application"> 
<jsp:setProperty name="utils" property="serverInfo" value='<%=application.getServerInfo() %>' />
<!-- TOMCAT Server Info: Tomcat Web Server/3.1 (JSP 1.1; Servlet 2.2; Java 1.2.2; Windows NT 5.0 x86; java.vendor=Sun Microsystems Inc.) -->
<!-- set server Info to: <%= application.getServerInfo() %> -->
</jsp:useBean>

<HTML><HEAD><TITLE>OnLine Book Shopping Mall Using JSP</TITLE></HEAD>
<BODY BGCOLOR="WHITE" TEXT="BLACK" LINK="BLUE" VLINK="PURPLE" ALINK="RED">
<CENTER>
<%-- <jsp:include page="rotator.jsp" flush="true"/> 문제를 발생할 수 있음 (RequestDispatcher..) --%>
<%@include file="rotator.jsp"%> 
<H2>Java Power Group &nbsp;&nbsp; 온라인 서적 쇼핑몰</H2>

<% 
	boolean login = false;
	LoginInfoBean user = (LoginInfoBean)session.getAttribute("userInfo");
	if(user == null) {
%>
<FORM METHOD="POST" ACTION="login.jsp">
이이디: <INPUT TYPE="TEXT" NAME="id" SIZE="15">&nbsp;&nbsp;&nbsp;
패스워드: <INPUT TYPE="PASSWORD" NAME="passwd" SIZE="15">
<INPUT TYPE="HIDDEN" NAME="reason" VALUE="login">
<INPUT TYPE="SUBMIT" VALUE="Login">
</FORM>
<FORM ACTION="login.jsp"> 
<INPUT TYPE="HIDDEN" NAME="reason" VALUE="register">
<INPUT TYPE="SUBMIT" VALUE="등록하기">
</FORM>
<%
	} else {
%>
<jsp:useBean id="userInfo" class="pjsp.shopmall.beans.LoginInfoBean" scope="session"/>
<B><jsp:getProperty name="userInfo" property="name"/></B> 님 즐거운 쇼핑이되세요!		
<%		login = true;
	}
%>
<BR>  
</FORM> 
<%	
	Connection connection  = database.getConnection();
	Statement stmt = connection.createStatement();
	ResultSet rset;
	String category ="";
	String query="";
	Vector categories = new Vector();
	try {

%>

<FORM  ACTION="search.jsp">
<TABLE BORDER="0" CELLPADDING="10">
	<TR>
        	<TD WIDTH="70" HEIGHT="25">
			<P ALIGN="RIGHT">분야별: 
		</TD>
		<TD WIDTH="200" HEIGHT="25"><P ALIGN="RIGHT">
			<SELECT NAME="category">
<%
		query = "select category from categorytable";
		rset = stmt.executeQuery(query);
		while(rset.next()) {
		category = rset.getString("category");
		categories.addElement(category);
%>
				<OPTION>
       			<%= category %>
            			</OPTION>
<%
		}
		rset.close();
		stmt.close();
	} finally {
		database.releaseConnection(connection);
	}
%>
			</SELECT>

		</TD>
		<TD WIDTH="40" HEIGHT="25"><P ALIGN="RIGHT">
			ISBN: 
		</TD>
		<TD WIDTH="40" HEIGHT="25"><P ALIGN="LEFT">
			<INPUT TYPE="TEXT" NAME="isbn" SIZE="15"></TD>
		<TD WIDTH="50" HEIGHT="25"><P ALIGN="CENTER">
			<INPUT TYPE="SUBMIT" VALUE="검색">
		</TD>
	</TR>
</TABLE>
</FORM>
<H4> 분야별 서적 </H4> 
</CENTER> 
<UL>
<TABLE BORDER="0" ALIGN="CENTER" CELLPADDING="10" CELLSPACING="5" WIDTH="650" >
<TR>
<% 	
	int count = 0;
	int num_categories = categories.size();
	while(count < num_categories) {
		category = (String)categories.elementAt(count);
		if( ++count % 2 != 0) {
%>
</TR>
<TR>
<%
		}
%>
	<TD>		
		<FONT SIZE="+1"> <LI><A HREF="categoryview.jsp?category=<%= URLEncoder.encode(category)%>">
		<%=category%></A></FONT>
	</TD>
<%
	}	
%>
</TR>
</TABLE>
</UL>
<BR><BR><BR>
<% 
	if(login) {
%>
		<CENTER> <A HREF="logout.jsp?logout=true"> 로그아웃 </A></CENTER>
<%
	}
%>
<%@ include file="footer.html" %>
</BODY>
</HTML> 
 