<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
<script src="js/jquery-1.7.1.min.js"></script>
<script type="text/javascript">
	function linkedPage4(URL){
		$("div#right").html("<object data=\"" + URL + "\" width=100% height=100%>")
	}
</script>
</head>
<body>
	<div align="center">
				<h2>직원 정보 조회</h2>
				<table border="1">
					<tr>
						<th>사번</th>
						<th>이름</th>
						<th>직위</th>
						<th>전화번호</th>
					</tr>
					<tr>
						<td><a href="empInfo.jsp?id=201101&name=김일문&jik=부장&tel=010-111-1111">201101</a></td>
						<td>김일문</td>
						<td>부장</td>
						<td>010-111-1111</td>
					</tr>
					<tr>
						<td><a href="empInfo.jsp?id=201102&name=홍진희&jik=과장&tel=010-222-2222">201102</a></td>
						<td>홍진희</td>
						<td>과장</td>
						<td>010-222-2222</td>
					</tr>
					<tr>
						<td><a href="empInfo.jsp?id=201103&name=이길홍&jik=차장&tel=010-333-3333">201103</a></td>
						<td>이길홍</td>
						<td>차장</td>
						<td>010-333-3333</td>
					</tr>
					<tr>
						<td><a href="empInfo.jsp?id=201104&name=정지훈&jik=대리&tel=010-444-4444">201104</a></td>
						<td>정지훈</td>
						<td>대리</td>
						<td>010-444-4444</td>
					</tr>
				</table>
			</div>
</body>
</html>