<%@ page language="java" contentType="text/html; charset=utf-8" %>
<% request.setCharacterEncoding("utf-8"); %>
<% response.setContentType("text/html; charset=utf8");%>

<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>OMC 학사관리시스템</title>
<link rel="stylesheet" type="text/css" href="./css/omc.css">
<script type="text/javascript">
//메뉴바
function onMenuAction()
	{
		var img_id = event.srcElement.id;
		event.srcElement.src = "./images/top/" + img_id + "_over.gif";
	}
	
function outMenuAction()
	{
		var img_id = event.srcElement.id;
		event.srcElement.src = "./images/top/" + img_id + ".gif";
	}
	
</script>


</head>
<body leftmargin='0' topmargin='0' marginwidth='0' marginheight='0'>
<table border="1" cellpadding='0' cellspacing='0' width='100%'>
  <tr>
    <td colspan="2" align="center" valign="top"><tiles:insertAttribute name="top"/></td>
  </tr>
  <tr>
    <td align="center" valign="top" align="center" width="10%"><tiles:insertAttribute name="left"/></td>
    <td align="center" valign="top" align="center" width="100%"><tiles:insertAttribute name="right"/></td>
  </tr>
</table>         
</body>
</html>