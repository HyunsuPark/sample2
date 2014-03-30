<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%
String msg = (String)request.getAttribute("result");
String next_url = (String)request.getAttribute("next_url");
%>
<!DOCTYPE html>
<html>
<head>
	<script type="text/javascript">
		var msg = "<%= msg %>";
		var url = "<%= next_url %>";
		
		if(msg=="join_ok"){
			alert("회원가입되었습니다");	
		}
		location.href = "../"+url;
	</script>
</head>
