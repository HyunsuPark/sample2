<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>게시글 삭제</title>
</head>
<body>
	<h1 align="center">게시글 삭제</h1>
	<hr align="center" size="2" width="50%" color="green" />
	<form action="tdelete" method="post">
	<table align="center" width="70%" border="1" cellspacing="0" cellpadding="5">
		<tr bgcolor="#99ccff">
			<th width="30">선택</th>
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
			<td><input type="checkbox" name="travel_code" value='<c:out value="${result.travel_code}"/>'></td>
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
	<br>
	<div align="center">
		<input type="submit" value="삭제">
	</div>
	</form>
	<p/>
	<div align="center">
		<br>
		<a href="index.jsp">첫페이지로</a>
	</div>
</body>
</html>