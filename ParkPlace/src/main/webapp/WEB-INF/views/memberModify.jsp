<%@ include file="/WEB-INF/views/common/head.jsp" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%> 
<body>
<%@ include file="/WEB-INF/views/common/nav.jsp" %>
	<div class="container" >
		<header id="header">
			<h3>회원정보 수정</h3>
			<div class="cl">&nbsp;</div>
		</header>
		<form action="modifyMember.do" method="post">
			<input type="hidden" name="m_idx" value="${data['m_idx']}">	
			<dl>
				<dt>
					<label>아이디</label>
				</dt>
				<dd>
					${data['m_userid']}
				</dd>
			</dl>
			<dl>
				<dt>
					<label>1day-key</label>
				</dt>
				<dd>
					<input type="text" name="m_1daykey" value="${data['m_1daykey']}" class="form-control" style="width: 260px;" required="required">
				</dd>
			</dl>
			<dl>
				<dt>
					<label>7day-key</label>
				</dt>
				<dd>
					<input type="text" name="m_7daykey" value="${data['m_7daykey']}" class="form-control" style="width: 260px;" required="required">
				</dd>
			</dl>
			<dl>
				<dt>
					<label>30day-key</label>
				</dt>
				<dd>
					<input type="text" name="m_30daykey" value="${data['m_30daykey']}" class="form-control" style="width: 260px;" required="required">
				</dd>
			</dl>
			<dl>
				<dt>
					<label>Car-key(point)</label>
				</dt>
				<dd>
					<input type="text" name="m_point" value="${data['m_point']}" class="form-control" style="width: 260px;" required="required">
				</dd> 
			</dl>
			<input type="submit" value="등록" class="btn btn-primary">
		</form> 
	</div>
	 <!-- footer -->
	 <script type="text/javascript">
 		if("${param.save}"=="ok"){
 			alert("저장되었습니다.");
 		}
	 </script>
	<!-- end of footer -->
<!-- end of wrapper -->
</body>
</html>