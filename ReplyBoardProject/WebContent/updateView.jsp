<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset=utf-8>
<title>수정 페이지</title>
<link href="css/table.css" rel="stylesheet" type="text/css"/>
<link href="css/button.css" rel="stylesheet" type="text/css"/>
</head>
<body>
	<h1 align="center">게시글 수정 페이지</h1>
	<hr/>
	<form action="update" method="post">
	<input type="hidden" name="idx" value="${row.idx}">
	<input type="hidden" name="writer" value="${row.writer}">
	<table width="500" cellspacing="0" cellpadding="2" align="center">
		<tr>
			<th>제목</th>
			<td><input type="text" name="subject" value="${row.subject}"></td>
		</tr>
		<tr>
			<th>내용</th>
			<td><textarea name="content" rows="10" cols="50">${row.content}</textarea></td>
		 </tr>
	</table>
	<div align="center">
	<br><br>
		<span class="button medium"><input type="submit" value="수정"></span> &nbsp;
		<span class="button medium"><input type="button" value="취소" onclick="location.replace('list');"></span>	
	</div>
	</form>
	<p/>
</body>
</html>