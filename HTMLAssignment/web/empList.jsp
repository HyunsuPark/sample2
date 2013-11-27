<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
				<h2>직원 정보 조회</h2>
				<table border="1">
					<tr>
						<th>사번</th>
						<th>이름</th>
						<th>직위</th>
						<th>전화번호</th>
					</tr>
					<c:forEach var="result" items="${list}" varStatus="status">
						<tr>
							<c:url value="view" var="url"><c:param name="no" value="${result.no}" /></c:url>
							<td><a href="${url}"><c:out value="${result.no}"/></a></td>
							<td><c:out value="${result.name}"/></td>
							<td><c:out value="${result.jik}"/></td>
							<td><c:out value="${result.tel}"/></td>
						</tr>
					</c:forEach>
				</table>
			</div>
</body>
</html>