<%@page import="java.util.Calendar"%>
<%@page import="java.util.List"%>
<%@page import="com.OMC.daos.ClassService"%>
<%@page import="com.OMC.dtos.lectureapply.LectureConfirmDto"%>
<%@page import="com.OMC.dtos.LoginUserDto"%>
<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<%!
public String isNull(String s){
	if(s==null){
		s="&nbsp";
		return s;
	}else{
		return s;
	}
}
%>

<% Object obj = session.getAttribute("login"); 
LoginUserDto login = (LoginUserDto)obj;
if(login == null){

	response.sendRedirect("index.jsp");
}
%>
<%
int gradestgyo=0;
int gradestjun=0;
int remainjun=0;
int remaingyo=0;
int gradecdt=0;
Calendar cal = Calendar.getInstance();
int year = cal.get(Calendar.YEAR);
int month = cal.get(Calendar.MONTH);

ClassService service = ClassService.getInstance();
LectureConfirmDto udto = service.getStudentInfo(login.getStudent_cd());
//LectureConfirmDto lcd = new LectureConfirmDto("200730238","2011","10");
//List<LectureConfirmDto> lists = service.getLactureConfirmList(lcd);
LectureConfirmDto sdto = service.getGradeStandard(login.getStudent_cd());
if(Integer.parseInt(udto.getEnt_year()) >= 2010){
	gradestgyo=15;
}else{
	gradestgyo=10;
}
if(Integer.parseInt(udto.getEnt_year()) >= 2010){
	gradestjun=64;
}else{
	gradestjun=54;
}

if(gradestjun - Integer.parseInt(sdto.getComdiv_cd2()) <0 ){
	remainjun = 0;
}else{
	remainjun = gradestjun - Integer.parseInt(sdto.getComdiv_cd2());
}
if(gradestgyo - Integer.parseInt(sdto.getComdiv_cd1()) < 0 ){
	remaingyo = 0;
}else{
	remaingyo = gradestgyo - Integer.parseInt(sdto.getComdiv_cd1());
}
if(sdto.getStudent_period().equalsIgnoreCase("2")){
	gradecdt = 80;
}else if(sdto.getStudent_period().equalsIgnoreCase("3")){
	gradecdt = 120;
}else{
	gradecdt = 0;
}
if(month <=2 ){
	year = year -1;
}
%>
<html>
<head>
<title>수강신청</title>
<link rel="stylesheet" type="text/css" href="./css/omc.css">
<script type="text/javascript" src="jquery-1.7.1.min.js"></script>
<script type="text/javascript">
function search(stuId, year, smtSel){
	
		$.ajax({
			type: "POST",
		   //url: "http://localhost:8090/OMC_Project/searchAjaxServlet",
		   url: "./lecConfirmAjaxServlet",
		   data: "&stuId="+stuId+"&year="+year+"&smtSel="+smtSel,		   
		   async: true,		   
		   success: function(msg){
			   var leng = msg.lecconfirmdto.length;
			   var rows = $("#confirmlist tr");
			   if(leng==0){
				   alert("수강신청한 내역이 없습니다.");
			   }
			   
				if(leng>0) {
					for(var i = 0; i < rows.length; i++) {
						$("#index"+i).remove();
					} 
					$("#noindex").remove();
					for(var i = 0; i < leng; i++) {
						var curi_num = msg.lecconfirmdto[i].curi_num;
						
						var curi_nm = msg.lecconfirmdto[i].curi_nm;
						var curi_class = msg.lecconfirmdto[i].curi_class;
						var cont_desc = msg.lecconfirmdto[i].cont_desc; 
						var class_div = msg.lecconfirmdto[i].class_div; 
						var cdt_num = msg.lecconfirmdto[i].cdt_num;
						var time_sheet = msg.lecconfirmdto[i].time_sheet;
						var kor_nm = msg.lecconfirmdto[i].kor_nm;
						var recourse_div;
						var pass_fail;
						if(msg.lecconfirmdto[i].recourse_div=="nbsp;"){ 
							recourse_div ="&"+msg.lecconfirmdto[i].recourse_div;
						}else{
							recourse_div = msg.lecconfirmdto[i].recourse_div;
						}
						if(msg.lecconfirmdto[i].pass_fail=="nbsp;"){ 
							pass_fail ="&"+msg.lecconfirmdto[i].pass_fail; 
						}else{ 
							pass_fail = msg.lecconfirmdto[i].pass_fail;
						}
						$('#confirmlist tr:eq(1)').after(
								"<tr id='index"+i+"'>"
								+"<td>"+curi_num+"</td>"
								+"<td>"+curi_nm+"</td>"
								+"<td>"+curi_class+"</td>"
								+"<td>"+cont_desc+"</td>"
								+"<td>"+class_div+"</td>"
								+"<td>"+cdt_num+"</td>"
								+"<td>"+time_sheet+"</td>"
								+"<td>"+kor_nm+"</td>"
								+"<td>"+recourse_div+"</td>"
								+"<td>"+pass_fail+"</td>"
								+"</tr>");
					}
				}else{
					for (var i = 0; i <= rows.length; i++) {
						
						$("#index"+i).remove();
					}
					$("#noindex").remove();
					$('#confirmlist tr:eq(0)').after(
							"<tr id='noindex'>"
							+"<td colspan='10' align='center'>해당되는 과목이 없습니다.</td>"
							+"</tr>");
					
				}
				}//AjaxServlet에서 값을 받아 jsp에 뿌려준다.
		});	
	
}

</script>
</head>

<body>
	<br>
<table border='0' width='85%' cellpadding="0" cellspacing="0">
	<tr height='15'>
		<td align="center"><h4>수 강 | 수강신청 내역 조회  </h4></td>
	</tr>
	<tr>
		<td align="right">
			<input type="button" value="조회" name="src" onclick="search(<%=login.getStudent_cd()%>,year.value,smtSel.value)">
		</td>
	</tr>
</table>
<table width="85%" cellpadding="0" cellspacing="0">		
	<tr>
		<td id='listTitle'>검색조건</td>
	</tr>
	<tr>
		<td>
			<table border='1' width='100%' cellpadding="0" cellspacing="0">
				<col width='100'>
				<col width='150'>
				<col width='100'>
				<col width='150'>
				<col width='100'>
				<col width='150'>
				<col width='100'>
				<col width='150'>
				<tr align='center'>
					<td id='title'>학년도	</td>
					<td><input type="text" name="year" id='contInput' readonly="readonly" value="<%=year%>"></td>
					<td id='title'>학기</td>
					<td>
						<select id='contSelect' name='smtSel' >
						    <option value="10">1학기</option>
						    <option value="11">여름학기</option>
						    <option value="20">2학기</option>
						    <option value="21" >겨울학기</option>
					    </select>
					</td>
					<td id='title'>학 번</td>
					<td id='cont'><%=udto.getStudent_cd() %></td>
					<td id='title'>성 명</td>
					<td id='cont'><%=udto.getKor_nm() %></td>
					<td><input type=button value='검색'></td>
				</tr>
			</table>
		</td>
	</tr>
</table>

	<table border='0' width="85%" cellpadding="0" cellspacing="0">
		<tr>
			<td colspan="3" id='listTitle'>학생정보</td>
		</tr>			
		<tr>
			<td width="30%">
				<table border='1' width="100%" cellpadding="0" cellspacing="0">
					<tr align='center'>
						<td id='title'>학과/전공</td>
						<td id='cont'><%=isNull( udto.getDept_nm()) %></td>
						<td id='title'>학년</td>
						<td id='cont'><%=udto.getStudent_year() %></td>
						<td id='title'>반</td>
						<td id='cont'><%=udto.getStudent_class() %></td>
						<td id='title'>번호</td>
						<td id='cont'><%=udto.getStudent_num() %></td>
					</tr>
				</table></td>
				
			<td width="20%">
				<table border='1' width="100%" height='100%' cellpadding="0" cellspacing="0">
					<tr>
						<td colspan='5' id='title' height='25'>졸업기준대비 이수현황</td>
					</tr>
					<tr align='center' height='25'>
						<td id='title'>이수구분
						</td>
						<td id='title'>졸업기준
						</td>
						<td id='title'>이수학점
						</td>
						<td id='title'>수강학점
						</td>
						<td id='title'>잔여학점
						</td>
					</tr>
					<tr align='center'>
						<td id='title'>교양</td>
						<td id='cont'><%=gradestgyo %></td>
						<td id='cont'><%=sdto.getComdiv_cd1() %></td>
						<td id='cont'>0</td>
						<td id='cont'><%=remaingyo%></td>
					</tr>
					<tr align='center'>
						<td id='title'>전공</td>
						<td id='cont'><%=gradestjun%></td>
						<td id='cont'><%=sdto.getComdiv_cd2()%></td>
						<td id='cont'>0</td>
						<td id='cont'><%=remainjun%></td>
					</tr>
				</table>
				</td>
				<td width="10%">
				<table border="1" width="100%" cellpadding="0" cellspacing="0" height="100">	
					<col width='80' />
					<col width='50' />			
					<tr>
						<td id='title'>졸업학점</td>
						<td id='cont'><%=gradecdt %></td>
					</tr>
					<tr>
						<td id='title'>취득학점</td>
						<td id='cont'><%=Integer.parseInt(sdto.getComdiv_cd1()) +Integer.parseInt(sdto.getComdiv_cd2())  %></td>
					</tr>
					<tr>
						<td id='title'>전공교양</td>
						<td id='cont'>0</td>
					</tr>
					<tr>
						<td id='title'>P/F필수</td>
						<td id='cont'><%=sdto.getComdiv_cd3() %></td>
					</tr>
				</table>
				</td>
				</tr>
				</table>
				<table class=ex1 width="85%" cellpadding="0" cellspacing="0">
				<tr>
						<td id='listTitle'>수강신청내역</td>
				</tr>
				<tr>
						<td>
							<table id="confirmlist" border='0' width="100%" class=ex1 cellpadding="0" cellspacing="0">
								<col width='65'>
								<col width='80'>
								<col width='80'>
								<col width='80'>
								<col width='80'>
								<col width='80'>
								<col width='200'>
								<col width='100'>
								<col width='80'>
								<col width='80'>
								<tr class=grade height='25'>
									<td id='title'>학수번호</td>
									<td id='title'>교과목명</td>
									<td id='title'>강좌</td>
									<td id='title'>이수구분</td>
									<td id='title'>주야구분</td>
									<td id='title'>학점</td>
									<td id='title'>요일/교실/강의실</td>
									<td id='title'>담당교수</td>
									<td id='title'>수강구분</td>
									<td id='title'>승인</td>
								</tr>

						<tr>
							<th></th>
							<th></th>
							<th></th>
						</tr>

							</table>
				</table>
			</td>
		</tr>
</table>
<br><br>
</body>
</html>
