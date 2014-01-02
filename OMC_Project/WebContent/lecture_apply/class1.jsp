<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String apps=request.getContextPath();
%>
<%@page import="com.OMC.dtos.LoginUserDto"%>
<%@page import="com.OMC.dtos.lectureapply.CustUserDtos"%>
<%@page import="com.OMC.daos.ClassService"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<html>
<head>
<title>수강신청</title>
<link rel="stylesheet" href="./css/omc.css" type="text/css">
<script type="text/javascript" src="jquery-1.7.1.min.js"></script>
<script type="text/javascript">
var str="";
function shows(curi_num){
//alert('<%=apps%>');
//alert(curi_num);
// 	document.checkf.submit();

 var st1=document.getElementById("student_cd").value;
 var str = curi_num.value;
 var str2=str.substr(0,6);
// var a =new Array(2);
 //	a= str.split(",");
 
	$.ajax({
		type:"POST",
		url:"<%=apps%>/classesAjaxServlet",
		data:"st="+str2+"&st1="+st1,
		async:true,
		success:function(mm){
			leccheck(mm,curi_num);
		}
	});
}
	function leccheck(nodes,curi_num){
		if(nodes.lec_check.length > 0 && curi_num.checked==true){
			alert("재수강 과목입니다");
		
		}
	}
	
	function ask_go(){

		document.checkf.submit();
	}
	function del(){
		document.muldel.submit();
	}
</script>


</head>
<body>
<% 	
Object loginobj = session.getAttribute("login"); 
LoginUserDto login = (LoginUserDto)loginobj;
String student_cd=login.getStudent_cd();
	
	ClassService service=ClassService.getInstance();
	CustUserDtos dto=service.getCustUser(new CustUserDtos(student_cd));
	String dept_cd=dto.getDept_cd();
	System.out.println("학과");
	System.out.println(dept_cd);
	CustUserDtos deptinfo=service.getDeptInfo(dept_cd);
	System.out.println(deptinfo.getDept_nm());
	List<CustUserDtos> showleck=new ArrayList<CustUserDtos>();

	showleck=service.getShowLec(student_cd);

	String classdiv;
	Object obj=request.getAttribute("lists");
	List<CustUserDtos> lists= new ArrayList<CustUserDtos>();
	List<String> warn= new ArrayList<String>();
	
	if(obj!=null){
		
	 lists= (List<CustUserDtos>)obj;

	}
	String err=(String)request.getAttribute("errm");
	String er = (String)request.getAttribute("muldelerr");
	if(er!=null || err!=null ){
		out.println("<script> alert('하나이상을 선택하세요'); </script>");
	}

	List<String> noInsert = (List<String>)request.getAttribute("curi_nm");
	
	  int cnt = 1;
	 if(noInsert != null){
		  String curi_nm="";
	  for(String s : noInsert){
	   curi_nm += s;
	   if(cnt+1 > noInsert.size()){
	    
	   }else{
	     curi_nm += ",";
	   }
//	    out.println("<script> alert('"+ s +"'); </script>");
	  cnt++;
	  }if(curi_nm.length()>1){
	  out.println("<script> alert('"+ curi_nm +" 과목은 중복'); </script>");
	  }
	  else{
	  }
	 }else{
	  
	 }

%>
<br>
<table border='0' width='85%' cellpadding="0" cellspacing="0">
	<tr height='15'>
		<td align="center"><h4>수 강 | 수강신청 </h4></td>
	</tr>
</table>
	<table border='0' width='85%' cellpadding="0" cellspacing="0">
		<tr>
			<td id='listTitle'>검색조건</td>
		</tr>
		<tr>
			<td>
				<table border='1' width='100%' cellspacing="0" cellpadding="0">
					<col width='100'>
					<col width='150'>
					<col width='100'>
					<col width='150'>
					<col width='100'>
					<col width='150'>
					<col width='100'>
					<col width='150'>
					<tr align='center'>
						<td id='title'>학년도</td>
						<td id='cont'><%= dto.getStudent_cd().substring(0,4) %></td>						
						<td id='title'>학년</td>
						<td id='cont'><%=dto.getStudent_year()%></td>
						<td id='title'>학 번</td>
						<td id='cont'><%= dto.getStudent_cd() %></td>
						<td id='title'>성 명</td>
						<td id='cont'><%=dto.getStudent_nm() %></td>
						
					</tr>
				</table>
			</td>
		</tr>
	</table>
	
	<form action='./lec_control.jsp' method="get">
	<input type="hidden" name="command" value="getall">
	<table border='0' width='85%' cellpadding="0" cellspacing="0">
		<tr>
			<td id='listTitle'>과목조건</td>
		</tr>		
		<tr>
			<td>
				<table border='1' width='100%' cellpadding="0" cellspacing="0">
					<col width='100'>
					<col width='100'>
					<col width='100'>
					<col width='100'>
			
					<tr align='center'>


						<td id='title'>학과</td>
						<td><%=deptinfo.getDept_nm() %></td>
						<td id='title'>이수 구분</td>
						<td>전체</td>						
						<td id='title'>이수학년</td>
						<td>
							<select id='contSelect' name="student_year">
								<option value="1">1학년</option>
								<option value="2">2학년</option>
							</select>
						</td>
						<td id='title'>이수학번</td>
						<td><input type="text" id='contInput' readonly="readonly" name="student_cd" value="<%=dto.getStudent_cd() %>"></td>
						<td><input type="submit" value='과목조회'></td>
						<td><input type=button value='수강신청' onclick="ask_go()"></td>
					</tr>
				</table>
			</td>
		</tr>
	</table>
    </form>
<table border='1' width="85%" cellpadding="0" cellspacing="0">
<form name="checkf" id="checkf" action="./lec_control.jsp" method="post">
<input type="hidden" name="command" value="checked">
	<tr>
		<td>			
			<table border='1' width="100%" cellpadding="0" cellspacing="0">
				<col width='20'>
				<col width='60'>
				<col width='100'>
				<col width='30'>
				<col width='50'>
				<col width='70'>
				<col width='60'>
				<col width='60'>
				<col width='60'>
				<col width='50'>
				<col width='50'>
				<col width='80'>
				<tr align='center'>
					<td id='title'>선택</td>
					<td id='title'>학수 번호</td>
					<td id='title'>교과목명</td>
					<td id='title'>강좌</td>
					<td id='title'>학년</td>
					<td id='title'>이수구분</td>
					<td id='title'>교양그룹</td>
					<td id='title'>주야구분</td>
					<td id='title'>학점</td>
					<td id='title'>총시간</td>
					<td id='title'>수업시간</td>
					<td id='title'>담당교수</td>
				</tr>
				<%
				if (lists == null || lists.size()==0) {
				%>
				<tr height="25">
					<td colspan="12" align="center"><font color=#EB000000 size='2'><b>등록된 목록이 없습니다.</b></font></td>
				</tr>
				<%
				} else {
					int i=0;
					int j=0;
					for (CustUserDtos dtos : lists) {
				%>
				<tr align="center" style="font-size: 13">
					<td>
						<input type ="checkbox" name="curi_num" id="curi_num<%=i%>" value="<%=dtos.getCuri_num()%><%= dtos.getCuri_class()%>"
						onclick="shows(this)" />
						<input type="hidden" name="com_year" id="com_year" value="<%=dtos.getCom_year() %>"/ >
					</td>					
					<td id='cont'><%=dtos.getCuri_num() %></td>
					<td id='cont'><%=dtos.getCuri_nm() %></td>
					<td id='cont'><%=dtos.getCuri_class() %></td>
					<td id='cont'><%=dtos.getCom_year() %></td>
					<td id='cont'><%=dtos.getCont_desc() %></td>
					<td id='cont'><%
					if(dtos.getCult_group()==null){
						classdiv = "&nbsp;";
					}else{
						classdiv = dtos.getCult_group();
					}
					%><%=classdiv %></td>
					<td id='cont'><%=dtos.getClass_div() %></td>
					<td id='cont'><%=dtos.getCdt_num() %></td>
					<td id='cont'><%=dtos.getWp_time() %></td>
					<td id='cont'><%=dtos.getStart_time()%></td>
					<td id='cont'><%=dtos.getPropessor_nm() %></td>
				</tr>
				<%					
					}
				}
				%>
			</table>
		</form>	
	
	<tr>
		<td>
			<table width='100%' cellpadding="0" cellspacing="0" border='0'>
			<col width='750'/>
			<col width='100'/>
				<tr>
					<td id='listTitle'>수강신청내역</td>
					<td align='center'><input type="button" value="수강신청취소" onclick="del()"></td>
				</tr>
			</table>
		</td>
	</tr>
	<tr>
		<td>
			<form id="muldel" name="muldel" action="./lec_control.jsp" method="post">
			<input type="hidden" name="command" value="muldel">
			<table border='1' width="100%" cellpadding="0" cellspacing="0">
				<col width='20'>
				<col width='60'>
				<col width='100'>
				<col width='20'>
				<col width='50'>
				<col width='20'>
				<col width='40'>
				<col width='70'>
				<col width='150'>
				<col width='80'>
				<tr align='center'>
					<td id='title'>선택</td>
					<td id='title'>학수번호</td>
					<td id='title'>교과목명</td>
					<td id='title'>강좌</td>
					<td id='title'>이수구분</td>
					<td id='title'>주야구분</td>
					<td id='title'>학점</td>
					<td id='title'>강의요일/시간</td>
					<td id='title'>강의실</td>
					<td id='title'>담당교수</td>						
				</tr>					
				<%
					if (lists == null) {
				%>
				<tr height="25">
					<td colspan="12" align="center"><font color=#EB000000 size='2'><b>등록된 목록이 없습니다.</b></font></td>
				</tr>
				<%
					} else {
						int i=0;
						for (CustUserDtos dto2 : showleck) {
				%>
				<tr align="center">
					<td>
						<input type="checkbox" name="curi_nums" id="curi_nums<%=i++%>" value=<%=dto2.getCuri_num() %> />
					</td>
					<td id='cont'><%=dto2.getCuri_num() %></td>
					<td id='cont'><%=dto2.getCuri_nm() %></td>
					<td id='cont'><%=dto2.getCuri_class() %></td>
					<td id='cont'><%=dto2.getCont_desc() %></td>
					<td id='cont'><%=dto2.getClass_div() %></td>
					<td id='cont'><%=dto2.getCdt_num() %></td>
					<td id='cont'><%=dto2.getWeek_day() %>/<%=dto2.getStart_time() %></td>
					<td id='cont'><%=dto2.getBld_nm() %>,<%=dto2.getRoom_nm() %></td>
					<td id='cont'><%=dto2.getPropessor_nm() %></td>				
				</tr>
				<%
						}
					}
				%>
			</table>
			</form>
		</td>
	</tr>
</table>

<table border="1" width='85%' cellpadding='0' cellspacing="0">
	<col width='100'/>
	<col width='450'/>
		<tr>
			<td id='title'>신청가능학점</td>
			<td id='cont'>&nbsp;</td>
		</tr>
		<tr>
			<td id='title'>신청한학점</td>
			<td id='cont'>&nbsp;</td>
		</tr>
</table>
<br><br>
</body>
</html>