<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="user.model.vo.User"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>로그인 성공 페이지</title>
<style type="text/css">
	div {
		background-color : #99ffff;
		height : 30px;
		margin : 0px;
		padding : 0px;			
	}
</style>
</head>
<body>
	<hr color="green" size="3" />
	<div>
	<%@ include file="menu.jsp" %>
	</div>
	<hr color="blue" size="5" />
	<p/><p/><p/><p/>
	
	<h1 align="center">
		${ sessionScope.loginUser.userId } 님 로그인되었습니다.
	</h1>

	<a href="/travel/index.jsp">첫페이지로 이동</a>
</body>
</html>