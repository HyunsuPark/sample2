<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="member.model.dto.Member"%>
<%
	//전달받은 request 가 가진 세션객체의 ID를 사용해서
	//해당 세션객체를 찾아서 객체 정보를 리턴받음
	session = request.getSession(false);
	Member m = (Member)session.getAttribute("user");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>로그인 성공 페이지</title>
</head>
<body>
<%= m.getName() %> 님 로그인되었습니다.<br/>
<a href="logout">로그아웃</a><p>
<a href="msearch?uid=<%= m.getMemberId() %>">회원정보수정</a>
<br/>
<a href="mdelete?userid=<%= m.getMemberId() %>">회원탈퇴</a><p/>
<a href="list">게시글 목록</a>
</body>
</html>