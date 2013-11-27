<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<div align="center">
	<form action="login" method="post">
	<table style="border-collapse: collapse; border: 3px black solid; text-align:center;">
		<tr>
		<td style="padding: 30px">
		<table align="center">
		<tr>
		<td colspan="2">
			로그인하여 주세요<br><br>
		</td></tr>
		<tr><td> ID </td>
			<td><input type="text" autofocus required name="user_id" size="20" id="tid" placeholder="4~10글자">
			</td></tr>
			<tr><td>
			PASSWORD </td>
			<td><input type="password" required name="user_pwd" size="20" id="tpwd" placeholder="4~10글자"> 
			</td></tr>
			<tr><td colspan="2">			
			<input type="submit" value="로그인">
			<input type="button" onclick="reset()" value="취소"> 
			</td></tr>
		</table>
		</td>
		</tr>
	</table>
	</form>
</div>
</body>
</html>

