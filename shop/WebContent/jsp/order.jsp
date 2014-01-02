<%-- order.jsp --%>
<%@page contentType="text/html;charset=euc-kr" %>
<%@page import="pjsp.shopmall.beans.*" errorPage="error.jsp" %>
<%
	LoginInfoBean user = (LoginInfoBean)session.getAttribute("userInfo");
	if(user == null) {
		response.sendRedirect("main.jsp");
		return;
	} 
%>
<jsp:useBean id="utils" class="pjsp.shopmall.util.UtilBean" scope="application" />
<jsp:useBean id="book" class="pjsp.shopmall.beans.BookBean" scope="page">
<%
	book.setUtils(utils);
%>
<jsp:setProperty name="book" property="*" />
</jsp:useBean>
<jsp:useBean id="cart" class="pjsp.shopmall.beans.CartBean" scope="session" />
<jsp:useBean id="userInfo" class="pjsp.shopmall.beans.LoginInfoBean" scope="session" />
<HTML><HEAD><TITLE> �ֹ� ���� </TITLE></HEAD>
<BODY BGCOLOR="WHITE" TEXT="BLACK" LINK="BLUE" VLINK="PURPLE" ALINK="RED">
<CENTER>
<H3><B><jsp:getProperty name="userInfo" property="name" /></B> ���� ���� ǰ���� �����ϼ̽��ϴ�.</H3>
</CENTER> 
<%
	if(request.getParameter("order").equals("addcart")) {
		cart.addItem(book);
%>
<jsp:getProperty name="book" property="book" />
<%
	} else if(request.getParameter("order").equals("cartview")) {
%>
		<jsp:getProperty name="cart" property="cart" />
<%
	}
%>
	<CENTER>
	 <A HREF="bookview.jsp?<jsp:getProperty name="cart" property="prevParam" />" > 
	���� </A> ���� ����&nbsp;&nbsp; 
<%
	if(request.getParameter("order").equals("addcart")) {
%>	
		&nbsp;&nbsp;<A HREF="order.jsp?order=cartview">���� īƮ ����</A>
		</CENTER><BR>
<%
	} else if(request.getParameter("order").equals("cartview")) {
%>
		<A HREF="finish.jsp">�ֹ� �Ϸ�</A></CENTER><BR> 
		<A HREF="order.jsp?order=empty">����īƮ ����</A>
<%
	} else if(request.getParameter("order").equals("empty")) {
%>
		<jsp:setProperty name="cart" property="empty" value="true" />
<%
	}
%>
<%@include file="footer.html" %>
</BODY>
</HTML>