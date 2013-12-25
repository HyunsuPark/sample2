<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
<form action="board">
	<input type="submit" value="데이터추가" >
</form>
<br>
<table align="center" width="700" border="1" cellspacing="0" cellpadding="5">
	<c:forEach var="result" items="${list}" varStatus="status">
		<tr>
			<td><c:out value="${result.idx}" /></td>
			<td><c:out value="${result.title}" /></td>
			<td><c:out value="${result.content}" /></td>
		</tr>
	</c:forEach>
</table>	

</body>
</html>