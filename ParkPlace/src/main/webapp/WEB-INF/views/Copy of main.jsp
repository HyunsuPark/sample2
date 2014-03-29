<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%> 
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
				<h1><a href="main.html" style="text-decoration: none;"> ParkingPrice</a></h1>
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
			<!-- end of navigation -->
			<!-- slider-holder -->
			<div class="slider-holder">
				<!-- slider -->
				<div class="slider">
					<div class="socials">
						<a href="#" class="facebook-ico">facebook-ico</a>
						<a href="#" class="twitter-ico">twitter-ico</a>
						<a href="#" class="skype-ico">skype-ico</a>
						<a href="#" class="rss-ico">rss-ico</a>
						<div class="cl">&nbsp;</div>
					</div>

					<div class="arrs">
						<a href="#" class="prev-arr"></a>
						<a href="#" class="next-arr"></a>
					</div>

					<ul>
						<li id="img1">
							<div class="slide-cnt">
								<h4>주차할 땐</h4>
								<h2>주차프라이스</h2>
								<p>안드로이드 마켓과 티스토어에서 주차프라이스를 검색하면 더많고 저렴한 주차장을 찾으실 수 있습니다. <a href="#">read more</a></p>
							</div>
							<img src="<c:url value="/resources/css/images/logo.png" />" alt="" />
						</li>
						
						<li id="img2">
							<div class="slide-cnt">
								<h4>주차할 땐</h4>
								<h2>주차프라이스</h2>
								<p>안드로이드 마켓과 티스토어에서 주차프라이스를 검색하면 더많고 저렴한 주차장을 찾으실 수 있습니다. <a href="#">read more</a></p>
							</div>
							<img src="<c:url value="/resources/css/images/mac-img.png" />" alt="" />
						</li>

					</ul>
				</div>
				<!-- end of slider -->

				<!-- thumbs -->
				<div id="thumbs-wrapper">
					<div id="thumbs">
						<a href="#img1" class="selected"><img src="<c:url value="/resources/css/images/thumb.png" />"/></a>
						<a href="#img2"><img src="<c:url value="/resources/css/images/thumb2.png" />" /></a>
						<a href="#img3"><img src="<c:url value="/resources/css/images/thumb3.png" />" /></a>
						<a href="#img4"><img src="<c:url value="/resources/css/images/thumb4.png" />" /></a>
						<a href="#img5"><img src="<c:url value="/resources/css/images/thumb.png" />" /></a>
						<a href="#img6"><img src="<c:url value="/resources/css/images/thumb2.png" />" /></a>
						<a href="#img7"><img src="<c:url value="/resources/css/images/thumb3.png" />" /></a>
						<a href="#img8"><img src="<c:url value="/resources/css/images/thumb4.png" />" /></a>
					</div>
					<a id="prev" href="#"></a>
					<a id="next" href="#"></a>
				</div>
				<!-- end of thumbs -->
			</div>

			<!-- main -->
			<div class="main">

				<div class="featured">
					<h4>Welcome to <strong>Company Name.</strong> Start Creating Your Website Today completely for <strong>FREE!</strong></h4>
					<a href="#" class="blue-btn">GET IN TOUCH</a>
				</div>

				<section class="cols">
					<div class="col">
						<h3>About Us</h3>
						<h5>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</h5>
						<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus dui ipsum, cursus ut adipiscing porta, vestibulum quis turpis. Ut ultricies rutrum lorem, in blandit tortor congue pulvinar lorem ipsum dolor sit amet, consectetur adipiscing elit. <br /><a href="#" class="more">view more</a></p>
					</div>

					<div class="col">
						<h3>Weâre Hiring</h3>
						<img src="<c:url value="/resources/css/images/col-img.png" />" alt="" class="left"/>
						<h5>Lorem ipsum dolor sit amet, consectetur adipiscing elit. </h5>
						<div class="cl">&nbsp;</div>
						<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus dui ipsum, cursus ut adipiscing porta, vestibulum quis turpis adispicing amet sit. <br /><a href="#" class="more">view more</a></p>
					</div>

					<div class="col">
						<h3>Our Services</h3>
						<ul>
							<li><a href="#">Lorem ipsum dolor sit amet</a></li>
							<li><a href="#">Sit atmet, consectetur lorem </a></li>
							<li><a href="#">Consectetur adispicing dolor</a></li>
							<li><a href="#">Lipsuim dolor amet adpispicing</a></li>
							<li><a href="#">Lipsuim dolor amet adpispicing</a></li>
						</ul>
					</div>
					<div class="cl">&nbsp;</div>
				</section>

				<section class="entries">
					<div class="entry">
						<h3>Latest Blog Posts</h3>
						<div class="entry-inner">
							<div class="date">
								<strong>01</strong>
								<span>2012</span>
								<em>feb</em>
							</div>
							<div class="cnt">
								<p><a href="#">Lorem ipsum dolor sit<br /> amet, consectetur dor</a></p>
								<p class="meta"><a href="#">by John Doe </a> /  <a href="#">Category Name</a></p>
							</div>
						</div>
						<div class="entry-inner">
							<div class="date">
								<strong>28</strong>
								<span>2012</span>
								<em>jan</em>
							</div>
							<div class="cnt">
								<p><a href="#">Lorem ipsum dolor sit<br /> amet, consectetur dor</a></p>
								<p class="meta"><a href="#">by John Doe </a> /  <a href="#">Category Name</a></p>
							</div>
						</div>
						<div class="entry-inner">
							<div class="date">
								<strong>11</strong>
								<span>2012</span>
								<em>feb</em>
							</div>
							<div class="cnt">
								<p><a href="#">Lorem ipsum dolor sit<br /> amet, consectetur dor</a></p>
								<p class="meta"><a href="#">by John Doe </a> /  <a href="#">Category Name</a></p>
							</div>
						</div>
					</div>
					<div class="entry">
						<h3>Latest Project</h3>
						<h5>Lorem ipsum dolor sit amet, consectetur adipiscing elit. </h5>
						<a href="#"><img src="<c:url value="/resources/css/images/col-img2.png" />" alt="" /></a>
						<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus dui ipsum, cursus ut adipiscing porta, vestibulum quis turpis adispicing amet sit.  <br /><a href="#" class="more">view more</a></p>
					</div>
					<div class="entry">
						<h3>Testimonials</h3>

						<div class="testimonials">					
							<p><strong>â</strong>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vivamus dui ipsum, cursus ut adipiscing porta, vestibulum quis turpis.â</p>
							<p class="author">John Doe, <strong>Company Name</strong></p>
						</div>
						
						<div class="partners">
							<h3>Our Partners</h3>
							<img src="<c:url value="/resources/css/images/partners-img.png" />" alt="" />
						</div>
					</div>
					<div class="cl">&nbsp;</div>
				</section>
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