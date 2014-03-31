<%@ include file="/WEB-INF/views/common/head.jsp" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%> 
<body>
<script type="text/javascript">
function check() {
	var result = true;
	
	if($("#id").val().trim() == ""){
		alert("아이디를 입력해주세요");
		result = false;
	}else if($("#pass").val().trim() == ""){
		alert("비밀번호를 입력해주세요");
		result = false;
	}else if($("#pass2").val().trim() == ""){
		alert("비밀번호확인를 입력해주세요");
		result = false;
	}else if($("#email").val().trim() == ""){
		alert("이메일을 입력해주세요");
		result = false;
	}else if($("#pass").val() != $("#pass2").val()){
		alert("비밀번호가 다릅니다");
		result = false;
	}
	
	return result;
}
</script>
<%@ include file="/WEB-INF/views/common/nav.jsp" %>
<!-- wrapper -->
<div id="wrapper">
	<!-- shell -->
	<div class="shell">
		<!-- container -->
		<div class="container">
			<!-- header -->
			<header id="header">
				<h1>한국주차장협회 회원가입</h1>
				<div class="cl">&nbsp;</div>
			</header>
			<!-- end of header -->
			<!-- navigaation -->
			<!-- end of navigation -->
			<!-- main -->
			<div class="main">
				<form action="addUser.do" method="post" enctype="application/x-www-form-urlencoded">
					<dl>
						<dt>
							<label>아이디</label>
						</dt>
						<dd>
							<input type="text" id="id" name="id" class="form-control" style="width: 160px;" required="required" maxlength="20">
						</dd>
					</dl> 
					<dl>
						<dt>
							<label>비밀번호</label>
						</dt>
						<dd>
							<input type="password" id="pass" class="form-control" name="pass" style="width: 160px;" required="required" maxlength="20">
						</dd>
					</dl>
					<dl>
						<dt>
							<label>비밀번호확인</label>
						</dt>
						<dd>
							<input type="password" id="pass2" class="form-control" name="pass2" style="width: 160px;" required="required" maxlength="20">
						</dd>
					</dl>
					<dl>
						<dt>
							<label>이메일</label>
						</dt>
						<dd>
							<input type="email" id="email" name="email" class="form-control" style="width: 200px;" required="required">
						</dd>
					</dl>
					<input type="submit" onclick="return check()" id="addUser" value="회원가입" class="btn btn-primary">
				</form>	
			</div>
			<!-- end of main -->
			<div class="cl">&nbsp;</div>
			
			<!-- footer -->
			
			<!-- end of footer -->
		</div>
		<!-- end of container -->
	</div>
	<!-- end of shell -->
</div>
<!-- end of wrapper -->
</body>
</html>