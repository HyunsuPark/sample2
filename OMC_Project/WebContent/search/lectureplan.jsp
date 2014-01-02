<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String apps=request.getContextPath();
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>강의계획서조회</title>
<script type="text/javascript" src="jquery-1.7.1.min.js"></script>
<link rel="stylesheet" href="./css/omc.css" type="text/css">
<script type="text/javascript">
function search(curi_num1,curi_nm1,kor_nm1,smt) {
	if(curi_num1 != "" && kor_nm1 != "" && curi_nm1 != "" && smt != "") {
		$.ajax({
		type : "POST",
		url : "<%=apps%>/lecturePlanAjaxServlet",
		data : "curi_num1="+curi_num1+"&curi_nm1="+curi_nm1+"&kor_nm1="+kor_nm1+"&smt="+smt,  
		async : true,
		success : function(msg) {
			addRow(msg);
		}
	});
	}else if(curi_num1 == "" && curi_nm1=="" && kor_nm1 == "" && smt != ""){ 
		$.ajax({
			type : "POST",
			url : "<%=apps%>/lecturePlanAjaxServlet1",
			data : "",
			sync : true,
			success : function(msg) {
				addRow(msg);
			}
		});
	}else if(curi_num1 != "" && curi_nm1 != "" && kor_nm1=="" && smt != ""){ 
		$.ajax({
			type : "POST",
			url : "<%=apps%>/lecturePlanAjaxServlet2",
			data : "curi_num1="+curi_num1+"&curi_nm1="+curi_nm1+"&smt="+smt,
			sync : true,
			success : function(msg) {
				addRow(msg);
			}
		});
	}else if(kor_nm1 != "" && smt != "" && curi_num1 == "" && curi_nm1 == ""){ 
		$.ajax({
			type : "POST",
			url : "<%=apps%>/lecturePlanAjaxServlet3",
			data : "kor_nm1="+kor_nm1+"&smt="+smt,
			async : true,
			success : function(msg) {
				addRow(msg);
			}
		});
	}else if(kor_nm1 == "" && smt != "" && curi_num1 == "" && curi_nm1 != ""){ 
		$.ajax({
			type : "POST",
			url : "<%=apps%>/lecturePlanAjaxServlet4",
			data : "curi_nm1="+curi_nm1+"&smt="+smt,
			async : true,
			success : function(msg) {
				addRow(msg);
			}
		});
	}else if(kor_nm1 == "" && smt != "" && curi_num1 != "" && curi_nm1 == ""){ 
		alert("교과목명을 입력해주세요");
	}	
	

	function addRow(nodes) {
		var len = nodes.plandto.length;
		var rows = $("#searchTable tr");
		//alert(rows.length+":"+len);
		if(len>0) {
			for ( var i = 0; i < rows.length; i++) {
				$("#index"+i).remove();
			} 
			$("#noindex").remove();
			for (var i = 0; i < len; i++) {
				var curi_num2 = nodes.plandto[i].curi_num1;//교직원번호
				var curi_nm2 = nodes.plandto[i].curi_nm1;//성명
				var kor_nm2 = nodes.plandto[i].kor_nm1;//주민등록번호
									
				$('#searchTable tr:eq(2)').after(
						"<tr id='index"+i+"'>"
						+"<td id='title' align='center'>"+curi_num2+"</td>"
						+"<td id='title' align='center'><a onclick=window.open('./search/lectureview.jsp','newWin')>"+curi_nm2+"</a></td>"
						+"<td id='title' align='center'>"+kor_nm2+"</td>"
						+"</tr>");
			}
		}else{
			for (var i = 0; i <= rows.length; i++) {
				
				$("#index"+i).remove();
			}
			$("#noindex").remove();
			$('#searchTable tr:eq(1)').after(
					"<tr id='noindex'>"
					+"<td colspan='7' align='center'>해당되는 과목이 없습니다.</td>"
					+"</tr>");
			
		}
		}//KyosuSearchAjaxServlet에서 값을 받아 jsp에 뿌려준다.
	}


var winObject = null;
var winObject1 = null;
var winObject2 = null;
function popupWindow(){
	var settings ='toolbar=0,directories=0,status=no,menubar=0,scrollbars=yes,resizable=no,height=800,width=800,left=0,top=0';
	winObject = window.open("./search/lecturesearch.jsp", "lecturesearch", settings);
	}
	
function popupWindow1(){
	var settings ='toolbar=0,directories=0,status=no,menubar=0,scrollbars=yes,resizable=no,height=800,width=800,left=0,top=0';
	winObject1 = window.open("./search/kyosusearch.jsp", "kyosusearch", settings);
	}	

function popupWindow2(){
	var settings ='toolbar=0,directories=0,status=no,menubar=0,scrollbars=yes,resizable=no,height=800,width=800,left=0,top=0';
	winObject1 = window.open("./search/lectureview.jsp", "lectureview.jsp", settings);
}
	

</script>
</head>
<body onkeypress="if(event.keyCode == 13) return search(curi_num1.value,curi_nm1.value,kor_nm1.value,smt.value)">
	<table border="0" width="85%">
		<tr>
			<td align="center"><b>수업 | 강의계획서조회</b></td>
		</tr>
		<tr><td align="right"><input type="button" onclick="search(curi_num1.value,curi_nm1.value,kor_nm1.value,smt.value)" value="조회"><input type="button" onclick="javascript:window.print()" value="출력"></td></tr>
	</table>
	<br>
	<table  border='1' width="85%" cellpadding="0" cellspacing="0">
		<tr>
			<td id='listTitle' width="95%">검색조건&nbsp;<font size="2">※조회하고자 하는 학수번호 및 과목명,담당교수를 세팅하고 조회버튼을 클릭(미세팅시 전과목 조회)</font></td>
		
		</tr>
		<tr align="left">
			<td align="left" width="100%"  colspan="2">
				<table border="1">
						<tr align="center">
							<td id=title width="5%" align="center">학년도</td>
							<td width="5%" align="center"><input type="text" size="4" readonly="readonly" value="2011"></td>
							<td id=title width="4%" align="center">학기</td>
							<td width="5%" align="center"><select name="smt">
								<option value="10">1학기</option>
								<option value="11">여름학기</option>
								<option value="20">2학기</option>
								<option value="21">겨울학기</option>
								</select>
							</td>
							<td id=title width="5%" align="center">학수번호</td>
							<td width="5%"><input type="text" size="6" name=curi_num1 value=""></td>
							<td id=title width="4%" align="center">과목명</td>
							<td width="5%"><input type="text" size="10" name=curi_nm1 value=""></td>
							<td width="5%"  colspan="2"><input type="button" onclick="popupWindow()" value="과목검사"></td>
						</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<table  border='1' width="100%" cellpadding="0" cellspacing="0">
					<tr>
						<td id=title align="center">교직원번호</td>
						<td><input type="text" value="" name="emp_id1" size="7" readonly="readonly"></td>
						<td id=title align="center">성명</td>
						<td><input type="text" size="5" name="kor_nm1" value=""></td>
						<td><input type="button"  onclick="popupWindow1()" value="교수검색"></td>
					</tr>			
				</table>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<table  border='1' width="100%" cellpadding="0" cellspacing="0" id="searchTable">
					<tr>
						<td id=listTitle colspan="4" width="100%">검색결과</td>
					</tr>
						<tr>
							<td id=title align="center" width="35%">학수번호</td>
							<td id=title align="center" width="35%">교과목명</td>
							<td id=title align="center" width="35%">대표교수</td>
						</tr>
						<tr>
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