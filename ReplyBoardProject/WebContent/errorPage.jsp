<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>에러페이지</title>
<link href="css/table.css" rel="stylesheet" type="text/css"/>
<link href="css/button.css" rel="stylesheet" type="text/css"/>
</head>
</head>
<body>
<h1>에러처리용 페이지</h1>
<pre><%= exception.getClass().getName() %></pre>
<span class="button medium"><a href="index.html">첫페이지로</a></span>
</body>
</html>