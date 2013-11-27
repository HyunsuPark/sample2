<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<div id="content">
		<div id="top" style="width: 801px; height: 100px; border: solid 1px; border-bottom: none;">
			<jsp:include page="top.jsp" />
		</div>
		<div id="left" 
			style="width: 150px; height: 800px; border: solid 1px; border-right:none; float: left">
			<jsp:include page="menu.jsp" />
		</div>
		<div id="right"  
			style="width: 650px; height: 800px; border: solid 1px; float: left">
		<c:choose>
		 <c:when test="${sessionScope.loginUser == null}"><jsp:include page="login.jsp" /></c:when>
		 <c:when test="${list != null}"><jsp:include page="empList.jsp" /></c:when>
		 <c:when test="${row != null}"><jsp:include page="empInfo.jsp" /></c:when>
		 <c:when test="${regi != null}"><jsp:include page="empRegister.jsp" /></c:when>
 		 <c:otherwise><jsp:include page="home.jsp" /></c:otherwise>
		</c:choose>
		</div>
	</div>
</body>
</html>

