<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="notice.model.vo.Notice" %>
<%
	Notice n = (Notice)request.getAttribute("notice");
%>     
<!DOCTYPE html>
<html>
<head>
<meta charset=utf-8>
<title>수정 페이지</title>
</head>
<body>
	<h1 align="center">게시글 수정 페이지</h1>
	<hr/>
	<form action="update" method="post">
	<input type="hidden" name="no" value="<%= n.getNoticeNo() %>">
	<input type="hidden" name="writer" value="<%= n.getNoticeWriter() %>">
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
			<td width="400">
			<input type="text" name="title" size="50" value="<%= n.getNoticeTitle() %>">
			</td>
		</tr>
		<tr>
			<th width="100" bgcolor="#ffcc00">글쓴날</th>
			<td width="400"><%= n.getNoticeDate() %></td>
		</tr>
		<tr>
			<th width="100" bgcolor="#ffcc00">글내용</th>
			<td width="400">
			<textarea name="content" rows="10" cols="50">
			<%= n.getNoticeContent() %>
			</textarea>
			</td>
		</tr>
		<tr>
			<td colspan="2">
			<input type="submit" value="수정"> &nbsp;
			<input type="button" value="취소" onclick="location.replace('list');">
			</td>
		</tr>
	</table>
	</form>
	<p/>
</body>
</html>