<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8" import="member.model.dto.Member" %>
<%
	String div = (String)request.getAttribute("info");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>정보</title>
<script type="text/javascript">
	if(<%= div.equals("del") %>){
		alert("탈퇴되었습니다. 다시 로그인하시기바랍니다.");
	}else if (<%= div.equals("udt") %>){
		alert("회원정보수정되었습니다. 다시 로그인하시기바랍니다.");
	}
	
	location.href = "login.html";
</script>
</head>
<body>
</body>
</html>