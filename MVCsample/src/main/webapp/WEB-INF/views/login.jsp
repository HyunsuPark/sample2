<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
	내가로그인이다.
	<form action="authentication" method="post">
		ID : <input type="text" name="username" size="20" maxlength="50" /><br />
		Password : <input type="password" name="password" size="20"
			maxlength="50" /><br /> <input type="submit" value="Login" />
	</form>
</body>
</html>