<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="notice.model.vo.Notice" %>
<%
	Notice n = (Notice)request.getAttribute("row");
%>    
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
			<td width="400"><%= n.getNoticeNo() %></td>
		</tr>
		<tr>
			<th width="100" bgcolor="#ffcc00">작성자</th>
			<td width="400"><%= n.getNoticeWriter() %></td>
		</tr>
		<tr>
			<th width="100" bgcolor="#ffcc00">글제목</th>
			<td width="400"><%= n.getNoticeTitle() %></td>
		</tr>
		<tr>
			<th width="100" bgcolor="#ffcc00">글쓴날</th>
			<td width="400"><%= n.getNoticeDate() %></td>
		</tr>
		<tr>
			<th width="100" bgcolor="#ffcc00">글내용</th>
			<td width="400"><%= n.getNoticeContent() %></td>
		</tr>
	</table>
	<p/>
	<hr/>
	<div align="center">
	<a href="updateview?no=<%= n.getNoticeNo() %>">수정하기</a>
	&nbsp; &nbsp; &nbsp; &nbsp;
	<a href="delete?no=<%= n.getNoticeNo() %>">삭제하기</a>
	<p/>
	</div>
	<a href="list">목록으로</a><br/>
	<a href="index.html">첫페이지로</a>
	
</body>
</html>