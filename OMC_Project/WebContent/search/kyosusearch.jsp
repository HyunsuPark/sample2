<%@page import="com.OMC.daos.SearchManager"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.OMC.dtos.search.KyosuSelectDto"%>
<%@page import="java.util.List"%>
<%@page import="com.OMC.daos.SearchManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>교수조회</title>
<style type="text/css">
td#title{
	background-color: #f0f0f0;
	font-size: 13px;
	font-weight: bold;
	
}
td#listTitle{
	background-color: #28A0FF;
	font-size: 15px;
	font-weight: bold;
	color:black;
	height:25; 
	text-indent: 5px;
}

tr#listTitle{
	background-color: #28A0FF;
	font-size: 15px;
	font-weight: bold;
	color:black;
	height:25; 
	text-indent: 5px;
}
</style>
</head>
<script type="text/javascript" src="jquery-1.7.1.min.js"></script>
<script type="text/javascript">
function search(emp_id,kor_nm,subject) {
	if(emp_id == "" && kor_nm != "" && subject=="") {
	$.ajax({
		type : "POST",
		url : "../kyosuSearchAjaxServlet",
		data : "kor_nm="+kor_nm,  
		async : true,
		success : function(msg) {
			addRow(msg);
		}
	});
	}else if(emp_id == "" && kor_nm == "" && subject == ""){ 
		alert("학과를 선택해주세요!");
	}else if(emp_id == "" && kor_nm == "" && subject != ""){ 
		$.ajax({
			type : "POST",
			url : "../kyosuSearchAjaxServlet2",
			data : "subject="+subject,
			sync : true,
			success : function(msg) {
				addRow(msg);
			}
		});
	}else if(emp_id == "" && kor_nm != "" && subject != ""){ 
		$.ajax({
			type : "POST",
			url : "../kyosuSearchAjaxServlet3",
			data : "kor_nm="+kor_nm+"&subject="+subject,
			sync : true,
			success : function(msg) {
				addRow(msg);
			}
		});
	}
	

	function addRow(nodes) {
		var len = nodes.kyosusearch.length;
		var rows = $("#searchTable tr");
		if(len > 0) {
			for ( var i = 0; i < rows.length; i++) {
				$("#index"+i).remove();
			}
			$("#noindex").remove();
			
			for (var i = 0; i < len; i++) {
				var emp_id = nodes.kyosusearch[i].emp_id;//교직원번호
				var kor_nm = nodes.kyosusearch[i].kor_nm;//성명
				var ssn = nodes.kyosusearch[i].ssn;//주민등록번호
				var jacont = nodes.kyosusearch[i].jacont;//재직구분
				var jikcont = nodes.kyosusearch[i].jikcont;//직급명
				var jocont = nodes.kyosusearch[i].jocont;//직종명
				var dept_nm = nodes.kyosusearch[i].dept_nm;//소속학과명
				
				if(jikcont == ""){
					jikcont = "-- --";
				}
				if(dept_nm == ""){
					dept_nm = "&nbsp;";
				}
				
				$('#searchTable tr:eq(1)').after(
						"<tr id='index"+i+"'>"
						+"<td align='center' onclick='submitToParent1()'>"+(len-i)+"</td>"
						+"<td align='center' id='"+(len-i)+"' onclick='submitToParent1(this.id)'>"+emp_id+"</td>"
						+"<td align='center' id='kornm"+(len-i)+"' onclick='submitToParent1(this.id)'>"+kor_nm+"</td>"
						+"<td align='center' onclick='submitToParent1()'>"+ssn+"</td>"
						+"<td align='center' onclick='submitToParent1()'>"+jacont+"</td>"
						+"<td align='center' onclick='submitToParent1()'>"+jikcont+"</td>"
						+"<td align='center' onclick='submitToParent1()'>"+jocont+"</td>"
						+"<td align='center' onclick='submitToParent1()'>"+dept_nm+"</td>"
						+"</tr>");
			}
		}else{
			for (var i = 0; i <= rows.length; i++) {
				$("#index"+i).remove();
			}
			$("#noindex").remove();
			$('#searchTable tr:eq(1)').after(
					"<tr id='noindex'>"
					+"<td id=title colspan='8' align='center'>해당 사항이 없습니다.</td>"
					+"</tr>");
			
			}
		}//KyosuSearchAjaxServlet에서 값을 받아 jsp에 뿌려준다.
	}




function submitToParent1(obj){
	var empid=document.getElementById(obj).innerHTML;
	var kornm=document.getElementById("kornm"+obj).innerHTML;
	opener.document.all.emp_id1.value = empid;
	opener.document.all.kor_nm1.value = kornm;
	self.close();
}
</script>
<body onkeypress="if(event.keyCode == 13) return search(emp_id.value,kor_nm.value,subject.value)" >
<%
List<KyosuSelectDto> lists = new ArrayList<KyosuSelectDto>();
SearchManager dao = new SearchManager();
lists = dao.getKyosuSelect();
%>
	<table align="center" border="0" width="85%">
		<tr>
			<td id=title>검색조건&nbsp;&nbsp;&nbsp;※학과를 반드시 선택해주세요</td>
		</tr>
		<tr>
		<td align="right"><input type="button" value="조회" onclick="search(emp_id.value,kor_nm.value,subject.value)"><input type="button" onclick="javascript:window.close();" value="닫기"></td>
		</tr>
		<tr>
			<td colspan="2">
				<table border='1' width="100%" cellpadding="0" cellspacing="0">
					<tr>
						<td id=title>교직원번호</td>
						<td><input type="text" value="" size="6" name="emp_id" readonly="readonly"></td>
						<td id=title>성명</td>
						<td><input type="text" size="5" name="kor_nm" value=""></td>
					</tr>
					<tr>
						<td id=title>학과</td>
						<td>
							<select name="subject">
								<option value="">전체</option>
							<%
							for(KyosuSelectDto dto : lists)
							{	
							%>
								<option value="<%=dto.getDept_cd()%>"><%=dto.getDept_nm()%></option>
							<%
							}
							%>	
							</select>
						</td>
					
						<td id=title>재직구분</td>
						<td>
							<select name="office_div">
								<option value="0">전체</option>
							</select>
						
					</tr>
				</table>
			</td>
		</tr>
		<tr width="100%">
			<td width="100%" colspan="2">
				<table border='1' width="100%" cellpadding="0" cellspacing="0" id="searchTable">
				<tr>
					<td id=title colspan="8">DATA</td>
				</tr>
				<tr id=listTitle align="center">
					<td width="1%">&nbsp;</td>
					<td width="7%">교직원번호</td>
					<td width="3%">성명</td>
					<td width="5%">주민등록번호</td>
					<td width="4%">재직구분</td>
					<td width="6%">직급명</td>
					<td width="4%">직종명</td>
					<td width="10%">소속학과명</td>
				</tr>
				<tr>
					<th></th>
					<th></th>
					<th></th>
					<th></th>
					<th></th>  
					<th></th>
					<th></th>
					<th></th>
				</tr>	
				</table>
			</td>
		</tr>
	</table>
</body>
</html>