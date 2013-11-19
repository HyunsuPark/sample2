<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="user.model.vo.User" %>
<%
	User loginUser = (User)session.getAttribute("loginUser");
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>메뉴 페이지</title>
<style type="text/css">
	ul {
		list-style : none;
	}
	
	ul li{
		display : inline;
		float : left;
		padding-left : 30px;
	}

	a {
		text-decoration : none;
	}
	
	hr {
		clear : left;
	}
</style>
</head>
<body>
<%
	if(loginUser == null)
	{
%>
<a href="/travel/login.html">로그인</a>
<% }else { %>
<ul>
	<li><%= loginUser.getName() %></li>
	<li><a href="logout">로그아웃</a></li>
	<li><a href="tlist">여행상품검색</a></li>
	<li>여행상품수정</li>
	<li>여행상품삭제</li>
	<li><a href="tinsert">여행상품등록</a></li>
</ul>
<% } %>
</body>
</html>