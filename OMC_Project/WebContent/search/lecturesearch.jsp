<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.List"%>
<%@page import="com.OMC.daos.SearchService"%>
<%@page import="com.OMC.dtos.search.LectureSearchDto"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
 String apps = request.getContextPath();
%>
    
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>과목조회</title>
<script type="text/javascript" src="jquery-1.7.1.min.js"></script>
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
<script type="text/javascript">
	function search(curi_num,curi_nm) {
		if(curi_num != "" && curi_nm == "") {
		$.ajax({
			type : "POST",
			url : "../lectureSearchAjaxServlet",
			data : "curi_num="+curi_num,  
			async : true,
			success : function(msg) {
				addRow(msg);
			}
		});
		} else if(curi_num == "" && curi_nm != ""){ 
			$.ajax({
				type : "POST",
				url : "../lectureSearchAjaxServlet2",
				data : "curi_nm="+curi_nm,
				async : true,
				success : function(msg) {
					addRow(msg);
				}
			});
		}else if(curi_num != "" && curi_nm != ""){ 
			$.ajax({
				type : "POST",
				url : "../lectureSearchAjaxServlet3",
				data : "curi_num="+curi_num + "&curi_nm="+curi_nm,
				async : true,
				success : function(msg) {
					addRow(msg);
				}
			});//Ajax를 이용한 검색결과 뿌리기.(LectrueSearchAjaxServlet으로 던진다.)
	}else if(curi_num == "" && curi_nm == ""){ 
		$.ajax({
			type : "POST",
			url : "../lectureSearchAjaxServlet4",
			data : "",
			sync : true,
			success : function(msg) {
				addRow(msg);
			}
		});//Ajax를 이용한 검색결과 뿌리기.(LectrueSearchAjaxServlet으로 던진다.)
	}else{
		alert("학수번호 6자리 및 과목을 입력해주세요!!");
	}

	
	function addRow(nodes) {
		var len = nodes.searchdto.length;
		var rows = $("#searchTable tr");
				if(len > 0) {
					for ( var i = 0; i < rows.length; i++) {
						$("#index"+i).remove();
					}
					$("#noindex").remove();
					for (var i = 0; i < len; i++) {
						var curi_num = nodes.searchdto[i].curi_num;
						var curi_nm = nodes.searchdto[i].curi_nm;
						var curi_nm_eng = nodes.searchdto[i].curi_nm_eng;
						var dept_nm = nodes.searchdto[i].dept_nm;
						var cre_dt = nodes.searchdto[i].cre_dt;
						var close_dt=nodes.searchdto[i].close_dt; 
										
						if(close_dt == "NULL"){
							close_dt = "-- --";
						}
						if(dept_nm == ""){
							dept_nm = "-- --";
						}
						
						
						$('#searchTable tr:eq(1)').after(
								"<tr id='index"+i+"'>"
								+"<td align='center' onclick='submitToParent()'>"+(len-i)+"</td>"
								+"<td align='center' id='"+(len-i)+"' onclick='submitToParent(this.id)'>"+curi_num+"</td>"
								+"<td align='center' id='curinm"+(len-i)+"' onclick='submitToParent(this.id)'>"+curi_nm+"</td>"
								+"<td align='center' onclick='submitToParent()'>"+curi_nm_eng+"</td>"
								+"<td align='center' onclick='submitToParent()'>"+dept_nm+"</td>"
								+"<td align='center' onclick='submitToParent()'>"+cre_dt+"</td>"
								+"<td align='center' onclick='submitToParent()'>"+close_dt+"</td>"
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
			}//LectrueSearchAjaxServlet에서 값을 받아 jsp에 뿌려준다.
		}
		

	
	function submitToParent(obj){
		var curinum=document.getElementById(obj).innerHTML;
		var curinm=document.getElementById("curinm"+obj).innerHTML;
		opener.document.all.curi_num1.value = curinum;
		opener.document.all.curi_nm1.value = curinm;
		self.close();
	}
</script>
</head>
<body onkeypress="if(event.keyCode == 13) return search(curi_num.value,curi_nm.value)">
	<table align="center" border="0" width="85%">
		<tr>
			<td id=title>검색조건 ※과목명을 반드시 선택해주세요</td>
		</tr>
		<tr>
			<td align="right"><input type="button" onclick="search(curi_num.value,curi_nm.value)" value="조회"><input type="button" onclick="javascript:window.close();"  value="닫기"></td>
		</tr>
		<tr>
			<td colspan="2">
				<table border='1' width="100%" cellpadding="0" cellspacing="0">
					<tr>
						<td id=title>학수번호</td>
						<td><input type="text" name=curi_num id="curi_num" value="" size="6"></td>
						<td id=title>교과목명_한글</td>
						<td><input type="text" name=curi_nm id="curi_nm" size="10" value=""></td>
					</tr>
				</table>
			</td>
		</tr>
		
		<tr width="100%">
			<td width="100%" colspan="2">
				<table border="1" width="100%" id="searchTable">
				<tr>
					<td id=title colspan="7">DATA</td>
				</tr>
				<tr id=listTitle align="center">
					<td width="1%">&nbsp;</td>
					<td width="7%">학수번호</td>
					<td width="10%">교과목명_국문</td>
					<td width="10%">교과목명_영문</td>
					<td width="10%">주관부서</td>
					<td width="10%">신설일자</td>
					<td width="10%">폐지일자</td>
				</tr>
			</table>
			</td>
		</tr>
	</table>
</body>
</html>