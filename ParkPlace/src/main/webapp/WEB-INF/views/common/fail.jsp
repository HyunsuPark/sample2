<%
String msg = (String)request.getAttribute("result");
%>
<!DOCTYPE html>
<html>
<head>
	<script type="text/javascript">
		var msg = "<%= msg %>";
		alert(msg);
	</script>
</head>
