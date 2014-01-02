<%@page import="com.OMC.dtos.grade.GradeSumDto"%>
<%@page import="java.util.List"%>
<%@page import="com.OMC.dtos.grade.GradeDto"%>
<%@page import="com.OMC.dtos.LoginUserDto"%>
<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
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
	<%!public String isNull(String s) {
		if (s == null) {
			s = "&nbsp";
			return s;
		} else {
			return s;
		}
	}
%>
	<%
		int i = 1;
		int cnt = 1;
		int applySum = 0;
		int getSum = 0;
		int gyoyang = 0;//취득교양학점
		int jungong = 0;//취득전공학점
		int junggyo=0; //전공교양
		int pf=0;//pf과목
		double getGradeSum = 0.0;
		int student_period=0;
		String smt = (String) request.getAttribute("smt");
		List<GradeDto> ob = (List<GradeDto>)request.getAttribute("lists");
// 		Object sumob = request.getAttribute("sumlists");
		String year = (String)request.getAttribute("year");
		Object obj = session.getAttribute("login");
		LoginUserDto login = (LoginUserDto) obj;
		String student_cd = login.getStudent_cd();
		String student_nm = login.getKor_nm();
	%>
<br>
<table width="85%" boder="0">
	<tr>
		<td>

<table border='0' width='100%' cellpadding="0" cellspacing="0">
	<tr height='15'>
		<td align="center"><h4>성 적 | 전체학기성적조회</h4></td>
		<td align="right"><button onclick="javascript:window.print();">인쇄</button></td>
	</tr>
</table>
	<form action='./gradeControl.jsp' method="post">	
	<center>
		<table border='1' width='55%' cellpadding="0" cellspacing="0">
			<col width='80'>
			<col width='100'>
			<col width='80'>
			<col width='100'>
			<col width='50'>
			<tr>
				<td id='listTitle' colspan='5'><input type="hidden" name="command" value="allgrade">검색조건</td>
			</tr>
			<%
				if (ob.isEmpty()) {
			%>

			<tr align='center'>
				<td id='title'>학 번	</td>
				<td><input type='text' name='student_cd' id='contInput' value='<%=student_cd%>' readonly="readonly" /></td>
				<td id='title'>성 명</td>
				<td><input type='text' name='st_kor_nm' id='contInput' value='<%=student_nm%>' readonly="readonly"></td>
				<td><input type=submit value='검색'></td>
			</tr>
			<%
				} else {
			%>

			<tr align='center'>
				<td id='title'>학 번	</td>
				<td><input type='text' name='student_cd' id='contInput' value='<%=student_cd%>' readonly="readonly" onclick="noWrite()"/>
				</td>
				<td id='title'>성 명	</td>
				<td><input type='text' name='st_kor_nm' id='contInput' value='<%=student_nm%>' readonly="readonly" onclick="noWrite()"></td>
				<td><input type=submit value='검색'></td>
			</tr>

			<%
				}
			%>
		</table>
	</center>
	</form>
	<!-- 전체성적정보 -->
	<%
		if (ob == null) {
	%>
	<table border='0' width="100%" cellpadding="0" cellspacing="0">
		<tr>
			<td colspan="2" id='listTitle' >전체성적정보</td>
		</tr>
		<tr>
			<td width="60%" rowspan="2">
				<table border='1' width="100%" cellpadding="0" cellspacing="0">
					<col width='100'>
					<col width='150'>
					<col width='100'>
					<col width='150'>
					<col width='100'>
					<col width='150'>
					<col width='100'>
					<col width='150'>
					<tr align='center'>
						<td id='title'>신청학점</td>
						<td id='cont'>0</td>
						<td id='title'>취득학점</td>
						<td id='cont'>0</td>
						<td id='title'>총평점</td>
						<td id='cont'>0</td>
						<td id='title'>평균평점</td>
						<td id='cont'>0</td>
						<td><input type=button value='검색'></td>
					</tr>
				</table> 
				</td>
				<%
 	} else {
 		double temp = 0;
 		for (GradeDto getApplySum : (List<GradeDto>) ob) {
 			temp = getApplySum.getGrade_avg()
 					* (double) getApplySum.getCdt_num();
 			getGradeSum += temp;
 			applySum += getApplySum.getCdt_num();
 			if (getApplySum.getGrade_avg() != 0.0 || getApplySum.getSudelete_mark()==null) {//취득학점계산
 				getSum += getApplySum.getCdt_num();
 			}
 			if(getApplySum.getSudelete_mark()==null ){
 			if ((getApplySum.getComdiv_cd().substring(0, 2).equals("교양")&&getApplySum.getGrade_avg() != 0.0  ||getApplySum.getComdiv_cd().substring(0, 2).equals("기타")) ) {//교양학점계산
 				gyoyang += getApplySum.getCdt_num();
 			}
 			
 			if (!getApplySum.getComdiv_cd().equals("전공교양") && getApplySum.getComdiv_cd().substring(0, 2).equals("전공")&& getApplySum.getGrade_avg() != 0.0 ) {//전공학점계산
 				jungong += getApplySum.getCdt_num();
 			}
 			}
 			cnt++;
 			student_period=getApplySum.getStudent_period();
 			if (getApplySum.getComdiv_cd().equals("전공교양")){
 				junggyo+=getApplySum.getCdt_num();
 			}
 			if(getApplySum.getComdiv_cd().equals("p/f")){
 				pf+=getApplySum.getCdt_num();
 			}
 		}
 %>
				<table border='1' width="100%" cellpadding="0" cellspacing="0">
					<tr>
						<td id='listTitle' colspan="5">전체성적정보</td>
					</tr>
					<tr>
						<td width="60%" rowspan="2">
							<table border='1' width="100%" cellspacing="0" cellpadding="0" >
								<col width='100'>
								<col width='50'>
								<col width='100'>
								<col width='50'>
								<col width='100'>
								<col width='100'>
								<col width='100'>
								<col width='80'>
								<tr align='center'>
									<td id='title'>신청학점	</td>
									<td id='cont'><%=applySum%></td>
									<td id='title'>취득학점</td>
									<td id='cont'><%=getSum%></td>
									<td id='title'>총평점</td>
									<td id='cont'><%=getGradeSum%></td>
									<td id='title'>평균평점</td>
									<td id='cont'><%=Double.parseDouble(String.format("%.2f", getGradeSum/ getSum))%></td>
								</tr>
							</table> <%
 	}
 %>
						</td>
						<td width="40%">
							<table border='1' width="100%" cellpadding="0" cellspacing="0">
								<col width='100'>
								<col width='100'>
								<col width='100'>
								<col width='100'>
								<col width='100'>
								<tr>
									<td colspan='4' align="center" id='title' height='25'>졸업기준대비 이수현황</td>
								</tr>
								<tr align='center'  height='20'>
									<td id='title'>이수구분</td>
									<td id='title'>졸업기준</td>
									<td id='title'>이수학점</td>
									<td id='title'>잔여학점</td>
								</tr>
								<tr align='center'> 
									<td id='title'>교양</td>
									<%if(Integer.parseInt(year)>=2010){%>
									<td id='cont'>5</td>
									<%}else{ %>
									<td id='cont'>10</td>
									<%}%>
									<td id='cont'><%=gyoyang%></td>
									<%if(Integer.parseInt(year)>=2010){
									%>
									<td id='cont'><%=15 - gyoyang%></td>
									<%}else{ %>
									<td id='cont'><%=10 - gyoyang%></td>
									<%} %>
								</tr>
								<tr align='center'>
									<td id='title'>전공</td>
									<%if(Integer.parseInt(year)>=2010){%>
									<td id='cont'>54</td>
									<%}else{ %>
									<td id='cont'>64</td>
									<%} %>
									<td id='cont'><%=jungong%></td>
									<%if(Integer.parseInt(year)>=2010){
									%>
									<td id='cont'><%=54 - jungong%></td>
									<%}else{ %>
									<td id='cont'><%=64 - jungong%></td>
									<%} %>
								</tr>
							</table>
							</td>
						</tr>
						<tr>
							<td>
							<table width="100%" border="1" cellpadding="0" cellspacing="0">
							<tr align="center" height='20'>
								<td id='title'>졸업학점</td>
								<td id='title'>취득학점</td>
								<td id='title'>전공교양</td>
								<td id='title'>p/f필수</td>
							</tr>
							<%if(student_period==03){ %>
							<tr align="center">
								<td id='cont'>120</td>
								<td id='cont'><%=getSum %></td>
								<td id='cont'><%=junggyo%></td>	
								<td id='cont'><%=pf%></td>
							</tr>
							<%}else if(student_period==02){ %>
							<tr align="center">
								<td id='cont'>80</td>
								<td id='cont'><%=getSum %></td>
								<td id='cont'><%=junggyo%></td>
								<td id='cont'><%=pf%></td>
							</tr>
							<%}else{ %>
							<tr align="center">
								<td id='cont'>etc</td>
								<td id='cont'><%=getSum %></td>
								<td id='cont'><%=junggyo%></td>
								<td id='cont'><%=pf%></td>
							</tr>
							<%} %>
						</table>
					</td>
				</tr>
			</table>				



<!--  -->
<table class=ex1 width='100%'>
	<tr class=head>
		<td>&nbsp;</td>
		<td>학년도</td>
		<td>학기</td>
		<td>학수번호</td>
		<td>과목명</td>
		<td>강좌번호</td>
		<td>학년</td>
		<td>반</td>
		<td>이수구분</td>
		<td>학점</td>
		<td>등급</td>
		<td>평점</td>
		<td>평점계</td>
		<td>재수강년도</td>
		<td>재수강학기</td>
		<td>삭제구분</td>
	</tr>
<%
	if (ob == null) {
%>
<tr align='center'>
	<td colspan="15">성적이 조회되지 않았습니다</td>
</tr>
<%
	} else {
		applySum=0; //신청학점중간초기화
		getSum=0;//취득학점중간초기화
		getGradeSum=0.0;
		double temp=0.0;
		for (GradeDto dto : ob) {
			if (dto.getSmt().hashCode() != smt.hashCode()|| dto.getYear().hashCode()!=year.hashCode()) {//중간합계출력
				smt = dto.getSmt();
				year=dto.getYear();
%>
<tr bgcolor="gold" align="center">
	<td colspan="2">신청학점</td>
	<td><%=applySum%></td>
	<td colspan="2">취득학점</td>
	<td><%=getSum%></td>
	<td colspan="3">총평점</td>
	<td><%=getGradeSum%></td>
	<td colspan="3">평균평점</td>
	<td colspan="3"><%=Double.parseDouble(String.format("%.2f",	getGradeSum / getSum))%></td>
</tr>
<%
applySum=0; //신청학점중간초기화
getSum=0;//취득학점중간초기화
temp=0.0;//임시총평점변수 초기화
getGradeSum=0;//총평점초기화

	}//중간합계끝
	applySum+=dto.getCdt_num(); //중간신청합계누적
	if(dto.getGrade_avg()!=0.0  && dto.getSudelete_mark()==null){ //중간취득학점누적
		getSum+=dto.getCdt_num();
		temp=dto.getGrade_avg()* (double) dto.getCdt_num();
		getGradeSum+=temp;
	}
	
%>
<tr class=grade>
	<td><%=i++%></td>
	<td><%=dto.getYear()%></td>
	<td><%=dto.getSmt()%></td>
	<td><%=dto.getCuri_num()%></td>
	<td><%=dto.getCuri_nm()%></td>
	<td><%=dto.getCuri_class()%></td>
	<td><%=dto.getStudent_year()%></td>
	<td><%=dto.getStudent_class()%></td>
	<td><%=dto.getComdiv_cd()%></td>
	<td><%=dto.getCdt_num()%></td>
	<td><%=dto.getGrade()%></td>
	<td><%=dto.getGrade_avg()%></td>
	<td><%=dto.getGrade_avg() * dto.getCdt_num()%></td>
	<td><%=isNull(dto.getRecourse_year())%></td>
	<td><%=isNull(dto.getRecourse_smt())%></td>
	<td><%=isNull(dto.getSudelete_mark())%></td>
</tr>
<%
	}//for
		}//else
%>
<tr bgcolor="gold" align="center">
		<td colspan="2">신청학점</td>
		<td><%=applySum%></td>
	<td colspan="2">취득학점</td>
	<td><%=getSum%></td>
	<td colspan="3">총평점</td>
	<td><%=getGradeSum%></td>
	<td colspan="3">평균평점</td>
	<td colspan="3"><%=Double.parseDouble(String.format("%.2f",
		getGradeSum / getSum))%></td>
</tr>
</table>
		</tr>
</table>

		</td>
	</tr>
</table>
<br>
</body>
</html>