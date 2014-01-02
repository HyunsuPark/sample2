<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@page import="com.OMC.dtos.student.StudentDto"%>
<%@page import="com.OMC.daos.StudentManager"%>
<%@page import="com.OMC.daos.OMCManager"%>
<%@page import="java.util.List"%>
<% request.setCharacterEncoding("utf-8"); %>
<html>
<head>
<title>자기정보수정</title>
<link rel="stylesheet" href="./css/omc.css" type="text/css">
</head>
<body>
<%
	Object oDto = request.getAttribute("stup");
	Object oStu = request.getAttribute("stup2"); 
	
	StudentDto dto = new StudentDto();
	dto = (StudentDto) oDto;
	
	StudentDto stu = new StudentDto();
	stu = (StudentDto) oStu;
	
	String bankCode=dto.getRef_bank_cd();
	List<StudentDto> bklist = (List<StudentDto>)request.getAttribute("bklist");
	
	
	
	String sel = "";
%>


<br>
<table border='0' width='85%' cellpadding="0" cellspacing="0">
	<tr height='15'>
		<td align="center"><h4>학 적 | 자기정보수정</h4>
<form action="./studentControl.jsp" method="get">
<input type="hidden" name ="command" value='update'/>
<input type="hidden" name ="student_cd" value='<%=dto.getStudent_cd()%>'/>
<table border='1' width='85%' cellpadding="0" cellspacing="0">
	<tr>
		<td id='listTitle' colspan="2">
			<b>검색조건</b>
		</td>
	</tr>
	<tr>
		<td>
			<table border='0' width='100%' cellpadding="0" cellspacing="0">
				<col width='100'>
				<col width='150'>
				<col width='100'>
				<col width='150'>
				<tr align='center'>
					<td id=title><font size='2'>학 번</font></td>
					<td id='cont'> <%=dto.getStudent_cd() %> </td>
					<td id=title><font size='2'>성 명</font></td>
					<td id='cont'> <%=dto.getKor_nm() %> </td>
<!-- 					<td><input type=button value='검색'></td> -->
				</tr>
			</table>
		</td>
		<td><input type='submit' value='수정'></td>
	</tr>	
</table>
<p></p>
<!-- <table border='1'> -->
<!-- 	<tr> -->
<!-- 		<td> -->
<!-- 			<b>Data</b> -->
<!-- 		</td> -->
<!-- 		<td>* 주소 변경시 검색 아이콘을 눌러 우편번호를 검색하여 현주소를 변경한 다음 상세주소를 입력하세요.</td> -->
<!-- 	</tr> -->
<!-- </table> -->

<table border='1' width='85%' cellpadding="0" cellspacing="0">
	<tr>
		<td>
			<table border='1'  width="100%" cellpadding="0" cellspacing="0">
			 <col width='100'>
			 <col width='150'>
			 <col width='100'>
			 <col width='150'>
			 <col width='100'>
			 <col width='150'>
				<tr align='center'>
					<td id=title>학번</td>
					<td id='cont'><%=dto.getStudent_cd() %></td>
					<td id=title>성명</td>
					<td id='cont'><%=dto.getKor_nm() %></td>
					<td id=title>주민등록번호</td>
					<td colspan='3' id='cont'><%=dto.getSsn() %></td>
				</tr>
				<tr align='center'>
					<td id=title>우편번호</td>
					<td id='cont'><%=dto.getZip() %></td>
					<td id=title>주소</td>
					<td colspan='5' id='cont'><%=dto.getAddr() %></td>
				</tr>
				<tr align='center'>
					<td id=title>학과</td>
					<td id='cont'><%=dto.olg_dept_nm %></td>
					<td id=title>전공</td>
					<td id='cont'><%if(dto.getOlg_major_nm()==null){
				%>
				&nbsp;
				<%
				}else{
				%>
				<%=dto.getOlg_major_nm()%>
				<%
				}
				%></td>
					<td id=title>학년-반-번호</td>
					<td colspan='3' id='cont'><%=dto.getStudent_num() %></td>
				</tr>
				<tr align='center'>
					<td id=title>주야구분</td>
					<td id='cont'><%=dto.getClass_div() %></td>
					<td id=title>학적상태</td>
					<td id='cont'><%=dto.getSchool_chk() %></td>
					<td colspan='4'>&nbsp;</td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td colspan='6'>&nbsp;</td>
	</tr>	
	<tr>
		<td>
			<table border='1' width="100%" cellpadding="0" cellspacing="0">
			 <col width='100'>
			 <col width='150'>
			 <col width='100'>
			 <col width='150'>
			 <col width='100'>
			 <col width='150'>
				<tr align='center'>
					<td id=title><font color='red'>영문성명</font></td>
					<td><input type='text' name='engNM' id='contInput' value='<%=stu.getEng_nm()%>'></td>
					<td id=title>휴대폰</td>
					<td><input type='text' name='mPhone'  id='contInput' value='<%=dto.getM_phone()%>'></td>
					<td id=title>전화번호</td>
					<td><input type='text' name='phone' id='contInput' value='<%=dto.getPhone()%>' ></td>
				</tr>
				<tr align='center'>
					<td id=title>E-Mail</td>
					<td colspan='3'><input type='text' id='contInput' name='email' size='60' value='<%=dto.getE_mail()%>'></td>
					<td colspan='2'>&nbsp;</td>
				</tr>
				<tr>
					<td colspan='6'>&nbsp;</td>
				</tr>
				<tr align='center'>
					<td id=title>우편번호</td>
					<td><input type='text' name='zip' id='contInput' value='<%=dto.getZip()%>' readonly="readonly"></td>
					<td id=title>현주소</td>
					<td colspan='3'><input type='text' name='addr1' id='contInput' value='<%=dto.getReal_addr1()%>' size='55'></td>
				</tr>
				<tr align='center'>
					<td id=title>상세주소</td>
					<td colspan='5'><input type='text' name='addr2' id='contInput' value='<%=dto.getReal_addr2()%>' size='100'></td>
				</tr>
				<tr>
					<td colspan='6'>&nbsp;</td>
				</tr>
				<tr align='center'>
					<td id=title>은행명</td>
					<td>
					<select id='contSelect' name='bank' size='1'>
					<%
						for(StudentDto bk : bklist){
							
// 						if(dto.getBank().equals(bk.getBankn()))
// 						{
// 							sel = "Selected";
// 							System.out.println(sel);
// 						}
					if(bk.getRef_bank_cd().equals(bankCode)){
						
					%>
						
						<option value='<%=bk.getRef_bank_cd()%>' selected="selected"><%=bk.getBankn()%></option>
					<%
						}else{
							%>
							<option value='<%=bk.getRef_bank_cd()%>'><%=bk.getBankn()%></option>
							<%
						}
					}
					%>
						</select>
					</td>
					<td id=title>예금주</td>
					<td><input type='text' name='bnNM' id='contInput' value='<%if(dto.getRef_depo_nm()==null){
					%>
					&nbsp;
					<%
					}else{
					%>
					<%=dto.getRef_depo_nm()%>
					<%
					}
					%>'></td>
					<td id=title>계좌번호</td>
					<td><input type='text' name='bnNUM' id='contInput' value='<%if(dto.getRef_acct_num()==null){
					%>
					&nbsp;
					<%
					}else{
					%>
					<%=dto.getRef_acct_num()%>
					<%
					}
					%>'></td>
				</tr>
			</table>
		</td>	
		</tr>
	</table>
	</form>
		</td>
	</tr>
</table>
</body>
</html>