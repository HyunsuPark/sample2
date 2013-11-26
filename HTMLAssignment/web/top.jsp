<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script src="http://code.jquery.com/jquery-1.7.1.min.js"></script>
<script type="text/javascript">
	function linkedPage(URL){
			$("div#right").html("<object data=\"" + URL + "\" width=100% height=100%>")
	}
</script>
</head>
<body>
	<div>
		<a href="javascript:linkedPage('home.jsp')">[홈]</a>
		<a href="javascript:linkedPage('login.jsp')">[로그인]</a>
		<a href="javascript:linkedPage('login.jsp')">[직원관리?]</a>
	</div>
</body>
</html>

