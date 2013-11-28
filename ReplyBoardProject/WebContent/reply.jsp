<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>답글</title>
<style type="text/css">
	td {
		border-bottom-width : 1px;
	}
</style>
</head>
<body>
	<h1 align="center">답글</h1>
	<hr/>
	<form action="reply" method="post">
	<input type="hidden" name="idx" value="${row.idx}">
	<input type="hidden" name="lev" value="${row.lev}">
	<table width="500" cellspacing="0" cellpadding="2" align="center">
		<tr>
			<th width="100" bgcolor="#ffcc00">제목</th>
			<td width="400"><input type="text" readonly="readonly" name="subject" value="${row.subject}"></td>
		</tr>
		<tr>
			<th width="100" bgcolor="#ffcc00">이름</th>
			<td width="400"><input type="text" name="writer"></td>
		</tr>
		<tr>
			<th width="100" bgcolor="#ffcc00">비밀번호</th>
			<td width="400"><input type="password" name="pwd"></td>
		</tr>
		<tr>
			<th width="100" bgcolor="#ffcc00">내용</th>
			<td width="400"><textarea name="content" rows="5" cols="10" style="width: 333px"></textarea></td>
		</tr>
	</table>
	<input type="submit" value="등록"> &nbsp;&nbsp;&nbsp; <input type="button" value="취소" onclick="window.location='list'">	
	</form>
	
</body>
</html>