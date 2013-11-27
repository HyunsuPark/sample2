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
						<td>${row.no}</td>
					</tr>
					<tr>
						<th>이름</th>
						<td>${row.name}</td>
					</tr>
					<tr>
						<th>직위</th>
						<td>${row.jik}</td>
					</tr>
					<tr>
						<th>전화번호</th>
						<td>${row.tel}</td>
					</tr>
				</table>
			</div>
</body>
</html>