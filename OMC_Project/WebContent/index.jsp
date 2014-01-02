<%@ page language="java" contentType="text/html; charset=utf-8" %>
<% request.setCharacterEncoding("utf-8"); %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>OMC 학사관리시스템</title>
<link rel="stylesheet" type="text/css" href="./css/omc.css">
<script type="text/javascript">
function login(){
	document.loginform.submit();
}
</script>
</head>
<body leftmargin="0" topmargin="0" marginwidth="0" marginheight="0" background="./images/bg.gif" style="background-repeat: no-repeat;">
<center>
<p>

<table border='0' width='100%'>
	<tr height="175">
		<td width='550'>&nbsp;</td>
		<td>&nbsp;</td>
	</tr>
	<tr>
		<td>&nbsp;</td>
		<td>
		<form action="menu_control.jsp" method="post" name='loginform'>
		<input type='hidden' name='command' value='login'/>
		
				<table border='0' cellspacing='0' cellpadding='0' class='login'>
					<tr class='loign'>
						<td align="center" class='loign'>아이디</td>
						<td><input type="text" style="width:100%;" value="201038237" name="id" maxlength="12"></td>
						<td rowspan="2"><img src='./images/button/btn_login.gif' onclick="login()" style="cursor:hand"></td>
					</tr>
					<tr class='loign'>
						<td align="center">비밀번호</td>
						<td><input type="password" value="1020211" name="password" maxlength="12"></td>
					</tr>
					
				</table>
		</form>
		</td>
	</tr>
</table>
</center>
</body>
</html>