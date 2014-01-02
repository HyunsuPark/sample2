<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="com.OMC.daos.SearchManager"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="com.OMC.dtos.search.Search1Dto"%>
<%@page import="com.OMC.dtos.search.Select11Dto"%>
<%@page import="com.OMC.dtos.search.Search1ConDto"%>
<%
	request.setCharacterEncoding("utf-8");
	response.setContentType("text/html; charset=utf-8");
	String apps=request.getContextPath();
%>
<html>
<head>
<title></title>
<script type="text/javascript" src="jquery-1.7.1.min.js"></script>
<link rel="stylesheet" href="./css/omc.css" type="text/css">
<script type="text/javascript">
function search(comYear, comClass, year, smtSel, deptSel, mojSel){
	if(comYear!=""&&comClass!=""&&year!=""&&smtSel!=""&&deptSel!=""&&mojSel!=""){
		$.ajax({
			type: "POST",
		   //url: "http://localhost:8090/OMC_Project/searchAjaxServlet",
		   url: "./searchAjaxServlet",
		   data: "comYear="+comYear+"&comClass="+comClass+"&year="+year+"&smtSel="+smtSel+"&mojSel="+mojSel,		   
		   async: true,		   
		   success: function(msg){
			   var leng = msg.seardto.length;
			   if(leng==0){
				   alert("시간표가 없습니다.");
			   }
			   for(var i=1;i<=14;i++){
				   for(var j=1;j<7;j++){
					   $("#tdNm"+i+j).text(" ");
				   }
			   }   
			   for(var i=0;i<leng;i++){
				var weekTime = msg.seardto[i].sttStartTime+msg.seardto[i].sttWeekDay;
	
				var curi = msg.seardto[i].scmCuriNm;
				var room = msg.seardto[i].arcRoomNm;
				var kor = msg.seardto[i].aemKorNm;
				var bld = msg.seardto[i].abcBldNm;
				
				$("#tdNm"+weekTime).append(curi+"<br>"+bld+" "+room+"<br>"+kor+"<br>");

			   }
		   }
		});	
	}else if(comYear!=""&&comClass!=""&&year!=""&&smtSel!=""&&deptSel!=""&&mojSel==""){
		$.ajax({
			type: "POST",
		   //url: "http://localhost:8090/OMC_Project/searchAjaxServlet",
		   url: "./searchAjaxServlet",
		   data: "comYear="+comYear+"&comClass="+comClass+"&year="+year+"&smtSel="+smtSel+"&mojSel="+deptSel,		   
		   async: true,		   
		   success: function(msg){
			   var leng = msg.seardto.length;
			   if(leng==0){
				   alert("시간표가 없습니다.");
			   }
			   for(var i=1;i<=14;i++){
				   for(var j=1;j<7;j++){
						 $("#tdNm"+i+j).text(" ");
				   }
			   }   
			   for(var i=0;i<leng;i++){
				var weekTime = msg.seardto[i].sttStartTime+msg.seardto[i].sttWeekDay;
	
				var curi = msg.seardto[i].scmCuriNm;
				var room = msg.seardto[i].arcRoomNm;
				var kor = msg.seardto[i].aemKorNm;
				var bld = msg.seardto[i].abcBldNm;
				
				$("#tdNm"+weekTime).append(curi+"<br>"+bld+" "+room+"<br>"+kor+"<br>");

			   }
		   }
		});		
	}else{
		var err = "";
		if(year==""){
			err = err+"년도 ";
		}
		if(deptSel==""){
			err = err+"학과 ";
		}
		if(comYear==""){
			err = err+"학년 ";
		}
		if(comClass==""){
			err = err+"반 ";
		}
		alert(err+"칸이 비어있습니다.");
	}
}

function select12(deptCd){
	$.ajax({
		type: "POST",
		   //url: "http://localhost:8090/OMC_Project/search2AjaxServlet",
		   url: "./select12AjaxServlet",
		   data: "deptCd="+deptCd,		   
		   async: true,		   
		   success: function(msg){
			   var leng = msg.select12dto.length;
			   var rows = $("#mojSel option");
			   if(rows.length>1){

				   for(var i=0;i<=rows.length;i++){   
						 $("#rowsleng"+i).remove();
				   }
				   for(var i=0;i<leng;i++){
					   
						var deptCd = msg.select12dto[i].deptCd;
						var deptNm = msg.select12dto[i].deptNm;
						
						$("#mojSel").append(
								"<option id='rowsleng"+i+"' value='"+deptCd+"'>"+deptNm+"</option>"
						);
					}
			   }else{
				   if(leng!=0){
					   for(var i=0;i<leng;i++){
						   
							var deptCd = msg.select12dto[i].deptCd;
							var deptNm = msg.select12dto[i].deptNm;
							
							$("#mojSel").append(
									"<option id='rowsleng"+i+"' value='"+deptCd+"'>"+deptNm+"</option>"
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
	List<Select11Dto> lists11 = dao.getSelect11List();
%>
	<table border='0' width='85%'>
		<tr>
			<td><center><b>학년반별 시간표</b></center>
				<div align="right">
					<input type="button" value="조회" onclick="search(comYear.value,comClass.value,year.value,smtSel.value,deptSel.value,mojSel.value)">
				</div>
				<table border='1' width="100%" cellpadding="0" cellspacing="0">
					<tr>
						<td id=title width="90" align="center">학년도</td>
						<td width="50"><input type="text" id='year' name='year' size='4'
							maxlength='4'>
						</td>
						<td  id=title width="50" align="center">학기</td>
						<td width="40"><select id="smtSel" name="smtSel">
								<option value="10">1학기
								<option value="11">여름학기
								<option value="20">2학기
								<option value="21">겨울학기
						</select>
						</td>
						<td  id=title width="80" align="center">학과</td>
						<td width="200">&nbsp;
						<select name="deptSel" onchange="select12(this.value)">
							<option>선택</option>
						<%for(Select11Dto dto11 : lists11){%>
							<option value="<%=dto11.getDeptCd()%>"><%=dto11.getDeptNm()%></option>
						<%}%>
						</select>
						</td>
						<td  id=title width="120" align="center">전공/코스</td>
						<td width="180">
						<select name="mojSel" id="mojSel" style="width: '170'">
							<option>선택</option>
						</select>
						</td>
					</tr>
				</table>
				<table border='1' width="100%" cellpadding="0" cellspacing="0">
					<tr>
						<td  id=title width="50" align="center" >학년</td>
						<td width="90"><input type="text" id='comYear' name='comYear' maxlength='1'></td>
						<td id=title width="50" align="center">반</td>
						<td width="80"><input type="text" id='comClass' name='comClass' maxlength='1'></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
<br>
	<table border='1' width="85%" cellpadding="0" cellspacing="0">
		<tr>
			<td align='center' ><table width="100%"><tr><td id=listTitle><div  align="center">시간표</div></td></tr></table>
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