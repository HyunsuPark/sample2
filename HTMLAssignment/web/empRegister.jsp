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
	<form method="get" action="register">
	<table width="500" cellspacing="0" cellpadding="2" align="center">
		<tr>
			<th width="100" bgcolor="#ffcc00">사번</th>
			<td width="400" align="left"><input type="text" required name="no" size="50"></td>
		</tr>		
		<tr>
			<th width="100" bgcolor="#ffcc00">이름</th>
			<td width="400" align="left"><input type="text" required name="name" size="50"></td>
		</tr>
		<tr>
			<th width="100" bgcolor="#ffcc00">전화번호</th>
			<td width="400" align="left"><input type="text" required name="tel" size="50"></td>
		</tr>
		<tr>
			<th width="100" bgcolor="#ffcc00">직위</th>
			<td width="400">
				<select name="jik" style="width: 333px">
					<option value="이사">이사</option>
					<option value="부장">부장</option>
					<option value="차장">차장</option>
					<option value="과장">과장</option>
					<option value="대리">대리</option>
				</select>
			</td>
		</tr>
		<tr>
			<th width="100" bgcolor="#ffcc00">취미</th>
			<td width="400">
				<input type="checkbox" value="문화" name="hobby">문화
				<input type="checkbox" value="스포츠" name="hobby">스포츠
				<input type="checkbox" value="기타" name="hobby">기타
			</td>
		</tr>
		<tr>
			<th width="100" bgcolor="#ffcc00">비고</th>
			<td width="400">
				<textarea name="etc" rows="5" cols="10" style="width: 333px"></textarea>
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