<%-- finish.jsp --%>
<%@page import="pjsp.shopmall.beans.*, java.sql.*" contentType="text/html;charset=euc-kr" %>
<%@page errorPage="error.jsp" %>
<%
	LoginInfoBean user = (LoginInfoBean)session.getAttribute("userInfo");
	if(user == null) {
		response.sendRedirect("main.jsp");
		return;
	}
%>
<jsp:useBean id="shopDB" class="pjsp.shopmall.beans.ShopDBBean" scope="session">
<jsp:setProperty name="shopDB" property="table" value="books" />
<jsp:setProperty name="shopDB" property="orderListTable" value="orderlist" />
<%
	shopDB.setPageContext(pageContext);
%>
</jsp:useBean>
<jsp:setProperty name="shopDB" property="orderComplete" value="true" />
<HTML><HEAD><TITLE>주문 처리</TITLE></HEAD>
<BODY BGCOLOR="WHITE" TEXT="BLACK" LINK="BLUE" VLINK="PURPLE" ALINK="RED">
<CENTER>
<H3>
<jsp:getProperty name="shopDB" property="message" />
</H3><HR>
<jsp:setProperty name="cart" property="empty" value="true" />
<P> <A HREF="main.jsp"> 메인 </A> 으로가기
</CENTER>
</BODY>
</HTML> 