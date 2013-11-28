<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>상세보기</title>
<style type="text/css">
	td {
		border-bottom-width : 1px;
	}
</style>
</head>
<body>
	<h1 align="center">게시글 상세보기</h1>
	<hr/>
	<table width="500" cellspacing="0" cellpadding="2" align="center">
		<tr>
			<th width="100" bgcolor="#ffcc00">글번호</th>
			<td width="400">${row.idx}</td>
		</tr>
		<tr>
			<th width="100" bgcolor="#ffcc00">제목</th>
			<td width="400">${row.subject}</td>
		</tr>
		<tr>
			<th width="100" bgcolor="#ffcc00">작성자</th>
			<td width="400">${row.writer}</td>
		</tr>
		<tr>
			<th width="100" bgcolor="#ffcc00">작성일</th>
			<td width="400">${row.writedate}</td>
		</tr>
		<tr>
			<th width="100" bgcolor="#ffcc00">조회수</th>
			<td width="400">${row.readnum}</td>
		</tr>
	</table>
	<p/>
	<hr/>
	<div align="center">
	<c:url value="reply" var="urlReply"><c:param name="idx" value="${row.idx}" /><c:param name="view" value="ok" /></c:url>
	<a href="${urlReply}">댓글달기</a>
	&nbsp; &nbsp; &nbsp; &nbsp;
	<c:url value="updateview" var="urlUdt"><c:param name="idx" value="${row.idx}" /></c:url>
	<a href="${urlUdt}">수정하기</a>
	&nbsp; &nbsp; &nbsp; &nbsp;
	<c:url value="delete" var="urlDel"><c:param name="idx" value="${row.idx}" /></c:url>
	<a href="${urlDel}">삭제하기</a>
	<p/>
	</div>
	<a href="list">목록으로</a><br/>
	<a href="index.html">첫페이지로</a>
	
</body>
</html>