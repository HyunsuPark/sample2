<%@page import="com.OMC.dtos.LoginUserDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>

<%
	request.setCharacterEncoding("utf-8");
	response.setContentType("text/html; charset=utf-8");
	String apps=request.getContextPath();
%>
<html>
<head>
<title></title>
<script type="text/javascript" src="jquery-1.7.1.min.js"></script>
<link rel="stylesheet" type="text/css" href="./css/omc.css">
<script type="text/javascript">
function search(stuId, year, smtSel){

	
		$.ajax({
			type: "POST",
		   //url: "http://localhost:8090/OMC_Project/searchAjaxServlet",
		   url: "./stuSearchAjaxServlett",
		   data: "&stuId="+stuId+"&year="+year+"&smtSel="+smtSel,		   
		   async: true,		   
		   success: function(msg){
			   var leng = msg.stuseardto.length;

			   if(leng==0){
				   alert("시간표가 없습니다.");
			   }
			   for(var i=1;i<=14;i++){
				   for(var j=1;j<7;j++){
					   $("#tdNm"+i+j).text(" ");
				   }
			   }   
			   for(var i=0;i<leng;i++){
				var weekTime = msg.stuseardto[i].sttStartTime+msg.stuseardto[i].sttWeekDay;
				
				var curiNm = msg.stuseardto[i].slaCuriNm;
				var korNm = msg.stuseardto[i].aemKorNm;
				var bld = msg.stuseardto[i].abcBldNm;
				var room = msg.stuseardto[i].arcRoomNm;
				
				$("#tdNm"+weekTime).append(curiNm+"<br>"+korNm+"<br>"+bld+" "+room+"<br>");

			   }
		   }
		});	
	
}

</script>
</head>
<body>
 <% Object obj = session.getAttribute("login"); 
LoginUserDto login = (LoginUserDto)obj;
%>

<br>
<table width="85%" cellpadding="0" cellspacing="0">
	<tr>
		<td>
	<table border='0' width='100%' cellpadding="0" cellspacing="0">
		<tr height='15'>
			<td><td align="center"><h4>수 강 | 학생별 시간표 조회  </h4></td>
				<div align="right">
					<input type="button" value="조회" onclick="search(stuId.value,year.value,smtSel.value)">
				</div>
				<table border='1' cellpadding="0" cellspacing="0" width='100%'>
					<tr>
						<td  id='title' width="90" align="center">학년도</td>
						<td width="50"><input type="text" id='year' name='year' size='4'
							maxlength='4' value='2011' readonly="readonly">
						</td>
						<td  id='title' width="50" align="center">학기</td>
						<td width="40">
						<select id="smtSel" name="smtSel" disabled="disabled">
								<option value="10" selected="selected">1학기
								<option value="11">여름학기
								<option value="20">2학기
								<option value="21">겨울학기
						</select>
						</td>
						<td width="120" align="center"  id='title'>학번</td>
						<td width="180"><input type = "text" id = "stuId" value='<%=login.getStudent_cd()%>' readonly="readonly"></td>
						<td width="120" align="center"  id='title'>성명</td>
						<td width="180"><input type = "text" id = "stuNm" value='<%=login.getKor_nm()%>' readonly="readonly"></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
<br>
	<table border='0' width="85%" cellpadding="0" cellspacing="0">
		<tr>
			<td align='center'><div><h4>시간표</h4></div><br>
				<table border='1' cellpadding="0" cellspacing="0" width='100%'>
					<tr align="center">
						<td>교시/요일</td>
						<td>월</td>
						<td>화</td>
						<td>수</td>
						<td>목</td>
						<td>금</td>
						<td>토</td>
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
		</td>
	</tr>
</table>
</body>
</html>