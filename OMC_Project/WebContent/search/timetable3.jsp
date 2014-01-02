<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.util.Iterator"%>
<%@page import="com.OMC.daos.OMCManager"%>
<%@page import="java.util.List"%>
<%@page import="com.OMC.dtos.search.Search1Dto"%>
<%@page import="com.OMC.dtos.search.ProSelect1Dto"%>
<%@page import="com.OMC.daos.SearchManager"%>
<%@page import="com.OMC.dtos.search.Select21Dto"%>
<%@page import="com.OMC.dtos.search.Search1ConDto"%>
<%
	request.setCharacterEncoding("utf-8");
	response.setContentType("text/html; charset=utf-8");
	String apps=request.getContextPath();
%>
<html>
<head>
<title>교수별 시간표 조회</title>
<script type="text/javascript" src="jquery-1.7.1.min.js"></script>
<link rel="stylesheet" href="./css/omc.css" type="text/css">
<script type="text/javascript">
function search(empId, year, smtSel){

	if(empId!=""&&year!=""&&smtSel!=""){
		$.ajax({
			type: "POST",
		   //url: "http://localhost:8090/OMC_Project/search2AjaxServlet",
		   url: "./search3AjaxServlet",
		   data: "empId="+empId+"&year="+year+"&smtSel="+smtSel,		   
		   async: true,		   
		   success: function(msg){
			   var leng = msg.sear3dto.length;
			   if(leng==0){
				   alert("시간표가 없습니다.");
			   }

			   for(var i=1;i<=14;i++){
				   for(var j=1;j<7;j++){
						 $("#tdNm"+i+j).text(" ");
				   }
			   }   
			   for(var i=0;i<leng;i++){
				   
				var weekTime = msg.sear3dto[i].sttStartTime+msg.sear3dto[i].sttWeekDay;
				var bld = msg.sear3dto[i].abcBldNm;
				var room = msg.sear3dto[i].arcRoomNm;
				var curi = msg.sear3dto[i].scmCuriNm;
				
				$("#tdNm"+weekTime).append(bld+"<br>"+room+"<br>"+curi);

			   }
		   }
		});
	}else if(empId==""){
		alert("교직원 번호와 이름을 선택하셔야 조회 가능합니다.");
	}else{
		alert("년도를 입력하지 않으셨습니다.");
	}
}

var winObject = null;
function popupWindow(){
	var settings ='toolbar=0,directories=0,status=no,menubar=0,scrollbars=yes,resizable=no,height=800,width=900,left=0,top=0';
	winObject = window.open("./search/prosearch.jsp", "prosearch", settings);
	}


</script>
</head>
<body>
	<table border='0' width='85%'>
		<tr>
			<td><center><b>교수별 시간표</b></center>
				<div align="right">
					<input type="button" value="조회" onclick="search(empid.value,year.value,smtSel.value)">
				</div>
				<table border='1' width="100%" cellpadding="0" cellspacing="0">
					<tr>
						<td id=title width="90" align="center">학년도</td>
						<td width="50"><input type="text" id='year' name='year' size='4'
							maxlength='4'>
						</td>
						<td id=title width="50" align="center">학기</td>
						<td width="40"><select id="smtSel" name="smtSel">
								<option value="10">1학기
								<option value="11">여름학기
								<option value="20">2학기
								<option value="21">겨울학기
						</select>
						</td>
						<td id=title width="80" align="center">성명</td>
						<td width="200"><input type="text" id="empnm" name="empnm">
						<input type="button" value="찾기" onclick="popupWindow()">
						<input type="hidden" id="empid" name="empid">
						</td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
<br>
	<table border='1' width="85%" cellpadding="0" cellspacing="0">
		<tr>
			<td align='center'><table width="100%"><tr><td id=listTitle><div  align="center">시간표</div></td></tr></table>
				<table border='1'>
					<tr align="center">
						<td id=title>교시/요일</td>
						<td id=title>월</td>
						<td id=title>화</td>
						<td id=title>수</td>
						<td id=title>목</td>
						<td id=title>금</td>
						<td id=title>토</td>
					</tr>
					

					<%	

						for (int i = 0; i < 14; i++) {
					%>
					<tr align="center">
						<%
							for (int j = 0; j < 7; j++) {
									if (j == 0) {
									%>
										<td width="100" height="50"><%=i + 1%>교시<br> <%
											if(i<1){
											%> 0<%=i+9%>:00 ~ 0<%=i+9%>:50 <%
											}else if(i<3){
											%> <%=i+9%>:00 ~ <%=i+9%>:50 <%
											}else{
											%> <%=i+9%>:40 ~ <%=i+10%>:30 <%
											}
											%>
										</td>
									<%
									} else {
									%>
									<td width="130" height="50" id='tdNm<%=i+1%><%=j%>' style="font-size: '12'">
									&nbsp;
									</td>
									<%
									}
								}
						%>
					</tr>
					<%
						}
					%>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>
