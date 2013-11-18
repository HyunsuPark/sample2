<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>
<%@ page import="java.util.ArrayList,notice.model.vo.Notice" %>
<%
	ArrayList<Notice> list = (ArrayList<Notice>)request.getAttribute("list");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>게시글 목록보기</title>
</head>
<body>
	<h1 align="center">게시글 목록</h1>
	<hr align="center" size="2" width="50%" color="green" />
	<table align="center" width="700" border="1" cellspacing="0" cellpadding="5">
		<tr bgcolor="#99ccff">
			<th width="50">번호</th>
			<th width="150">작성자</th>
			<th width="150">게시날짜</th>
			<th width="350">제목</th>
		</tr>
		<%
			for(Notice n : list)
			{
		%>
		<tr>
			<td><%= n.getNoticeNo() %></td>
			<td><%= n.getNoticeWriter() %></td>
			<td><%= n.getNoticeDate() %></td>
			<td><a href="detail?no=<%= n.getNoticeNo() %>"><%= n.getNoticeTitle() %></a></td>
		</tr>
		<% } %>
	</table>
	<p/>
	<div align="center">
		<a href="insertNotice.html">글쓰기</a><br/>
		<a href="index.html">첫페이지로</a>
	</div>
</body>
</html>