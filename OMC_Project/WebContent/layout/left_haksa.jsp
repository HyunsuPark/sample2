<%@page import="com.OMC.dtos.LoginUserDto"%>
<%@ page language="java" contentType="text/html; charset=utf-8" %>
<% request.setCharacterEncoding("utf-8"); %>
<% response.setContentType("text/html; charset=utf-8");%>
<head>

<link rel="stylesheet" type="text/css" href="./css/omc.css">

<script type="text/javascript">
function time(num){
	if (num=="time1") {
		location.href='./menu_control.jsp?command=timetable1';
	}else if (num=="time2") {
		location.href='./menu_control.jsp?command=timetable2';
	}else if (num=="time3") {
		location.href='./menu_control.jsp?command=timetable3';
	}
}

</script>
</head>
 <% Object obj = session.getAttribute("login"); 
LoginUserDto login = (LoginUserDto)obj;
if(login == null){
	response.sendRedirect("index.jsp");
}
%>
 
<table class="ex1" width="200" border='0'>
	<tr>
		<td>		
			<table width="100%" cellspacing='0' cellpadding='0' border="0">
		<tr>
			<td width="70%">
				<table width="100%" cellspacing='0' cellpadding='0' border="1" >
					<tr align="center">				
						<td><%=login.getKor_nm() %></td>
					</tr>
					<tr align="center">				
						<td><%=login.getStudent_cd() %></td>
					</tr>
				</table>
			</td>
			<td width="30%"><a href="./menu_control.jsp?command=logout"><img src='./images/button/btn_logout.gif' border='0'></a></td>
		</tr>
		</table>
		<br>	
		</td>
	</tr>
	<tr>
		<td>
			<table border='0' width="100%" cellspacing='0' cellpadding="0">			
				<tr>
					<td id='menuB'>● 등록</td>
				</tr>
				<tr>
					<td id='menuS'><a herf="">고지서출력(학생용)</a></td>
				</tr>
				<tr>
					<td id='menuS'><a>교육비 납입 증명서</a></td>
				</tr>
			</table>
		</td>
	</tr>
	<tr height='5'><td>&nbsp;</td></tr>
	<tr>
		<td>
			<table border='0' width="100%" cellspacing='0' cellpadding="0">
				<tr>
					<td id='menuB'>● 성적</td>
				</tr>
				<tr>
					<td id='menuS'><a href="./menu_control.jsp?command=thisgrade">금학기성적조회</a></td>
				</tr>
				<tr>
					<td id='menuS'><a href="./gradeControl.jsp?command=allgrade">전체학기 성적조회</a></td>
				</tr>
			</table>
		</td>
	</tr>
	<tr height='5'><td>&nbsp;</td></tr>
	<tr>
		<td>		
			<table border='0' width="100%" cellspacing='0' cellpadding="0">
				<tr>
					<td id='menuB'>● 강의시간표</td>
				</tr>
				<tr>
					<td id='menuS'>
						<select id='menu' name="timetable" onchange="time(this.value)">
							<option>조회 선택
							<option value="time1">학년반별시간표조회
							<option value="time2">강의실별시간표조회
							<option value="time3">교수별시간표조회
						</select>
					</td>
				</tr>		
				<tr>
					<td id='menuS'><a href="./menu_control.jsp?command=lecsearch">강의계획서조회</a></td>
				</tr>
				<tr>
					<td id='menuS'><a href="./menu_control.jsp?command=leccommit">강의평가등록</a></td>
				</tr>
			</table>		
		</td>
	</tr>
	<tr height='5'><td>&nbsp;</td></tr>
	<tr>
		<td>
		<table border='0' width="100%" cellspacing='0' cellpadding="0">
			<tr>
				<td id='menuB'>● 학생</td>
			</tr>
			<tr>
				<td id='menuS'><a href="./studentControl.jsp?command=stsearch">학생정보조회</a></td>
			</tr>
			<tr>
				<td id='menuS'><a href="./studentControl.jsp?command=stupdate">자기정보수정</a></td>
			</tr>
		</table>
	</td>
	</tr>
</table>
<!-- [학사정보]
등록
   - 고지서출력(학생용)
   - 교육비 납입 증명서
성적
  - 금학기성적조회
  - 전체학기 성적조회
수업
  - 강의실별시간표조회
  - 교수별시간표조회
  - 학년반별시간표조회
  - 강의시간표
  - 강의계획서조회
  - 강의평가등록
학생
  - 학생정보조회
  - 자기정보수정
  - 복학신청 -->