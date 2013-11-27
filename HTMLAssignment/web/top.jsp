<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript">
	function linkedPage(URL){
		$("div#right").html("<object data=\"" + URL + "\" width=100% height=100%>")
		$("div#left").html("직원관리시스템");
	}
	
	function linkedPage2(URL){
		var html = '<a href="javascript:linkedPage3(\'empList.jsp\')">[직원조회]</a><br><a href="javascript:linkedPage3(\'empRegister.jsp\')">[직원등록]</a>';
		$("div#left").html(html);
	}
	
	function linkedPage3(URL){
		$("div#right").html("<object data=\"" + URL + "\" width=100% height=100%>")
	}
</script>
</head>
<body>
	<div>
	<br><br>
		<a href="javascript:linkedPage('home.jsp')">[홈]</a>
		<a href="javascript:linkedPage('login.jsp')">[로그인]</a>
		<a id="emp" href="javascript:linkedPage2('menu.jsp')">[직원관리]</a>
	</div>
</body>
</html>

