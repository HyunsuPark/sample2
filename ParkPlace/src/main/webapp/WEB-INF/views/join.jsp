<%@ include file="/WEB-INF/views/common/head.jsp" %>
<body>
<!-- wrapper -->
<div id="wrapper">
	<!-- shell -->
	<div class="shell">
		<!-- container -->
		<div class="container">
			<!-- header -->
			<header id="header">
				<h1><a href="#" style="text-decoration: none;">한국주차장협회 회원가입</a></h1>
				<!-- search -->
				<div class="search">
					<form action="" method="post">
						<input type="text" class="field" value="keywords here ..." title="keywords here ..." />
						<input type="submit" class="search-btn" value="" />
						<div class="cl">&nbsp;</div>
					</form>
				</div>
				<!-- end of search -->
				<div class="cl">&nbsp;</div>
			</header>
			<!-- end of header -->
			<!-- navigaation -->
			<%@ include file="/WEB-INF/views/common/menu.jsp" %>
			</nav>
			<!-- end of navigation -->
			<!-- main -->
			<div class="main">
				<form action="addUser.do" method="post" enctype="application/x-www-form-urlencoded">
					<dl>
						<dt>
							<label>아이디</label>
						</dt>
						<dd>
							<input type="text" name="id" style="width: 260px;" required="required">
						</dd>
					</dl>
					<dl>
						<dt>
							<label>비밀번호</label>
						</dt>
						<dd>
							<input type="password" name="pass" style="width: 260px;" required="required">
						</dd>
					</dl>
					<input type="submit" id="addUser" value="회원가입" style="width: 70px">
				</form>	
			</div>
			<!-- end of main -->
			<div class="cl">&nbsp;</div>
			
			<!-- footer -->
			<%@ include file="/WEB-INF/views/common/footer.jsp" %>
			<!-- end of footer -->
		</div>
		<!-- end of container -->
	</div>
	<!-- end of shell -->
</div>
<!-- end of wrapper -->
</body>
</html>