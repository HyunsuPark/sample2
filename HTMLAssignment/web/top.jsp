<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript">
	function linkedPage(URL){
		var html = '<a href="list">[직원조회]</a><br><a href="list?div=insert">[직원등록]</a>';
		$("div#left").html(html);
	}
</script>
</head>
<body>
	<div>
	<br><br>
		<c:choose>
		 <c:when test="${sessionScope.loginUser ==null}">
		 	<a href="index.jsp">[홈]</a>
		 	<a href="index.jsp">[로그인]</a>
		 </c:when>
 		 <c:otherwise>
 		    <a href="index.jsp">[홈]</a>
 		 	<a href="logout">[로그아웃]</a>
 		 	<a id="emp" href="javascript:linkedPage('menu.jsp')">[직원관리]</a>
 		 </c:otherwise>
		</c:choose>
	</div>
</body>
</html>

