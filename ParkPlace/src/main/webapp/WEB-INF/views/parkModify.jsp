<%@ include file="/WEB-INF/views/common/head.jsp" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%> 
<body>
<%@ include file="/WEB-INF/views/common/nav.jsp" %>
	<div class="container" >
		<header id="header">
			<h3>주차장 등록</h3>
			<div class="cl">&nbsp;</div>
		</header>
		<form action="saveParkRegi.do" method="post">
			<dl>
				<dt>
					<label>유형</label>
				</dt>
				<dd>
					<select name="p_type" class="form-control" style="width: 260px;">
						<option value="공영">공영</option>
						<option value="민영">민영</option>
					</select>
				</dd>
			</dl>
			<dl>
				<dt>
					<label>이름</label>
				</dt>
				<dd>
					<input type="text" name="p_name" value="${parkData['p_name']}" class="form-control" style="width: 260px;" required="required">
				</dd>
			</dl>
			<dl>
				<dt>
					<label>위도</label>
				</dt>
				<dd>
					<input type="text" name="p_latitude" value="${parkData['p_latitude']}" class="form-control" style="width: 260px;" required="required">
				</dd>
			</dl>
			<dl>
				<dt>
					<label>경도</label>
				</dt>
				<dd>
					<input type="text" name="p_longitude" value="${parkData['p_longitude']}" class="form-control" style="width: 260px;" required="required">
				</dd>
			</dl>
			<dl>
				<dt>
					<label>주소</label>
				</dt>
				<dd>
					<input type="text" name="p_address" value="${parkData['p_address']}" class="form-control" style="width: 260px;" required="required">
				</dd>
			</dl>
			<dl>
				<dt>
					<label>운영시간</label>
				</dt>
				<dd>
					<input type="text" name="p_time" value="${parkData['p_time']}" class="form-control" style="width: 260px;" required="required">
				</dd> 
			</dl>
			<dl>
				<dt>
					<label>요금표</label>
				</dt>
				<dd>
					<input type="text" name="p_pricetable" value="${parkData['p_pricetable']}" class="form-control" style="width: 594px;height: 80px;" required="required">
				</dd>
			</dl>
			<dl>
				<dt>
					<label>기본/분당</label>
				</dt>
				<dd>
					<input type="text" name="p_per1" value="${parkData['p_per1']}" class="form-control" style="width: 260px;" required="required">
				</dd>
			</dl>
			<dl>
				<dt>
					<label>기본/원</label>
				</dt>
				<dd>
					<input type="text" name="p_price1" value="${parkData['p_price1']}" class="form-control" style="width: 260px;" required="required">
				</dd>
			</dl> 
			<dl>
				<dt>
					<label>추가/분당</label>
				</dt>
				<dd>
					<input type="text" name="p_per2" value="${parkData['p_per2']}" class="form-control" style="width: 260px;" required="required">
				</dd>
			</dl>
			<dl>
				<dt>
					<label>추가/원</label>
				</dt>
				<dd>
					<input type="text" name="p_price2" value="${parkData['p_price2']}" class="form-control" style="width: 260px;" required="required">
				</dd>
			</dl>
			<dl>
				<dt>
					<label>기타 상세정보</label>
				</dt>
				<dd>
					<input type="text" name="p_etc" value="${parkData['p_etc']}" class="form-control" style="width: 594px;height: 80px;" required="required">
				</dd>
			</dl>
			<dl>
				<dt>
					<label>주차가능여부</label>
				</dt>
				<dd>
					<select name="p_state" class="form-control" style="width: 260px;">
						<option value="주차가능">주차가능</option>
						<option value="만차">만차</option>
						<option value="알수없음">알수없음</option>
					</select>
				</dd>
			</dl>
			<input type="submit" value="등록" class="btn btn-primary">
		</form> 
	</div>
	 <!-- footer -->
 <script type="text/javascript">
	$("select[name=p_type]").val("${parkData['p_type']}");
	$("select[name=p_state]").val("${parkData['p_state']}");
</script>
	<!-- end of footer -->
<!-- end of wrapper -->
</body>
</html>