<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>수정완료</title>
</head>
<body>
	<h1 align="center">수정완료</h1>
	<hr align="center" size="2" width="50%" color="green" />
	<table align="center" width="70%" border="1" cellspacing="0" cellpadding="5">
		<tr bgcolor="#99ccff">
			<th width="50">번호</th>
			<th width="350">상품명</th>
			<th width="150">상품가격</th>
		</tr>
 	<c:forEach var="result" items="${list}" varStatus="status">
		<tr>
			<td><c:out value="${status.count}"/></td>
			<td><c:out value="${result.travel_title}"/></td>
			<td><c:out value="${result.price}"/></td>
		</tr>
	</c:forEach>
	</table>
	<p/>
	<div align="center">
		<a href="index.jsp">첫페이지로</a>
	</div>
</body>
</html>