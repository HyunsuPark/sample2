<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
	<div id="content">
		<div id="top" style="width: 1200px; height: 100px; border: solid 1px;">
			<jsp:include page="top.jsp" />
		</div>
		<div id="left"
			style="width: 200px; height: 800px; border: solid 1px; float: left">
			<jsp:include page="menu.jsp" />
		</div>
		<div id="right"  
			style="width: 1000px; height: 800px; border: solid 1px; float: left">
			<jsp:include page="login.jsp" />
		</div>
	</div>
</body>
</html>

