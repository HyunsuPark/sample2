<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>강의평가등록</title>
<link rel="stylesheet" href="./css/omc.css" type="text/css">
</head>
<body onload='javascript:alert("등록기간이 아닙니다");'>
	<table border="0" width="85%">
		<tr>
			<td align="center"><b>수업 | 강의평가등록</b></td>
		</tr>
		<tr>
		<td align="right"><input type="button" onclick="search(curi_num1.value,curi_nm1.value,kor_nm1.value,smt.value)" value="조회">
			<input type="button" value="저장"></td>
		</tr>
	</table>
	<br>
	<table border='1' width="85%" cellpadding="0" cellspacing="0">
		<tr>
			<td id=listTitle>검색조건&nbsp;</td>
		</tr>
		<tr align="left">
			<td align="left" colspan="2">
				<table border='1' width="100%" cellpadding="0" cellspacing="0">
						<tr align="center">
							<td id=title width="5%" align="center">학년도</td>
							<td width="5%" align="center"><input type="text" size="4" value="2011"></td>
							<td id=title width="4%" align="center">학기</td>
							<td width="5%" align="center"><select name="smt">
								<option value="10">1학기</option>
								<option value="11">여름학기</option>
								<option value="20">2학기</option>
								<option value="21">겨울학기</option>
								</select>
							</td>
							<td id=title  width="5%" align="center">평가대상과목</td>
							<td width="5%"><select name="smt">
								<option value="10">강의평가 기간이 아닙니다.</option>
								</select></td>
						</tr>
				</table>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<table border='1' width="100%" cellpadding="0" cellspacing="0" id="searchTable">
					<tr>
						<td id=title colspan="4" width="100%">DATA&nbsp; *수강중인 모든 강좌에 대해 교수님별 강의평가를 등록해야 당해학기 성적조회가 가능합니다. 이미 완료된 강좌는 조회,수정이 불가합니다.</td>
					</tr>
						<tr><td>
							<table border='1' width="100%" cellpadding="0" cellspacing="0">
								<col width="50">
								<col width="100">
								<col width="400">
								<col width="50">
								<col width="50">
								<col width="50">
								<col width="50">
								<col width="50">
								<tr id=listTitle>
									<td align="center">문항</td>
									<td align="center">평가구문</td>
									<td align="center">문항명</td>
									<td align="center">매우그렇다</td>
									<td align="center">조금그렇다</td>
									<td align="center">보통이다</td>
									<td align="center">그렇지않다</td>
									<td align="center">매우그렇지않다</td>
								</tr>
								<tr height="100">
									<td colspan="8" align="center">강의 평가 기간이 아닙니다^^</td>
								</tr>
							</table>
							</td>
						</tr>
						<tr>
							<td id=listTitle colspan="2" align="center">※건의사항을 입력해주세요</td>
						</tr>
						<tr>
							<td align="center" colspan="2">
							<textarea rows='3', cols='100'>건의사항을 센스있게 써주세요. 비방글은 반드시 잡아냅니다.</textarea></td>
						</tr>
				</table>
			</td>
		</tr>
	</table>
</body>
</html>