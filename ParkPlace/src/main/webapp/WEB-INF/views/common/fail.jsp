<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%
String msg = (String)request.getAttribute("result");
%>
<!DOCTYPE html>
<html>
<head>
	<script type="text/javascript">
		var msg = "<%= msg %>";
		if(msg=="duple_id"){
			alert("이미 있는 아이디입니다.");	
		}
		history.back();
	</script>
</head>
