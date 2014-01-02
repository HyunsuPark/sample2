<%-- login.jsp --%>
<%@page import="pjsp.shopmall.beans.*,java.sql.*" contentType="text/html;charset=euc-kr" %>
<%@page import="pjsp.shopmall.util.*"  errorPage="error.jsp" %>
<%
	String reason = request.getParameter("reason");
	if(reason == null) { response.sendRedirect("main.jsp"); return; }
%>
<jsp:useBean id="database" class="pjsp.shopmall.beans.PoolManagerBean" scope="application" />
<jsp:useBean id="utils" class="pjsp.shopmall.util.UtilBean" scope="application" />
<HTML><HEAD><TITLE>�α��� ����</TITLE></HEAD>
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
				�Է��Ͻ�  ���̵�� ��й�ȣ�� ���� �ʽ��ϴ�. ! 
				<FORM METHOD="POST" ACTION="login.jsp">
				���̵�: <INPUT TYPE="TEXT" NAME="id" SIZE="15">&nbsp;&nbsp;&nbsp;
				�н�����: <INPUT TYPE="PASSWORD" NAME="passwd" SIZE="15">
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
		<P ALIGN="CENTER">����� ������ �Է��ϼ���(*ǥ�� �ݵ�� �Է�)<HR>
<%
	} else if(reason.equals("duplicate")) { 
%>
		<P ALIGN="CENTER">�Է��� �н����尡 �̹� �����մϴ�. �ٽ� �Է��ϼ���<HR>
<%
	}
	if(reason.equals("register") || reason.equals("duplicate")) {
%>
		<TABLE BORDER="0" CELLPADDING="10" >
		<FORM ACTION="addmember.jsp" METHOD="POST">
		<TR><TD>
		���̵�*:</TD><TD><INPUT TYPE="TEXT" NAME="id" SIZE="10">
		</TD></TR>
		<TR><TD>
		�н�����*:</TD><TD><INPUT TYPE="PASSWORD" NAME="passwd" SIZE="10">
		</TD></TR>
		<TR><TD>
		����*:</TD><TD><INPUT TYPE="TEXT" NAME="name" SIZE="10">
		</TD></TR>
		<TR><TD>
		�ּ�*:</TD><TD><INPUT TYPE="TEXT" NAME="address" SIZE="40">
		</TD></TR>
		<TR><TD>
		��ȭ��ȣ*:</TD><TD><INPUT TYPE="TEXT" NAME="phone" SIZE="15">
		</TD></TR>
		<TR><TD>
		<INPUT TYPE="SUBMIT" VALUE="�Է�">
		</TD><TD>&nbsp;</TD><TR>
		</FORM>
		</TABLE>
<%
	}
%>
<P ALIGN="CENTER"><A HREF="main.jsp">���� </A> ���� ����</P>
<%@include file="footer.html" %>
</BODY>
</HTML>