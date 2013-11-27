<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
	<h2>직원 정보 등록</h2>
	<form method="post" action="insert">
	<table width="500" cellspacing="0" cellpadding="2" align="center">
		
		<tr>
			<th width="100" bgcolor="#ffcc00">사번</th>
			<td width="400" align="left"><input type="text" required name="title" size="50"></td>
		</tr>		
		<tr>
			<th width="100" bgcolor="#ffcc00">이름</th>
			<td width="400" align="left"><input type="text" required name="title" size="50"></td>
		</tr>
		<tr>
			<th width="100" bgcolor="#ffcc00">전화번호</th>
			<td width="400" align="left"><input type="text" required name="title" size="50"></td>
		</tr>
		<tr>
			<th width="100" bgcolor="#ffcc00">직위</th>
			<td width="400">
				<select style="width: 333px">
					<option>이사</option>
					<option>부장</option>
					<option>차장</option>
					<option>과장</option>
					<option>대리</option>
				</select>
			</td>
		</tr>
		<tr>
			<th width="100" bgcolor="#ffcc00">취미</th>
			<td width="400">
				<input type="checkbox" value="문화">문화
				<input type="checkbox" value="스포츠">스포츠
				<input type="checkbox" value="기타">기타
			</td>
		</tr>
		<tr>
			<th width="100" bgcolor="#ffcc00">비고</th>
			<td width="400">
				<textarea rows="5" cols="10" style="width: 333px"></textarea>
			</td>
		</tr>
		
		
		
		<tr>			
			<td colspan="2">
			<input type="submit" value="작성완료"> &nbsp;
			<input type="button" value="취소" onclick="reset()">
			</td>
		</tr>
	</table>
	</form>
	</div>
</body>
</html>