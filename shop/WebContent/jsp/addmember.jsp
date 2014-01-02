<%-- addmember.jsp --%>
<%@page import="pjsp.shopmall.beans.*,java.sql.*" contentType="text/html;charset=euc-kr" %>
<%@page import="pjsp.shopmall.util.*" errorPage="error.jsp"%>
<%
	String id = request.getParameter("id");
	String name = request.getParameter("name");
	String passwd = request.getParameter("passwd");
	String address = request.getParameter("address");
	String phone = request.getParameter("phone");
	PoolManagerBean database = (PoolManagerBean)application.getAttribute("database");
	if(database == null || id == null || passwd == null || address == null || phone == null) {
		response.sendRedirect("main.jsp");
		return;
	}
%>
<jsp:useBean id="utils" class="pjsp.shopmall.util.UtilBean" scope="application" />
<%
	 id = utils.asc2ksc(id);
	 name= utils.asc2ksc(name);
	 passwd = utils.asc2ksc(passwd);
	 address = utils.asc2ksc(address);
	 phone = utils.asc2ksc(phone);
	 
	 if( name.equals("") || address.equals("") || phone.equals("") || id.equals("") || passwd.equals("")) {
%>
	<jsp:forward page="login.jsp">
		<jsp:param name="reason" value="register"/>
	</jsp:forward>
<%
	} 
	Connection connection = database.getConnection();
	Statement stmt = null;
	ResultSet rset = null;
	//패스워드 중복 검사
	String query = "Select passwd from member where passwd=" + utils.makeSQL(passwd);
	try {
		stmt = connection.createStatement();
	 	rset = stmt.executeQuery(query);
	 	if(rset.next()) {
%>
<jsp:forward page="login.jsp">
<jsp:param name="reason" value="duplicate" />
</jsp:forward>
<%
		}
		 query = 
		"Insert into member values(" + utils.makeSQL(id)+ "," +  utils.makeSQL(name)+ "," +  
	 	utils.makeSQL(passwd)+ "," + utils.makeSQL(address) + "," + utils.makeSQL(phone) + ")";
	 	System.out.println(query);//for testing use only!
		stmt.executeUpdate(query);
	 	connection.commit(); 
	} catch(SQLException e) {
		connection.rollback();
		rset.close();
		stmt.close();
	} finally {
	  	database.releaseConnection(connection);
	}
	 
%>
<jsp:useBean id="userInfo" class="pjsp.shopmall.beans.LoginInfoBean" scope="session">
<jsp:setProperty name="userInfo" property="name" value='<%=name%>' />
<jsp:setProperty name="userInfo" property="id" value='<%=id%>' />
<jsp:setProperty name="userInfo" property="passwd" value='<%=passwd%>' />
<jsp:setProperty name="userInfo" property="address" value='<%=address%>' />
<jsp:setProperty name="userInfo" property="phone" value='<%=phone%>' />
</jsp:useBean>
<HTML><HEAD><TITLE>회원등록</TITLE></HEAD>
<BODY BGCOLOR="WHITE" TEXT="BLACK" LINK="BLUE" VLINK="PURPLE" ALINK="RED">
<CENTER>
<%@include file="rotator.jsp" %>
<H3><%=name%> 님의 정보는 다음과 같이 등록 되었습니다.</H3>
이름: <jsp:getProperty name="userInfo" property="name" /> <P>
아이디: <jsp:getProperty name="userInfo" property="id" /> <P>
<%-- 패스워드: <jsp:getProperty name="userInfo" property="passwd" /><P> --%>
주소: <jsp:getProperty name="userInfo" property="address" /><P>
전화번호: <jsp:getProperty name="userInfo" property="phone" /><P>
<A HREF="main.jsp">메인</A> 으로 가기
</CENTER>
<%@include file="footer.html" %>
</BODY>
</HTML>