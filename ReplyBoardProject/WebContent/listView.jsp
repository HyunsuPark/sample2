<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>게시글 목록보기</title>
<link href="css/table.css" rel="stylesheet" type="text/css"/>
<link href="css/button.css" rel="stylesheet" type="text/css"/>
</head>
<body>
	<h1 align="center">게시글 목록</h1>
	<hr align="center" size="2" width="50%" color="green" />
	<table align="center" width="700" border="1" cellspacing="0" cellpadding="5">
		<tr bgcolor="#99ccff">
			<th width="50">번호</th>
			<th width="350">제목</th>
			<th width="100">작성자</th>
			<th width="200">작성일</th>
			<th width="80">조회수</th>
		</tr>
		<c:forEach var="result" items="${list}" varStatus="status">
		<tr>
			<c:url value="detail" var="url"><c:param name="idx" value="${result.idx}" /></c:url>
			<td><c:out value="${result.idx}"/></td>
			<td>
				<c:forEach var="i" begin="1" end="${result.lev}">&nbsp;&nbsp;&nbsp;</c:forEach>
				<c:if test="${result.lev > 0}"><img width="12px" height="12px" src="images/reply.png"> </c:if><a href="${url}"><c:out value="${result.subject}"/></a>
			</td>
			<td><c:out value="${result.writer}"/></td>
			<td><c:out value="${result.writedate}"/></td>
			<td><c:out value="${result.readnum}"/></td>
		</tr>
		</c:forEach>
	</table>
	<p/>
	<div align="center">
		<span class="button medium"><a href="insertNotice.html">글쓰기</a><br/></span>
		<span class="button medium"><a href="index.html">첫페이지로</a></span>
	</div>
</body>
</html>