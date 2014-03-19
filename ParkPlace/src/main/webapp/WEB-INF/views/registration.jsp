<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
	<meta name="viewport" content="width=device-width, initial-scale=1, minimum-scale=1, maximum-scale=1, user-scalable=0" />
	<title>주차장등록</title>
	<link rel="shortcut icon" type="image/x-icon" href="${pageContext.request.contextPath}/resources/css/images/favicon.ico" />
	<link rel="stylesheet" href="${pageContext.request.contextPath}/resources/css/style.css" type="text/css" media="all" />
	<link href='http://fonts.googleapis.com/css?family=Raleway:400,900,800,700,600,500,300,200,100' rel='stylesheet' type='text/css'>
	
	<script src="${pageContext.request.contextPath}/resources/js/jquery-1.8.0.min.js" type="text/javascript"></script>
	<!--[if lt IE 9]>
		<script src="${pageContext.request.contextPath}/js/modernizr.custom.js"></script>
	<![endif]-->
	<script src="${pageContext.request.contextPath}/resources/js/jquery.carouFredSel-5.5.0-packed.js" type="text/javascript"></script>
	<script src="${pageContext.request.contextPath}/resources/js/functions.js" type="text/javascript"></script>
</head>
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
			<nav id="navigation">
				<a href="#" class="nav-btn">HOME<span></span></a>
				<ul>
					<li><a href="index.do">home</a></li>
					<li><a href="#">사업소개</a></li>
					<li><a href="registration.do">주차장등록</a></li>
					<li class="active"><a href="contact.do">제휴문의</a></li>
				</ul>
				<div class="cl">&nbsp;</div>
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
			<div id="footer">
				<div class="footer-nav">
					<ul>
						<li><a href="#">Home</a></li>
						<li><a href="#">About</a></li>
						<li><a href="#">Services</a></li>
						<li><a href="#">Projects</a></li>
						<li><a href="#">Solutions</a></li>
						<li><a href="#">Jobs</a></li>
						<li><a href="#">Blog</a></li>
						<li><a href="#">Contacts</a></li>
					</ul>
					<div class="cl">&nbsp;</div>
				</div>
				<p class="copy">&copy; Copyright 2012<span>|</span>Sitename. Design by <a href="http://chocotemplates.com" target="_blank">ChocoTemplates.com</a></p>
				<div class="cl">&nbsp;</div>
			</div>
			<!-- end of footer -->
		</div>
		<!-- end of container -->
	</div>
	<!-- end of shell -->
</div>
<!-- end of wrapper -->
</body>
</html>