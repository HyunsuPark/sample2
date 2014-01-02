<%@ page language="java" contentType="text/html; charset=utf-8" %>

<% request.setCharacterEncoding("utf-8"); %>
<% response.setContentType("text/html; charset=utf-8");%>
<link rel="stylesheet" type="text/css" href="./css/omc.css">
<table width="100%" cellpadding='0' cellspacing='0' border="0">
	<tr align="left">
	<td><img src='./images/top/top_banner.gif' border="0"></td>
		<td width="80%" valign="bottom">
		<table width="100%" background="./images/top/top_pattern.gif" border="0" cellpadding='0' cellspacing='0' border="0" >
				<tr>
					<td width="10%">&nbsp;</td>
					<td align="right"><a href="./menu_control.jsp?command=main">
					<img id='top_btn_01' src='./images/top/top_btn_01.gif' border="0" onMouseOver='onMenuAction()' onMouseOut='outMenuAction()' style='cursor:hand'></a></td> 
			 		<td  align="right" ><a href="./menu_control.jsp?command=haksa">
			 		<img id='top_btn_02' src='./images/top/top_btn_02.gif' border="0" onMouseOver='onMenuAction()' onMouseOut='outMenuAction()' style='cursor:hand'></a></td> 
		 			<td  align="left"><a href="./menu_control.jsp?command=class">
		 			<img id='top_btn_03' src='./images/top/top_btn_03.gif' border="0" onMouseOver='onMenuAction()' onMouseOut='outMenuAction()' style='cursor:hand'></a></td>
		 			<td width="50%">&nbsp;</td>
		 			 
					</tr>
				</table>
		</td>
	</tr>
</table>