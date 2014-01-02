<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.OMC.daos.SearchManager"%>
<%@page import="com.OMC.dtos.search.ProSelect1Dto"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="com.OMC.daos.OMCManager"%>
<%
	request.setCharacterEncoding("utf-8");
	response.setContentType("text/html; charset=utf-8");
	String apps=request.getContextPath();
%>
<html>
<head>
<title>교수조회</title>
</head>
<script type="text/javascript" src="jquery-1.7.1.min.js"></script>
<script type="text/javascript">
function search(korNm,contDeptCd) {	
	if(korNm != "" && contDeptCd == "") {
// 		alert("kor");
		$.ajax({
			type : "POST",
			url : "../proSearch1AjaxServlet",
			data : "korNm="+korNm,  
			async : true,
			success : function(msg) {
// 				alert("1");
				addRow(msg);
			}
		});
	}else if(korNm == "" && contDeptCd != ""){ 
// 		alert("cont");
		$.ajax({
			type : "POST",
			url : "../proSearch2AjaxServlet",
			data : "contDeptCd="+contDeptCd,
			sync : true,
			success : function(msg) {
				addRow(msg);
			}
		});
	}else if(korNm !="" && contDeptCd !=""){
// 		alert("kor1");
// 		alert("cont1");
		$.ajax({
			type : "POST",
			url : "<%=apps%>/proSearch3AjaxServlet",
			data : "korNm="+korNm+"&contDeptCd="+contDeptCd,
			sync : true,
			success : function(msg) {
				addRow(msg);
			}
		});
	}else{
		alert("성명 또는 학과를 입력하세요");
	}
}

function addRow(nodes) {
	var len = nodes.prosear1dto.length;
	var rows = $("#searchTable tr");
//		alert(rows.length+":"+len);
	if(len!=0){
		if(rows.length > 2) {
			for ( var i = 0; i < rows.length-2; i++) {
				$("#index"+i).remove();
			}
			for (var i = 0; i < len; i++) {
				var empId = nodes.prosear1dto[i].aemEmpId;//교직원번호
				var korNm = nodes.prosear1dto[i].aemKorNm;//성명
				var ssn = nodes.prosear1dto[i].aemSsn;//주민등록번호
				var coffCont = nodes.prosear1dto[i].coffCont;//재직구분
				var cgraCont = nodes.prosear1dto[i].cgraCont;//직급명
				var coccCont = nodes.prosear1dto[i].coccCont;//직종명
				var Attest = nodes.prosear1dto[i].sdcAttest;//소속학과명
				if(cgraCont==""){
					cgraCont="&nbsp;";
				}
				$('#searchTable tr:eq(1)').after(
						"<tr id='index"+i+"' style='font-size : 12' ondblclick='submitToParent1("+(len-i)+")'>"
						+"<td align='center'>"+(len-i)+"</td>"
						+"<td align='center' id='"+(len-i)+"'>"+empId+"</td>"
						+"<td align='center' id='kornm"+(len-i)+"'>"+korNm+"</td>"
						+"<td align='center'>"+ssn+"</td>"
						+"<td align='center'>"+coffCont+"</td>"
						+"<td align='center'>"+cgraCont+"</td>"
						+"<td align='center'>"+coccCont+"</td>"
						+"<td align='center'>"+Attest+"</td>"
						+"</tr>");
			}
		}else{
			for (var i = 0; i < len; i++) {
				var empId = nodes.prosear1dto[i].aemEmpId;//교직원번호
				var korNm = nodes.prosear1dto[i].aemKorNm;//성명
				var ssn = nodes.prosear1dto[i].aemSsn;//주민등록번호
				var coffCont = nodes.prosear1dto[i].coffCont;//재직구분
				var cgraCont = nodes.prosear1dto[i].cgraCont;//직급명
				var coccCont = nodes.prosear1dto[i].coccCont;//직종명
				var Attest = nodes.prosear1dto[i].sdcAttest;//소속학과명
				if(cgraCont==""){
					cgraCont="&nbsp;";
				}						
				$('#searchTable tr:eq(1)').after(
						"<tr id='index"+i+"' style='font-size : 12' ondblclick='submitToParent1("+(len-i)+")'>"
						+"<td align='center'>"+(len-i)+"</td>"
						+"<td align='center' id='"+(len-i)+"'>"+empId+"</td>"
						+"<td align='center' id='kornm"+(len-i)+"'>"+korNm+"</td>"
						+"<td align='center'>"+ssn+"</td>"
						+"<td align='center'>"+coffCont+"</td>"
						+"<td align='center'>"+cgraCont+"</td>"
						+"<td align='center'>"+coccCont+"</td>"
						+"<td align='center'>"+Attest+"</td>"
						+"</tr>");
			}
		}
	}else{
		for ( var i = 0; i < rows.length-2; i++) {
			$("#index"+i).remove();
		}
		$('#searchTable tr:eq(1)').after(
				"<tr id='index0'>"
				+"<td colspan='8' align='center'>해당되는 쿄수가 없습니다.</td>"
				+"</tr>");
	}
}//KyosuSearchAjaxServlet에서 값을 받아 jsp에 뿌려준다.

function clo(){
	self.close();
	
}

function submitToParent1(obj){
	var empid=document.getElementById(obj).innerHTML;
	var kornm=document.getElementById("kornm"+obj).innerHTML;
	opener.document.all.empid.value = empid;
	opener.document.all.empnm.value = kornm;
	self.close();  
}

</script>
<body>
<%	
	SearchManager dao = new SearchManager();
	List<ProSelect1Dto> lists1 = dao.getProSelect1List();
%>
	<table border="1" width="100%" height="600">
		<tr>
			<td width="10%" height="20">검색조건</td>
			<td align="right"><input type="button" value="조회" onclick="search(korNm.value,contDeptCd.value)"><input type="button" value="닫기" onclick="clo()"></td>
		</tr>
		<tr>
			<td colspan="2" height="60">
				<table border="1">
					<tr>
						<td>교직원번호</td>
						<td><input type="text" value="" size="6" name="empId" readonly="readonly"></td>
						<td>성명</td>
						<td><input type="text" size="5" name="korNm" id="korNm"></td>
					</tr>
					<tr>
						<td>학과</td>
						<td>
							<select name="contDeptCd">
							<option>선택</option>
 							<% 
							for(ProSelect1Dto dto : lists1) 
							{	
 							%>
							<option value="<%=dto.getComDeptCd()%>"><%=dto.getAttest()%></option> 
							<% 
							} 
						%>	 
							</select>
						</td>
					
						<td>재직구분</td>
						<td>
							<select name="office_div">
								<option value="0">전체</option>
							</select>
						</td>
					</tr>
				</table>
			</td>
		</tr>
		<tr width="100%">
			<td width="100%" colspan="2" valign="top">
				<table border="1" width="100%" id="searchTable">
				<tr>
					<td colspan="8">DATA</td>
				</tr>
				<tr align="center">
					<td width="1%">&nbsp;</td>
					<td width="7%">교직원번호</td>
					<td width="3%">성명</td>
					<td width="10%">주민등록번호</td>
					<td width="4%">재직구분</td>
					<td width="7%">직급명</td>
					<td width="4%">직종명</td>
					<td width="10%">소속학과명</td>
				</tr>	
				</table>
			</td>
		</tr>
	</table>
</body>
</html>