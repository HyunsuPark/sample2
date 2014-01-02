<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>강의계획서</title>
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
</head>
<body onload="javascript:alert('수강신청기간이 아닙니다^^')">
	<h1 align="center">강의계획서</h1><br>
	<font size="4px" color="black" face="bold">※수강신청한 과목의 강의계획서는 수강신청내역 조회에서 바로 조회가능</font> 
	<table border="1" width="100%" align="center">
		<tr>
			<td>
				<table border="1" width="100%">
					<tr width="100%">
						<td width="7%" align="center" id="title">강의목표</td>
						<td width="80%" colspan="5" align="center">
						<br>수강신청 기간이 아닙니다
						<br>
						<Br></td>  
					</tr>
					<tr>
						<td width="8%" align="center" id="title">강의진행<br>방&nbsp;&nbsp;식</td>
						<td width="70%">&nbsp;</td>
						<td width="8%" align="center" id="title">평가<br>방식</td>
						<td width="15%" colspan="2">중간고사30%<br>기말고사30%<br>출석20%<br>과제20%<br></td>
					</tr>
					<tr>
					 <td width="5%" align="center" id="title">구분</td>	
					 <td width="5%" align="center" id="title">교재명</td>	
					 <td width="7%" align="center" id="title">저자명</td>	
					 <td align="center" id="title">출판사</td>	
					 <td width="7%" align="center" id="title">출판년도</td>	
					</tr>
					<tr>
					 <td align="center" id="title">주교재</td>	
					 <td>&nbsp;</td>	
					 <td>&nbsp;</td>	
					 <td>&nbsp;</td>	
					 <td>&nbsp;</td>	
					</tr>
					<tr>
					 <td align="center" id="title">주</td>	
					 <td align="center" id="title">강의내용 및 방법</td>	
					 <td align="center" colspan="2" id="title">과제물</td>	
					 <td align="center" colspan="2" id="title">학습자료</td>	
					</tr>
					<tr>
					 <td align="center">&nbsp;</td>	
					 <td>&nbsp;<br>&nbsp;</td>	
					 <td colspan="2">&nbsp;</td>	
					 <td colspan="2">&nbsp;</td>	
					</tr>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>