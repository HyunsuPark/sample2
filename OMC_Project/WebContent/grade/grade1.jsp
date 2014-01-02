<%@page import="java.io.PrintWriter"%>
<%@page import="com.OMC.dtos.LoginUserDto"%>
<%@page import="com.OMC.dtos.grade.GradeSumDto"%>
<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@page import="java.util.Map"%>
<%@page import="com.OMC.daos.OMCManager"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.OMC.dtos.grade.GradeDto"%>
<% request.setCharacterEncoding("utf-8"); %>
<% response.setContentType("text/html; charset=utf-8");%>
<!-- 01 재수강 02 재입학 03 학기취소 04성적포기 -->
<html>
<head>
<title>성적조회</title>
<link rel="stylesheet" href="./css/omc.css" type="text/css">
<script type="text/javascript">
function noWrite(){
	alert("입력할수없습니다");
}
</script>
</head>
<body>
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
<%
int i=1;
int cnt=1;
int applySum=0;
int getSum=0;
double getGradeSum=0.0;
Object ob = request.getAttribute("lists");
// Object sumob=request.getAttribute("sumlists");
String year=request.getParameter("year");
String smt=request.getParameter("smt");
Object obj = session.getAttribute("login"); 
LoginUserDto login = (LoginUserDto)obj;
String student_cd=login.getStudent_cd();
String student_nm=login.getKor_nm();
%>
<br>
<table border='0' width='85%' cellpadding="0" cellspacing="0">
	<tr height='15'>
		<td align="center"><h4>성 적 | 금학기성적조회 </h4></td>
		<td align="right"><button onclick="javascript:window.print();">인쇄</button></td>
	</tr>
</table>
<form action='./gradeControl.jsp' method="post" name="form1">
<table class='bl' width="85%" cellpadding="0" cellspacing="0">
   <col width='150'>
   <col width='150'>
   <col width='150'>
   <col width='150'>
   <col width='100'>
   <col width='150'>
   <col width='100'>
   <col width='150'>
	<tr>
	 <td colspan='9' id='listTitle'><input type="hidden" name="command" value="thisgrade">검색조건</td>
	</tr>
	<%if(ob==null) {%>
	<tr align='center'>
	    <td id='title'>학년도</td>
	    <td><input type='text' name='year' id='contInput' value='<%=student_cd.substring(0,4) %>'></td>
	    <td id='title'>학기</td>
	    <td>
		    <select id='contSelect' name='smt' >
			    <option value="10">1학기</option>
			    <option value="11">여름학기</option>
			    <option value="20">2학기</option>
			    <option value="21">겨울학기</option>
		    </select>
	    </td>
	    <td id='title'>학 번</td>
	    <td><input type='text' name='student_cd' id='contInput' value='<%=student_cd %>' readonly="readonly" onclick="noWrite()"></td>
	    <td id='title'>성 명</td>
	    <td><input type='text' name='st_kor_nm' id='contInput' value='<%=student_nm %>' readonly="readonly" onclick="noWrite()"> </td>
	    <td><input type='submit' id="subm" value='검색'></td>
	</tr> 
	<%
	}else{
	%>
   <tr align='center'>
	    <td id='title'>학년도</td>
	    <td><input type='text' name='year' id='contInput'  value='<%=year %>'></td>
	    <td id='title'>학기</td>
	    <%if(smt.equals("10")){ %>
	    <td>
		    <select id='contSelect' name='smt' >
			    <option value="10" selected="selected">1학기</option>
			    <option value="11">여름학기</option>
			    <option value="20">2학기</option>
			    <option value="21">겨울학기</option>
		    </select>
	     </td>
	     <%}else if(smt.equals("11")){%>
	      <td>
		    <select id='contSelect' name='smt' >
			    <option value="10">1학기</option>
			    <option value="11" selected="selected">여름학기</option>
			    <option value="20">2학기</option>
			    <option value="21">겨울학기</option>
		    </select>
	     </td>
	     <%}else if(smt.equals("20")){%>
	     <td>
		    <select id='contSelect' name='smt' >
			    <option value="10">1학기</option>
			    <option value="11">여름학기</option>
			    <option value="20" selected="selected">2학기</option>
			    <option value="21">겨울학기</option>
		    </select>
	     </td>
	     <%}else if(smt.equals("21")){%>
	     <td>
		    <select id='contSelect' name='smt' >
			    <option value="10">1학기</option>
			    <option value="11">여름학기</option>
			    <option value="20">2학기</option>
			    <option value="21" selected="selected">겨울학기</option>
		    </select>
	     </td>
	     <%}%>
	     <td id='title'>학 번</td>
	     <td><input type='text' name='student_cd' id='contInput'  value='<%=student_cd %>' readonly="readonly" onclick="noWrite()"/></td>
	     <td id='title'>성 명</td>
	     <td><input type='text' name='st_kor_nm' id='contInput'  value='<%=student_nm %>' readonly="readonly" onclick="noWrite()"/> </td>
	     <td><input type='submit' id="subm" value='검색'></td>
	</tr> 
	<%} %>
</table>
</form>
<!-- 전체성적정보 -->
<%
if(ob==null){
	%>
	<table border='1' width="85%" cellpadding="0" cellspacing="0">
	<col width='100'>
    <col width='150'>
    <col width='100'>
    <col width='150'>
    <col width='100'>
    <col width='150'>
    <col width='100'>
    <col width='150'>
	<tr>
	 <td id='listTitle' colspan="8">전체성적정보</td>
	</tr>
	<tr align='center'>
	    <td id='title'>신청학점</td>
	    <td id='cont'>0</td>
	    <td id='title'>취득학점</td>
	    <td id='cont'>0</td>
	    <td id='title'>총평점</td>
	    <td id='cont'>0</td>
	    <td id='title'>평균평점</td>
	    <td id='cont'>0</td>
	</tr> 
	</table>
	 <%
}else{
double temp=0.0;
for(GradeDto getApplySum :(List<GradeDto>)ob){
	applySum+=getApplySum.getCdt_num();
	if(getApplySum.getSudelete_mark()==null && getApplySum.getGrade_avg()!=0.0){
		temp=getApplySum.getGrade_avg()*getApplySum.getCdt_num();
		getGradeSum+=temp;
		getSum+=getApplySum.getCdt_num();
	}
	cnt++;
}
%>
<table border='1' width="85%" cellpadding="0" cellspacing="0">
	<col width='100'>
    <col width='150'>
    <col width='100'>
    <col width='150'>
    <col width='100'>
    <col width='150'>
    <col width='100'>
    <col width='150'>
	<tr>
	 <td id='listTitle' colspan="8">전체성적정보</td>
	</tr>
	<tr align='center'>
	    <td id='title'>신청학점</td>
	    <td id='cont'><%=applySum %></td>
	    <td id='title'>취득학점</td>
	    <td id='cont'><%=getSum %></td>
	    <td id='title'>총평점</td>
	    <td id='cont'><%=getGradeSum %></td>
	    <td id='title'>평균평점</td>
	    <td id='cont'><%=Double.parseDouble(String.format("%.2f", getGradeSum/getSum)) %></td>
	</tr> 
</table>
<%} %>
<!-- 전체성적정보 -->
<table class=ex1 width="85%">
<tr>
 <td>&nbsp;</td>
</tr>
<tr>
 <td>
  <table class=ex1 width='100%'>
   <tr class=head>
    <td>&nbsp;</td>
    <td>학수번호</td>
    <td>과목명</td>
    <td>강좌번호</td>
    <td>학점</td>
    <td>시간</td>
    <td>담당교수</td>
    <td>등급</td>
    <td>평점계</td>
    <td>p/f</td>
    <td>재수강정보</td>
   </tr>
   <%
   if(ob==null || cnt==1){
	   %>
	   <tr align='center'>
   			<td colspan="11"><br><font color=#EB000000 size='2'>금학기 <b><%=student_nm %></b>학생 성적 Data가 없습니다.</font></td>
   		</tr>
   		<tr height='150'><td colspan="11"></td></tr>
	   <%
   }
   else{
	   for(GradeDto dto : (List<GradeDto>)ob){
   %>
   <tr class=grade>
	    <td id='cont'><%=i++ %></td>
	    <td id='cont'><%=dto.getCuri_num()%></td>
	    <td id='cont'><%=dto.getCuri_nm()%></td>
	    <td id='cont'><%=dto.getCuri_class()%></td>
	    <td id='cont'><%=dto.getCdt_num()%></td>
	    <td id='cont'><%=dto.getTime()%></td>
	    <td id='cont'><%=dto.getEmp_kor_nm()%></td>
	    <td id='cont'><%=dto.getGrade()%></td>
	   	<td id='cont'><%=dto.getGrade_avg()*dto.getCdt_num()%></td>
		<td id='cont'><%=isNull(dto.getPass_fail()) %></td>
		<td id='cont'><%=isNull(dto.getRecourse_div())%><br><%=isNull(dto.getSudelete_mark()) %></td>
   </tr>
   <%
	   }
      }
   %>
  </table>
 </td>
</tr> 
</table>
<br><br>
</body>
</html>