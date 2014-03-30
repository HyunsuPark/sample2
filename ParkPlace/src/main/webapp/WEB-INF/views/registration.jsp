<%@ include file="/WEB-INF/views/common/head.jsp" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%> 
<body>
<%@ include file="/WEB-INF/views/common/nav.jsp" %>
	
	<div class="container" >
		<header id="header">
			<h1>주차장 등록</h1>
			<div class="cl">&nbsp;</div>
		</header>
		<form action="saveRegi.do" method="post" enctype="multipart/form-data">
			<dl>
				<dt>
					<label>주차장명</label>
				</dt>
				<dd>
					<input type="text" name="parking_name" class="form-control" style="width: 260px;" required="required" >
				</dd>
			</dl>
			<dl>
				<dt>
					<label>대표/관리자</label>
				</dt>
				<dd>
					<input type="text" name="owner" class="form-control" style="width: 260px;" required="required">
				</dd>
			</dl>
			<dl>
				<dt>
					<label>전화번호</label>
				</dt>
				<dd>
					<input type="text" name="phone" class="form-control" style="width: 260px;" required="required">
				</dd>
			</dl>
			<dl>
				<dt>
					<label>주소</label>
				</dt>
				<dd>
					<input type="text" name="addr" class="form-control" style="width: 260px;" required="required">
				</dd>
			</dl>
			<dl>
				<dt>
					<label>관리자핸드폰</label>
				</dt>
				<dd>
					<input type="text" name="owner_phone" class="form-control" style="width: 260px;" required="required">
				</dd>
			</dl>
			<dl>
				<dt>
					<label>주차장형태</label>
				</dt>
				<dd>
					<input type="radio" name="parking_type" value="건물부설주차장" checked="checked"> 건물부설 주차장
					<input type="radio" name="parking_type" value="공영주차장"> 공영 주차장
					<input type="radio" name="parking_type" value="노외/노상주차장"> 노외/노상 주차장
					<input type="radio" name="parking_type" value="기타주차장"> 기타 주차장
				</dd> 
			</dl>
			<dl>
				<dt>
					<label>총 주차대수</label>
				</dt>
				<dd>
					<input type="text" name="all_cnt" class="form-control" style="width: 260px;" required="required">
				</dd>
			</dl>
			<dl>
				<dt>
					<label>정기 주차대수</label>
				</dt>
				<dd>
					<input type="text" name="avg_cnt" class="form-control" style="width: 260px;" required="required">
				</dd>
			</dl>
			<dl>
				<dt>
					<label>10분당 요금</label>
				</dt>
				<dd>
					<input type="text" name="pay1" class="form-control" style="width: 260px;" required="required">
				</dd>
			</dl> 
			<dl>
				<dt>
					<label>일일 최대요금</label>
				</dt>
				<dd>
					<input type="text" name="pay2" class="form-control" style="width: 260px;" required="required">
				</dd>
			</dl>
			<dl>
				<dt>
					<label>월정 정기요금</label>
				</dt>
				<dd>
					<input type="text" name="pay3" class="form-control" style="width: 260px;" required="required">
				</dd>
			</dl>
			<dl>
				<dt>
					<label>여유 주차대수</label>
				</dt>
				<dd>
					<input type="text" name="cnt1" class="form-control" style="width: 260px;" required="required">
				</dd>
			</dl>
			<dl>
				<dt>
					<label>부족 주차대수</label>
				</dt>
				<dd>
					<input type="text" name="cnt2" class="form-control" style="width: 260px;" required="required">
				</dd>
			</dl>
			<dl>
				<dt>
					<label>P-Peck/Time(주차장 혼잡시간대)</label>
				</dt>
				<dd>
					<input type="text" name="time1" class="form-control" style="width: 260px;" required="required" placeholder="ex)12:00 - 14:00">
				</dd>
			</dl>
			<dl>
				<dt>
					<label>P-Lose/Time(주차공간 여유시간대)</label>
				</dt>
				<dd>
					<input type="text" name="time2" class="form-control" style="width: 260px;" required="required" placeholder="ex)12:00 - 14:00">
				</dd>
			</dl>
			<dl>
				<dt>
					<label>할인 방식</label>
				</dt>
				<dd>
					<input type="radio" name="dc_type" value="시간대" checked="checked"> 시간대
					<input type="radio" name="dc_type" value="방문객"> 방문객
					<input type="radio" name="dc_type" value="구매고객"> 구매고객
					<br>
					기타 <input type="text" name="dc_type" class="form-control" style="width: 100px;">
				</dd> 
			</dl>
			<dl>
				<dt>
					<label>할인 방식</label>
				</dt>
				<dd>
					<input type="radio" name="system" value="발권기" checked="checked"> 발권기
					<input type="radio" name="system" value="차번인식"> 차번인식
					<input type="radio" name="system" value="무인정산기"> 무인정산기
				</dd>
			</dl>
			<dl>
				<dt>
					<label>첨부파일</label>
				</dt>
				<dd>
					<input type="file" name="files[0]">
					<input type="file" name="files[1]">
					<input type="file" name="files[2]">
				</dd>
			</dl>
			<input type="submit" value="등록" class="btn btn-primary">
		</form> 
	</div>
	 <!-- footer -->
	 
	<!-- end of footer -->
<!-- end of wrapper -->
</body>
</html>