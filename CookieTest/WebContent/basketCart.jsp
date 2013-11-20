<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>장바구니 보기로 연결</title>
</head>
<body>
	<%
		out.print("<a href='" + response.encodeURL("basketCookie") + "'>장바구니 내용 보기</a>");
	%>
</body>
</html>