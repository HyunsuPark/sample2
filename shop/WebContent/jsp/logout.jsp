<%-- logout.jsp --%>
<%
	String logout = request.getParameter("logout");
	if(logout != null && logout.equals("true")) {
		session.invalidate();
	}
	response.sendRedirect("main.jsp");
	return; /* doesn't need because nothing is transmitted to the client */
%>