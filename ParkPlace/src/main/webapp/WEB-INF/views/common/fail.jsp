<%@ page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<%
String msg = (String)request.getAttribute("result");
%>
<!DOCTYPE html>
<html>
<head>
	<script type="text/javascript">
		var msg = "<%= msg %>";
		alert(msg);
		history.back();
	</script>
</head>
