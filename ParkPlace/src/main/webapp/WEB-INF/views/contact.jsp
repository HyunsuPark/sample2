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
				<h1><a href="#" style="text-decoration: none;"> ParkingPrice</a></h1>
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
				<form action="" method="post">
					<dl>
						<dt>
							<label>Subject</label>
						</dt>
						<dd>
							<input type="text" name="subject" style="width: 260px;" required="required">
						</dd>
					</dl>
					<dl>
						<dt>
							<label>Phone</label>
						</dt>
						<dd>
							<input type="text" name="phone" style="width: 260px;" required="required">
						</dd>
					</dl>
					<dl>
						<dt>
							<label>Email</label>
						</dt>
						<dd>
							<input type="email" name="email" style="width: 260px;" required="required">
						</dd>
					</dl>
					<dl>
						<dt>
							<label>Question and Comment</label>
						</dt>
						<dd>
							<textarea rows="10" cols="100" name="question"></textarea>
						</dd>
					</dl>
					
					<input type="submit" value="Send" style="width: 70px">
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