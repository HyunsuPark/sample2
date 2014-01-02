<%-- login.jsp --%>
<%@page import="pjsp.shopmall.beans.*,java.sql.*" contentType="text/html;charset=euc-kr" %>
<%@page import="pjsp.shopmall.util.*"  errorPage="error.jsp" %>
<%
	String reason = request.getParameter("reason");
	if(reason == null) { response.sendRedirect("main.jsp"); return; }
%>
<jsp:useBean id="database" class="pjsp.shopmall.beans.PoolManagerBean" scope="application" />
<jsp:useBean id="utils" class="pjsp.shopmall.util.UtilBean" scope="application" />
<HTML><HEAD><TITLE>로그인 정보</TITLE></HEAD>
<BODY BGCOLOR="WHITE" TEXT="BLACK" LINK="BLUE" VLINK="PURPLE" ALINK="RED">
<CENTER><%@include file="rotator.jsp" %></CENTER><BR><BR>
<%
	String id = request.getParameter("id");
	String passwd = request.getParameter("passwd");
	
	if(reason.equals("login")) {
		id = utils.asc2ksc(id);
		passwd = utils.asc2ksc(passwd);
		String query = "Select * from member where passwd=" + 
		utils.makeSQL(passwd)+ "and id=" + utils.makeSQL(id);
		
		Connection connection = database.getConnection();
		Statement stmt = null; 
		ResultSet rset = null;
		try {
			stmt = connection.createStatement();		
			rset = stmt.executeQuery(query);
			if(rset.next()) {
				String name= rset.getString("name");
				String address = rset.getString("address");
				String phone = rset.getString("phone");
%>
				<jsp:useBean id="userInfo" class="pjsp.shopmall.beans.LoginInfoBean" scope="session">
				<jsp:setProperty name="userInfo" property="name" value='<%= name%>' />
				<jsp:setProperty name="userInfo" property="id" value='<%= id%>' />
				<jsp:setProperty name="userInfo" property="passwd" value='<%= passwd%>' />
				<jsp:setProperty name="userInfo" property="address" value='<%= address%>' />
				<jsp:setProperty name="userInfo" property="phone" value='<%= phone%>' />
				</jsp:useBean>
				<jsp:forward page="main.jsp"/>
<%
			} else {
%>
				<CENTER>
				입력하신  아이디와 비밀번호가 맞지 않습니다. ! 
				<FORM METHOD="POST" ACTION="login.jsp">
				아이디: <INPUT TYPE="TEXT" NAME="id" SIZE="15">&nbsp;&nbsp;&nbsp;
				패스워드: <INPUT TYPE="PASSWORD" NAME="passwd" SIZE="15">
				<INPUT TYPE="HIDDEN" NAME="reason" VALUE="login" > 
				<INPUT TYPE="SUBMIT" VALUE="Login">
				</FORM></CENTER>
<%
			}
		}finally {
			rset.close();
			stmt.close();
			database.releaseConnection(connection);	
		}		
	} else if(reason.equals("register")) {
%>
		<P ALIGN="CENTER">사용자 정보를 입력하세요(*표는 반드시 입력)<HR>
<%
	} else if(reason.equals("duplicate")) { 
%>
		<P ALIGN="CENTER">입력한 패스워드가 이미 존재합니다. 다시 입력하세요<HR>
<%
	}
	if(reason.equals("register") || reason.equals("duplicate")) {
%>
		<TABLE BORDER="0" CELLPADDING="10" >
		<FORM ACTION="addmember.jsp" METHOD="POST">
		<TR><TD>
		아이디*:</TD><TD><INPUT TYPE="TEXT" NAME="id" SIZE="10">
		</TD></TR>
		<TR><TD>
		패스워드*:</TD><TD><INPUT TYPE="PASSWORD" NAME="passwd" SIZE="10">
		</TD></TR>
		<TR><TD>
		성명*:</TD><TD><INPUT TYPE="TEXT" NAME="name" SIZE="10">
		</TD></TR>
		<TR><TD>
		주소*:</TD><TD><INPUT TYPE="TEXT" NAME="address" SIZE="40">
		</TD></TR>
		<TR><TD>
		전화번호*:</TD><TD><INPUT TYPE="TEXT" NAME="phone" SIZE="15">
		</TD></TR>
		<TR><TD>
		<INPUT TYPE="SUBMIT" VALUE="입력">
		</TD><TD>&nbsp;</TD><TR>
		</FORM>
		</TABLE>
<%
	}
%>
<P ALIGN="CENTER"><A HREF="main.jsp">메인 </A> 으로 가기</P>
<%@include file="footer.html" %>
</BODY>
</HTML>