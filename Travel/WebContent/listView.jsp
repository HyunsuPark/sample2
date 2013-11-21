<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>게시글 목록보기</title>
</head>
<body>
	<h1 align="center">게시글 목록</h1>
	<hr align="center" size="2" width="50%" color="green" />
	<table align="center" width="70%" border="1" cellspacing="0" cellpadding="5">
		<tr bgcolor="#99ccff">
			<th width="50">번호</th>
			<th width="250">지역</th>
			<th width="350">상품명</th>
			<th width="150">출발일자</th>
			<th width="150">도착일자</th>
			<th width="150">상품가격</th>
			<th width="350">항공사</th>
		</tr>
 	<c:forEach var="result" items="${list}" varStatus="status">
		<tr>
			<td><c:out value="${status.count}"/></td>
			<td><c:out value="${result.location}"/></td>
			<td><c:out value="${result.travel_title}"/></td>
			<td><c:out value="${result.departure_date}"/></td>
			<td><c:out value="${result.return_date}"/></td>
			<td><c:out value="${result.price}"/></td>
			<td><c:out value="${result.airline}"/></td>
		</tr>
	</c:forEach>
	</table>
	<p/>
	<div align="center">
	<form action="tlist?div=all" method="post">
		지역검색 <input type="text" name="loc"> <button>검색</button>
	</form>
		<br>
		<a href="index.jsp">첫페이지로</a>
	</div>
</body>
</html>