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
	<br>
	<c:choose>
		<c:when test="${sessionScope.loginUser == null}">직원관리시스템</c:when>
		<c:otherwise>
			<a href="list">[직원조회]</a>
			<br>
			<a href="list?div=insert">[직원등록]</a>
		</c:otherwise>
	</c:choose>
</body>
</html>

