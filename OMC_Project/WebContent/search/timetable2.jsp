<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@page import="com.OMC.daos.SearchManager"%>
<%@page import="com.OMC.dtos.search.Select21Dto"%>
<%@page import="com.OMC.dtos.search.Search1ConDto"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.OMC.dtos.search.Search1Dto"%>
<%
	request.setCharacterEncoding("utf-8");
	response.setContentType("text/html; charset=utf-8");
	String apps=request.getContextPath();
%>
<html>
<head>
<title>강의실 별 시간표 조회</title>
<script type="text/javascript" src="jquery-1.7.1.min.js"></script>
<link rel="stylesheet" href="./css/omc.css" type="text/css">
<script type="text/javascript">
function search(bldCd, roomCd, year, smtSel){
	if(bldCd!=""&&roomCd!=""&&year!=""&&smtSel!=""){
		$.ajax({
			type: "POST",
		   //url: "http://localhost:8090/OMC_Project/search2AjaxServlet",
		   url: "./search2AjaxServlet",
		   data: "bldCd="+bldCd+"&roomCd="+roomCd+"&year="+year+"&smtSel="+smtSel,		   
		   async: true,		   
		   success: function(msg){
			   var leng = msg.sear2dto.length;
			   if(leng==0){
				   alert("시간표가 없습니다.");
			   }
			   for(var i=1;i<=14;i++){
				   for(var j=1;j<7;j++){
						 $("#tdNm"+i+j).text(" ");
				   }
			   }   
			   for(var i=0;i<leng;i++){
				   
				var weekTime = msg.sear2dto[i].sttStartTime+msg.sear2dto[i].sttWeekDay;
				var dept = msg.sear2dto[i].sdcDeptNm;
				var curi = msg.sear2dto[i].scmCuriNm;
				var kor = msg.sear2dto[i].aemKorNm;
				
				$("#tdNm"+weekTime).append(dept+"<br>"+curi+"<br>"+kor+"<br>");

			   }
		   }
		});
	}else{
		var err = "";
		if(year==""){
			err = err+"년도 ";
		}
		if(bldCd==""){
			err = err+"건물 ";
		}
		if(roomCd==""){
			err = err+"호실 ";
		}
		alert(err+"칸이 비어있습니다.");
	}
}

function select22(bldCd){

	$.ajax({
		type: "POST",
		   //url: "http://localhost:8090/OMC_Project/search2AjaxServlet",
		   url: "./select22AjaxServlet",
		   data: "bldCd="+bldCd,		   
		   async: true,		   
		   success: function(msg){
			   var leng = msg.select22dto.length;
			   var rows = $("#roomCdSelect option");

			   if(rows.length>1){

				   for(var i=0;i<=rows.length;i++){   
						 $("#rowsleng"+i).remove();
				   }
				   for(var i=0;i<leng;i++){
					   
						var roomCd = msg.select22dto[i].roomCd;
						var roomNm = msg.select22dto[i].roomNm;
						
						$("#roomCdSelect").append(
								"<option id='rowsleng"+i+"' value='"+roomCd+"'>"+roomNm+"</option>"
						);
					}
			   }else{
				   if(leng!=0){
					   for(var i=0;i<leng;i++){
						   
							var roomCd = msg.select22dto[i].roomCd;
							var roomNm = msg.select22dto[i].roomNm;
							
							$("#roomCdSelect").append(
									"<option id='rowsleng"+i+"' value='"+roomCd+"'>"+roomNm+"</option>"
							);
						}
				   }
			   }
		   }
	});
}


</script>
</head>
<body>
<%
	SearchManager dao = new SearchManager();
	List<Select21Dto> lists21 = dao.getSelect21List();
%>
	<table border='0' width='85%'>
		<tr>
			<td><center><b>강의실 별 시간표</b></center>
				<div align="right">
					<input type="button" value="조회" onclick="search(bldCd.value,roomCdSelect.value,year.value,smtSel.value)">
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
						<td id=title width="80" align="center">건물</td>
						<td width="200">
						<select name="bldCd" onchange="select22(this.value)">
						<option>선택</option>
						<%for(Select21Dto dto21 : lists21){%>
							<option value="<%=dto21.getBldCd()%>" ><%=dto21.getBldNm()%></option>
						<%}%>
						</select>
						</td>
						<td id=title width="120" align="center">호실</td>
						<td width="180">
						<select width="170" name="roomCdSelect" id="roomCdSelect" style="width='170'">
						<option >선택</option>
						</select>
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
