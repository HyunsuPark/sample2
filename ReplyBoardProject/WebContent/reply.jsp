<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>답글</title>
<link href="css/table.css" rel="stylesheet" type="text/css"/>
<link href="css/button.css" rel="stylesheet" type="text/css"/>
</head>
<body>
	<h1 align="center">답글</h1>
	<hr/>
	<form action="reply" method="post">
	<input type="hidden" name="idx" value="${row.idx}">
	<input type="hidden" name="lev" value="${row.lev}">
	<table width="500" cellspacing="0" cellpadding="2" align="center">
		<tr>
			<th width="100">제목</th>
			<td width="400"><input type="text" readonly="readonly" name="subject" value="${row.subject}"></td>
		</tr>
		<tr>
			<th width="100">이름</th>
			<td width="400"><input type="text" name="writer"></td>
		</tr>
		<tr>
			<th width="100">비밀번호</th>
			<td width="400"><input type="password" name="pwd"></td>
		</tr>
		<tr>
			<th width="100">내용</th>
			<td width="400"><textarea name="content" rows="5"></textarea></td>
		</tr>
	</table>
	<div align="center">
		<span class="button medium"><input type="submit" value="등록"></span> &nbsp;&nbsp;&nbsp; <span class="button medium"><input type="button" value="취소" onclick="window.location='list'"></span>
	</div>
	</form>
	<br><br>
</body>
</html>