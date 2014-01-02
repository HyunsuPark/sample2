<%@ page language="java" contentType="text/html; charset=utf-8" %>
<% request.setCharacterEncoding("utf-8"); %>
<%@page import="com.OMC.dtos.grade.GradeDto"%>
<%@page import="java.util.List"%>
<%@page import="com.OMC.dtos.student.StudentDto"%>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<head>
<title>학생 정보 조회</title>
<link rel="stylesheet" href="./css/omc.css" type="text/css">
<script type="text/javascript">
function tabch(obj){
	for(var i=1; i<=8; i++){
		if(obj==i){
			document.getElementById("div"+i).style.display='block';
			document.getElementById("t"+i).style.backgroundColor='#9FB6FF';
		}else{
			document.getElementById("div"+i).style.display='none';
			document.getElementById("t"+i).style.backgroundColor='#FFFFFF';
		}
	}
}

</script>
</head>
<%-- <%! --%>
<!-- public String toUTF(String str){ -->
<!-- 	String s=str; -->
<!-- 	try{ -->
<!-- 		s=new String(str.getBytes(),"UTF-8"); -->
<!-- 		//s=new String(str.getBytes(),"UTF-8"); -->
<!-- 	}catch(Exception ee){ -->
		
<!-- 	} -->
<!-- 	return s; -->
<!-- } -->

<!-- %> -->
<body>
<% 
	Object odto = request.getAttribute("sdto");
	Object oStu = request.getAttribute("stu");
	Object oPro = request.getAttribute("pro");
	
	List<StudentDto> sulist = (List<StudentDto>)request.getAttribute("sulist");
	List<GradeDto> gList = (List<GradeDto>)request.getAttribute("gList");
	
	StudentDto dto = new StudentDto();
	dto = (StudentDto) odto;
	
	StudentDto stu = new StudentDto();
	stu = (StudentDto) oStu;
	
	StudentDto pro = new StudentDto();
	pro = (StudentDto) oPro;

	
	int i= 1; // 수강신청 순서번호
%>
<br>
<center>
<br>
<table border='0' width='85%' cellpadding="0" cellspacing="0">
	<tr height='15'>
		<td align="center"><h4>학 적 | 학생정보조회 </h4></td>
	</tr>
	<tr align='center'>
		<td>

		<table border='1' width='85%' cellpadding="0" cellspacing="0">
			<col width='100'/>
			<col width='150'/>
			<col width='100'/>
			<col width='150'/>
			<col width='300'/>
			<tr align='center'>
				<td id='title'><font size='2'>학 번</font></td>
				<td id='cont'> <%=dto.getStudent_cd() %> </td>
				<td id='title'><font size='2'>성 명</font></td>
				<td id='cont'> <%=dto.getKor_nm() %> </td>
				<td align='right'><input type=button value='검색'>
			</tr>
		</table>
	</td>
</tr>	
</table>

<table border="0" cellpadding="0" cellspacing="0" width='85%'>
<tr>
	<td id='listTitle' >
		<b>학생정보</b>
	</td>
</tr>
<tr>
	<td>
		<table border="1" cellpadding="0" cellspacing="0" width='100%'>
		 <col width='100'>
		 <col width='150'>
		 <col width='100'>
		 <col width='150'>
		 <col width='100'>
		 <col width='150'>
		 <col width='100'>
		 <col width='100'>
			<tr align='center'>
				<td id='title'>학번</td>
				<td id='cont'><%=dto.getStudent_cd() %></td>
				<td id='title'>성명</td>
				<td id='cont'><%=dto.getKor_nm() %></td>
				<td id='title'>주민등록번호</td>
				<td colspan='3' id='cont'><%=dto.getSsn() %></td>
			</tr>
			<tr align='center'>
				<td id='title'>학적상태</td>
				<td id='cont'><%=dto.getSchool_sts() %></td>
				<td id='title'>수업년한</td>
				<td id='cont'><%=dto.getStudent_period() %></td>
				<td id='title'>주야구분</td>
				<td id='cont'> <%=dto.getClass_div() %></td>
				<td id='title'>교과적용년도</td>
				<td id='cont'> <%=dto.getCuri_year() %></td>
			</tr>
			<tr align='center'>
				<td id='title'>학과</td>
				<td id='cont'><%=dto.getOlg_dept_nm() %></td>
				<td id='title'>전공</td>
				<td id='cont'>
				<%if(dto.getOlg_major_nm()==null){
				%>
				&nbsp;
				<%
				}else{
				%>
				<%=dto.getOlg_major_nm()%>
				<%
				}
				%>		
				</td>
				<td id='title'>학년-반-번호</td>
				<td id='cont'><%=dto.getStudent_num()%></td>
				<td id='title'>졸업판정구분</td>
				<td id='cont'><%=dto.getSchool_chk() %></td>
			</tr>
			<tr align='center'>
				<td id='title'>전화번호</td>
				<td id='cont'><%=dto.getPhone() %></td>
				<td id='title'>휴대폰</td>
				<td id='cont'><%=dto.getM_phone()%></td>
				<td id='title'>E-MAIL</td>
				<td colspan='3' id='cont'><%=dto.getE_mail()%></td>
			</tr>
			<tr align='center'>
				<td id='title'>우편번호</td>
				<td id='cont'><%=dto.getZip() %></td>
				<td id='title'>주소</td>
				<td colspan='5' id='cont'><%=dto.getAddr() %></td>
			</tr>
			<tr align='center'>
				<td id='title'>학위등록번호</td>
				<td id='cont'>
				<%if(dto.getDeg_num()==null){
				%>
				&nbsp;
				<%
				}else{
				%>
				<%=dto.getDeg_num() %>
				<%
				}
				%>		
				</td>
				<td id='title'>계좌번호</td>
				<td id='cont'>
				<%if(dto.getRef_acct_num()==null){
				%>
				&nbsp;
				<%
				}else{
				%>
				<%=dto.getRef_acct_num() %>
				<%
				}
				%>
				</td>
				<td id='title'>은행명</td>
				<td id='cont'>
				<%if(dto.getBank()==null){
				%>
				&nbsp;
				<%
				}else{
				%>
				<%=dto.getBank() %>
				<%
				}
				%>
				</td>
				<td id='title'>예금주</td>
				<td id='cont'>
				<%if(dto.getRef_depo_nm()==null){
				%>
				&nbsp;
				<%
				}else{
				%>
				<%=dto.getRef_depo_nm() %>
				<%
				}
				%></td>
			</tr>
		</table>
	</td>
</tr>	
</table>
<table border='1' cellpadding="0" cellspacing="0" width='85%'>
		 <col width='200'>
		 <col width='200'>
		 <col width='200'>
		 <col width='200'>
		 <col width='200'>
<tr>
	<td colspan='8' id='listTitle' >
		<b>Data</b>
	</td>
</tr>
<tr align='center' height='25'>
	<td id='t1'  onclick='tabch(1)' onmouseover="this.style.backgroundColor='#9FB6FF'" onmouseout="this.style.backgroundColor='#ffffff'" style='cursor:hand; font-size: 13px; color: #464646; font-weight: bold;'>학생정보</td>
	<td id='t2'  onclick='tabch(2)' onmouseover="this.style.backgroundColor='#9FB6FF'" onmouseout="this.style.backgroundColor='#ffffff'" style='cursor:hand; font-size: 13px; color: #464646; font-weight: bold;'>보호자</td>
	<td id='t3'  onclick='tabch(3)' onmouseover="this.style.backgroundColor='#9FB6FF'" onmouseout="this.style.backgroundColor='#ffffff'" style='cursor:hand; font-size: 13px; color: #464646; font-weight: bold;'>학적변동</td>
	<td id='t4'  onclick='tabch(4)' onmouseover="this.style.backgroundColor='#9FB6FF'" onmouseout="this.style.backgroundColor='#ffffff'" style='cursor:hand; font-size: 13px; color: #464646; font-weight: bold;'>수강</td>
	<td id='t5'  onclick='tabch(5)' onmouseover="this.style.backgroundColor='#9FB6FF'" onmouseout="this.style.backgroundColor='#ffffff'" style='cursor:hand; font-size: 13px; color: #464646; font-weight: bold;'>성적</td>
</tr>
</table>

<div style='display:block' id="div1">
	<table border='1' cellpadding="0" cellspacing="0" width='85%'>
		 <col width='20'>
		 <col width='100'>
		 <col width='150'>
		 <col width='100'>
		 <col width='200'>
		 <col width='150'>
		 <col width='200'>
		 <col width='100'>
		<tr align='center'>
			<td rowspan='2' id='title'>기<br>본</td>
		</tr>
		<tr align='center'>		
			<td id='title'>국적</td>
			<td id='cont' ><%=stu.getNation() %></td>
			<td id='title'>출신고교</td>
			<td id='cont'><%=stu.getSchool_nm() %></td>
			<td id='title'>졸업일자</td>
			<td id='cont'><%=stu.getSchool_dt() %></td>
			<td>&nbsp;</td>
		</tr>
		<tr align='center'>
			<td rowspan='3'  id='title'>연<br>락<br>처</td>
		</tr>
		<tr align='center'>
			<td id='title'>우편번호</td>
			<td id='cont'><%=dto.getZip() %></td>
			<td id='title'>주소</td>
			<td colspan='2' id='cont'><%=dto.getAddr() %></td>
			<td>&nbsp;</td>
			<td>&nbsp;</td>
		</tr>
		<tr align='center'>
			<td id='title'>전화번호</td>
			<td id='cont'><%=dto.getPhone() %></td>
			<td id='title'>휴대폰</td>
			<td id='cont'><%=dto.getM_phone()%></td>
			<td id='title'>E-MAIL</td>
			<td colspan='2' id='cont'><%=dto.getE_mail() %></td>
		</tr>
		<tr align='center'>
			<td rowspan='2' id='title'>본<br>인</td>
		</tr>
		<tr align='center'>		
			<td id='title'>영문명</td>
			<td id='cont'><%=stu.getEng_nm() %></td>
			<td id='title'>직장명</td>
			<td id='cont'>
			<%if(stu.getEntr_nm()==null){
				%>
				&nbsp;
				<%
				}else{
				%>
				<%=stu.getEntr_nm() %>
				<%
				}
				%>
			</td>
			<td id='title'>직장연락처</td>
			<td id='cont'><%if(stu.getEntr_phone()==null){
				%>
				&nbsp;
				<%
				}else{
				%>
				<%=stu.getEntr_phone() %>
				<%
				}
				%>
			</td>
			<td>&nbsp;</td>
		</tr>
	</table>
</div>
<div style="display:none" id="div2">
	<table border='1' cellpadding="0" cellspacing="0" width='85%'>
		 <col width='25'>
		 <col width='80'>
		 <col width='120'>
		 <col width='150'>
		 <col width='150'>
		 <col width='150'>
		 <col width='300'>
		<tr align='center' id='listTitle'>	
			<td>&nbsp;</td>	
			<td>관계</td>
			<td>성명</td>
			<td>직업</td>
			<td>연락처</td>
			<td>우편번호</td>
			<td>주소</td>
		</tr>
		<tr align='center'>
			<td>&nbsp;</td>	
			<td id='cont'><%=pro.getProtec_rel() %></td>
			<td id='cont'><%=pro.getProtec_nm() %></td>
			<td id='cont'><%=pro.getProtec_job() %></td>
			<td id='cont'><%=pro.getProtec_phone() %></td>
			<td id='cont'><%=pro.getProtec_zip() %></td>
			<td id='cont'>&nbsp;<%=pro.getProtec_addr()%></td>
		</tr>
	</table>
</div>
<div style="display:none" id="div3" >
	<table border='1' cellpadding="0" cellspacing="0" width='85%'>
		
		<tr align='center' id='listTitle' >	
			<td>&nbsp;</td>	
			<td>변동년도</td>
			<td>변동학기</td>
			<td>변동일자</td>
			<td>변동대구분</td>
			<td>변동중구분</td>
			<td>변동소구분</td>
			<td>학년(복학/재입학)</td>
			<td>교과적용년도</td>
		</tr>
		<tr align='center' height='25'> <td colspan='9'><font color=#EB000000 size='2'>학적 변동 내역이 없습니다.</font></td></tr>
	</table>
</div>

<!-- <div style='display:none' id="div4">	 -->
<!-- 		<table border='1' width='1100'> -->
<!-- 		<tr align='center' height='150'> -->
<!-- 			<td> -->
<!-- 				<table border='1'> -->
<!-- 				 <col width='50'> -->
<!-- 				 <col width='150'> -->
<!-- 				 <col width='50'> -->
<!-- 				 <col width='150'> -->
<!-- 				 <col width='50'> -->
<!-- 				 <col width='150'> -->
<!-- 				 <col width='50'> -->
<!-- 				 <col width='150'>				 -->
<!-- 					<tr align='center'> -->
<!-- 						<td><font color='red'>병역구분</font></td> -->
<!-- 						<td><select size='1'> -->
<!-- 							<option value='선택'>선택</option> -->
<!-- 							<option value='미필'>미필</option> -->
<!-- 							<option value='현역필'>현역필</option> -->
<!-- 							<option value='방위필(공익포함)'>방위필(공익포함)</option> -->
<!-- 							<option value='면제(병역특례포함)'>면제(병역특례포함)</option> -->
<!-- 							<option value='직업군인'>직업군인</option> -->
<!-- 							<option value='단기사병'>단기사병</option> -->
<!-- 						</select></td> -->
<!-- 						<td>군별</td> -->
<!-- 						<td><select size='1'> -->
<!-- 							<option value='선택'>선택</option> -->
<!-- 							<option value='육군'>육군</option> -->
<!-- 							<option value='해군'>해군</option> -->
<!-- 							<option value='공군'>공군</option> -->
<!-- 						</select></td> -->
<!-- 						<td>계급</td> -->
<!-- 						<td><select size='1'> -->
<!-- 							<option value='선택'>선택</option> -->
<!-- 							<option value='이병'>이병</option> -->
<!-- 							<option value='일병'>일병</option> -->
<!-- 							<option value='상병'>상병</option> -->
<!-- 							<option value='병장'>병장</option> -->
<!-- 							<option value='하사'>하사</option> -->
<!-- 						</select></td> -->
<!-- 						<td>병과</td> -->
<!-- 						<td><input type='text' name='' value=''></td> -->
<!-- 						<td>전역일자</td> -->
<!-- 						<td><input type='text' name='' value=''></td> -->
<!-- 					</tr> -->
<!-- 				</table> -->
<!-- 			</td> -->
<!-- 		</tr>	     -->
<!-- 	</table> -->
<!-- </div> -->

<div style='display:none' id="div4">	
<table border='1' cellpadding="0" cellspacing="0" width='85%'>
		 <col width='20'>
		 <col width='50'>
		 <col width='50'>
		 <col width='70'>
		 <col width='170'>
		 <col width='50'>
		 <col width='100'>
		 <col width='80'>
		 <col width='50'>
		 <col width='250'>
		 <col width='100'>
		 <col width='80'>
		<tr align='center' id='listTitle'>	
			<td>&nbsp;</td>	
			<td>학년도</td>
			<td>학기</td>
			<td>학수번호</td>
			<td>과목명</td>
			<td>강좌</td>
			<td>이수구분</td>
			<td>주야구분</td>
			<td>학점</td>
			<td>요일교시(강의실)</td>
			<td>담당교수</td>
			<td>수강구분</td>
		</tr>
<%
	if(sulist==null || sulist.size()==0)
	{
%>
		<tr align='center' height='25'> <td colspan='12'><font color=#EB000000 size='2'>수강 내역이 없습니다.</font></td></tr>
<%
	}else{
		for(StudentDto sd:sulist){
			
			
%>
		<tr align='center'>
			<td id='cont'><%=i++%></td>
			<td id='cont'><%=sd.getYear() %></td>
			<td id='cont'><%=sd.getSmt() %></td>
			<td id='cont'><%=sd.getCuri_num() %></td>
			<td id='cont'><%=sd.getCuri_nm() %></td>
			<td id='cont'><%=sd.getCuri_class() %></td>
			<td id='cont'><%=sd.getCont_desc() %></td>
			<td id='cont'><%=sd.getClass_div() %>
			<td id='cont'><%=sd.getCdt_num() %></td>
			<td id='cont'><%=sd.getRoom_time() %></td>
			<td id='cont'><%=sd.getPro_nm()%></td>
			<td id='cont'><%=sd.getRecourse_div() %>
		</tr>
<%
		}
	}
%>
	</table>
</div>
<!--박현수부분
성적계산
 -->
<div style='display:none' id="div5">	
<table border='1' cellpadding="0" cellspacing="0" width='85%'>
		 <col width='20'>
		 <col width='100'>
		 <col width='100'>
		 <col width='100'>
		 <col width='100'>
		 <col width='100'>
		 <col width='100'>
		 <col width='100'>
		<tr align='center' id='listTitle'>	
			<td>&nbsp;</td>	
			<td>학년도</td>
			<td>학기</td>
			<td>학년</td>
			<td>신청학점</td>
			<td>이수학점</td>
			<td>총점</td>
			<td>평점</td>
		</tr>
<!--성적출력 -->
<%
i=1; //행번호초기화
double temp=0.0;//총점계산 임시변수
int applyCdt_num=0;//신청학점
int isuCdt_num=0;//이수학점
double allGrade=0;//총점
String yearDiv=gList.get(0).getYear();//학생 년도
String smtDiv=gList.get(0).getSmt();//1학기
String smt=null;//학기표시변수
String year=null;//년도표시변수
int student_year=0;//학년표시변수
for(GradeDto Gdto: gList){
	if(smtDiv.hashCode()==Gdto.getSmt().hashCode() && yearDiv.hashCode()==Gdto.getYear().hashCode()){//학기,년도,학년 표시부분
		smt=Gdto.getSmt();//학기표시
		year=Gdto.getYear();//년도표시
		student_year=Gdto.getStudent_year();//학년표시
		if(smtDiv.hashCode()!=Gdto.getSmt().hashCode() || yearDiv.hashCode()!=Gdto.getYear().hashCode()){
			applyCdt_num+=Gdto.getCdt_num();//신청학점계산
		}
		if(Gdto.getGrade_avg()!=0.0 && Gdto.getSudelete_mark()==null){//이수학점계산
			isuCdt_num+=Gdto.getCdt_num();//이수학점계산
			temp = Gdto.getGrade_avg()* (double) Gdto.getCdt_num();
			allGrade += temp;//총점계산
		}//if
	}//if
	if(smtDiv.hashCode()!=Gdto.getSmt().hashCode() || yearDiv.hashCode()!=Gdto.getYear().hashCode()){
	%>
		<tr align='center'>
			<td id='cont'><%=i++ %></td>
			<td id='cont'><%=year %></td>
			<td id='cont'><%=smt %></td>
			<td id='cont'><%=student_year %></td>
			<td id='cont'><%=applyCdt_num %></td>
			<td id='cont'><%=isuCdt_num %></td>
			<td id='cont'><%=allGrade %></td>
			<td id='cont'><%=Double.parseDouble(String.format("%.2f", allGrade/ isuCdt_num)) %></td>
		</tr>
	<%
	smtDiv=Gdto.getSmt();//학기바꿈
	yearDiv=Gdto.getYear();//년도바꿈
	temp=0.0;
	applyCdt_num=0;
	allGrade=0.0;
	isuCdt_num=0;
}//if
	applyCdt_num+=Gdto.getCdt_num();
	if(Gdto.getGrade_avg()!=0.0  && Gdto.getSudelete_mark()==null){ //중간취득학점누적
		isuCdt_num+=Gdto.getCdt_num();
		temp=Gdto.getGrade_avg()* (double) Gdto.getCdt_num();
		allGrade+=temp;
	}
	}//for
 %>
<tr align='center'>	
			<td id='cont'><%=i++ %></td>	
			<td id='cont'><%=year %></td>
			<td id='cont'><%=smt %></td>
			<td id='cont'><%=student_year %></td>
			<td id='cont'><%=applyCdt_num %></td>
			<td id='cont'><%=isuCdt_num %></td>
			<td id='cont'><%=allGrade %></td>
			<td id='cont'><%=Double.parseDouble(String.format("%.2f", allGrade/ isuCdt_num)) %></td>
		</tr>
		
			</table>
		</div>
		</td>
	</tr>
</table>
</td>
</tr>
</table>
<!-- <div style='display:none' id="div7">	 -->
<!-- <table border='1'> -->
<!-- 		 <col width='100'> -->
<!-- 		 <col width='100'> -->
<!-- 		 <col width='100'> -->
<!-- 		 <col width='100'> -->
<!-- 		 <col width='100'> -->
<!-- 		 <col width='100'> -->
<!-- 		 <col width='100'> -->
<!-- 		 <col width='250'> -->
<!-- 		<tr align='center'>	 -->
<!-- 			<td>회사명</td> -->
<!-- 			<td>부서명</td> -->
<!-- 			<td>직위</td> -->
<!-- 			<td>입사일</td> -->
<!-- 			<td>퇴사일</td> -->
<!-- 			<td>전화번호</td> -->
<!-- 			<td>위치</td> -->
<!-- 			<td>비고</td> -->
<!-- 		</tr> -->
<!-- 	</table> -->
<!-- </div> -->
</center>
<br><br>
</body>
</html>