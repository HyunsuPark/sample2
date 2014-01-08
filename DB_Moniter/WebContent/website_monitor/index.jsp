<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!-->
<html class="no-js">
<!--<![endif]-->
<head>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<title></title>
<meta name="description" content="">
<meta name="viewport" content="width=device-width">
<link rel="stylesheet" href="css/bootstrap.min.css">
<link rel="stylesheet" href="css/jquery-ui.css">
<link href="//netdna.bootstrapcdn.com/font-awesome/4.0.3/css/font-awesome.css" rel="stylesheet">
<style>
body {
	padding-top: 50px;
	padding-bottom: 20px;
}

/*             슬라이드 영역 css */
#slides {
	display: none
}

#slides .slidesjs-navigation {
	margin-top: 5px;
}

a.slidesjs-next,a.slidesjs-previous,a.slidesjs-play,a.slidesjs-stop {
	background-image: url(img/btns-next-prev.png);
	background-repeat: no-repeat;
	display: block;
	width: 12px;
	height: 18px;
	overflow: hidden;
	text-indent: -9999px;
	float: left;
	margin-right: 5px;
}

a.slidesjs-next {
	margin-right: 10px;
	background-position: -12px 0;
}

a:hover.slidesjs-next {
	background-position: -12px -18px;
}

a.slidesjs-previous {
	background-position: 0 0;
}

a:hover.slidesjs-previous {
	background-position: 0 -18px;
}

a.slidesjs-play {
	width: 15px;
	background-position: -25px 0;
}

a:hover.slidesjs-play {
	background-position: -25px -18px;
}

a.slidesjs-stop {
	width: 18px;
	background-position: -41px 0;
}

a:hover.slidesjs-stop {
	background-position: -41px -18px;
}

.slidesjs-pagination {
	margin: 7px 0 0;
	float: right;
	list-style: none;
}

.slidesjs-pagination li {
	float: left;
	margin: 0 1px;
}

.slidesjs-pagination li a {
	display: block;
	width: 13px;
	height: 0;
	padding-top: 13px;
	background-image: url(img/pagination.png);
	background-position: 0 0;
	float: left;
	overflow: hidden;
}

.slidesjs-pagination li a.active,.slidesjs-pagination li a:hover.active
	{
	background-position: 0 -13px
}

.slidesjs-pagination li a:hover {
	background-position: 0 -26px
}

#slides a:link,#slides a:visited {
	color: #333
}

#slides a:hover,#slides a:active {
	color: #9e2020
}

.navbar {
	overflow: hidden
}
</style>

<!-- 미디어쿼리 -->
<style>
#slides {
	display: none
}

.container {
	margin: 0 auto
}

/* For tablets & smart phones */
@media ( max-width : 767px) {
	body {
		padding-left: 20px;
		padding-right: 20px;
	}
	.container {
		width: auto
	}
}

/* For smartphones */
@media ( max-width : 480px) {
	.container {
		width: auto
	}
}

/* For smaller displays like laptops */
@media ( min-width : 768px) and (max-width: 979px) {
	.container {
		width: 724px
	}
}

/* For larger displays */
@media ( min-width : 1200px) {
	.container {
		width: 1170px
	}
}
</style>

<link rel="stylesheet" href="css/bootstrap-theme.min.css">
<link rel="stylesheet" href="css/main.css">

<script src="js/vendor/modernizr-2.6.2-respond-1.1.0.min.js"></script>	
</head>
<body>
	<!--[if lt IE 7]>
            <p class="chromeframe">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> or <a href="http://www.google.com/chromeframe/?redirect=true">activate Google Chrome Frame</a> to improve your experience.</p>
        <![endif]-->
	<div class="navbar navbar-inverse navbar-fixed-top">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target=".navbar-collapse">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#"><i class="fa fa-clock-o fa-1x"> Site Analysis</i></a>
			</div>
			<div class="navbar-collapse collapse">
				<ul class="nav navbar-nav">
					<li><a class="scroll" href="#about">About</a></li>
					<li><a class="scroll" href="#faq">F.A.Q</a></li>
				</ul>
				<form class="navbar-form navbar-right">
					<div class="form-group">
						<input type="email" placeholder="Email" class="form-control">
					</div>
					<div class="form-group">
						<input type="password" placeholder="Password" class="form-control">
					</div>
					<button id="loginBtn" type="button" class="btn btn-primary" onclick="start()" rel="popover" data-content="로그인에 실패하였습니다">Login</button>
						<!-- Button trigger modal -->
					<button class="btn btn-success btn" data-toggle="modal" data-target="#myModal">Sign in</button>
				</form>
			</div>
			<!--/.navbar-collapse -->
		</div>
	</div>

	<div class="container">
		<br>
		<div id="slides">
			<img src="img/example-slide-1.jpg"
				alt="Photo by: Missy S Link: http://www.flickr.com/photos/listenmissy/5087404401/">
			<img src="img/example-slide-2.jpg"
				alt="Photo by: Daniel Parks Link: http://www.flickr.com/photos/parksdh/5227623068/">
			<img src="img/example-slide-3.jpg"
				alt="Photo by: Mike Ranweiler Link: http://www.flickr.com/photos/27874907@N04/4833059991/">
			<img src="img/example-slide-4.jpg"
				alt="Photo by: Stuart SeegerLink: http://www.flickr.com/photos/stuseeger/97577796/">
		</div>
		
		<br>
		<h1 id="about">About</h1>
		<!-- Example row of columns -->
		<div class="row">
			<div class="col-lg-4">
				<h4 align="center"><i class="fa fa-bolt fa-5x"></i></h4>
				<p align="center">Monitor HTTP(s), Ping, Port and</p>
				<p align="center">check Keywords.</p>
			</div>
			<div class="col-lg-4">
				<h4 align="center"><i class="fa fa-envelope fa-5x"></i></h4>
				<p align="center">Get alerted via e-mail, SMS,</p> 
				<p align="center">Twitter or mobile push.</p>
			</div>
			<div class="col-lg-4">
				<h4 align="center"><i class="fa fa-signal fa-5x"></i></h4>
				<p align="center">View uptime, downtime and</p> 
				<p align="center">response times.</p>
			</div>
			<div class="col-lg-4">
				<h4 align="center"><i class="fa fa-bolt fa-5x"></i></h4>
				<p align="center">Monitor HTTP(s), Ping, Port and</p>
				<p align="center">check Keywords.</p>
			</div>
			<div class="col-lg-4">
				<h4 align="center"><i class="fa fa-envelope fa-5x"></i></h4>
				<p align="center">Get alerted via e-mail, SMS,</p> 
				<p align="center">Twitter or mobile push.</p>
			</div>
			<div class="col-lg-4">
				<h4 align="center"><i class="fa fa-signal fa-5x"></i></h4>
				<p align="center">View uptime, downtime and</p> 
				<p align="center">response times.</p>
			</div><div class="col-lg-4">
				<h4 align="center"><i class="fa fa-bolt fa-5x"></i></h4>
				<p align="center">Monitor HTTP(s), Ping, Port and</p>
				<p align="center">check Keywords.</p>
			</div>
			<div class="col-lg-4">
				<h4 align="center"><i class="fa fa-envelope fa-5x"></i></h4>
				<p align="center">Get alerted via e-mail, SMS,</p> 
				<p align="center">Twitter or mobile push.</p>
			</div>
			<div class="col-lg-4">
				<h4 align="center"><i class="fa fa-signal fa-5x"></i></h4>
				<p align="center">View uptime, downtime and</p> 
				<p align="center">response times.</p>
			</div>
		</div>
		
		<br>
		<!-- FAQ -->
		<h1 id="faq">F.A.Q</h1>
		<!-- Example row of columns -->
		<div class="row">
			<div class="col-lg-4">
				<h4 align="center"><i class="fa fa-bolt fa-5x"></i></h4>
				<p align="center">Monitor HTTP(s), Ping, Port and</p>
				<p align="center">check Keywords.</p>
			</div>
			<div class="col-lg-4">
				<h4 align="center"><i class="fa fa-envelope fa-5x"></i></h4>
				<p align="center">Get alerted via e-mail, SMS,</p> 
				<p align="center">Twitter or mobile push.</p>
			</div>
			<div class="col-lg-4">
				<h4 align="center"><i class="fa fa-signal fa-5x"></i></h4>
				<p align="center">View uptime, downtime and</p> 
				<p align="center">response times.</p>
			</div>
			<div class="col-lg-4">
				<h4 align="center"><i class="fa fa-bolt fa-5x"></i></h4>
				<p align="center">Monitor HTTP(s), Ping, Port and</p>
				<p align="center">check Keywords.</p>
			</div>
			<div class="col-lg-4">
				<h4 align="center"><i class="fa fa-envelope fa-5x"></i></h4>
				<p align="center">Get alerted via e-mail, SMS,</p> 
				<p align="center">Twitter or mobile push.</p>
			</div>
			<div class="col-lg-4">
				<h4 align="center"><i class="fa fa-signal fa-5x"></i></h4>
				<p align="center">View uptime, downtime and</p> 
				<p align="center">response times.</p>
			</div>
			<div class="col-lg-4">
				<h4 align="center"><i class="fa fa-bolt fa-5x"></i></h4>
				<p align="center">Monitor HTTP(s), Ping, Port and</p>
				<p align="center">check Keywords.</p>
			</div>
			<div class="col-lg-4">
				<h4 align="center"><i class="fa fa-envelope fa-5x"></i></h4>
				<p align="center">Get alerted via e-mail, SMS,</p> 
				<p align="center">Twitter or mobile push.</p>
			</div>
			<div class="col-lg-4">
				<h4 align="center"><i class="fa fa-signal fa-5x"></i></h4>
				<p align="center">View uptime, downtime and</p> 
				<p align="center">response times.</p>
			</div><div class="col-lg-4">
				<h4 align="center"><i class="fa fa-bolt fa-5x"></i></h4>
				<p align="center">Monitor HTTP(s), Ping, Port and</p>
				<p align="center">check Keywords.</p>
			</div>
			<div class="col-lg-4">
				<h4 align="center"><i class="fa fa-envelope fa-5x"></i></h4>
				<p align="center">Get alerted via e-mail, SMS,</p> 
				<p align="center">Twitter or mobile push.</p>
			</div>
			<div class="col-lg-4">
				<h4 align="center"><i class="fa fa-signal fa-5x"></i></h4>
				<p align="center">View uptime, downtime and</p> 
				<p align="center">response times.</p>
			</div>
		</div>
		

		<hr>
		
		<footer>
			<p>&copy; Company 2013</p>
		</footer>
	</div>
	<!-- /container -->
	<script
		src="//ajax.googleapis.com/ajax/libs/jquery/1.10.1/jquery.min.js"></script>
	<script>
		window.jQuery
				|| document
						.write('<script src="js/vendor/jquery-1.10.1.min.js"><\/script>')
	</script>

	<script src="js/vendor/bootstrap.min.js"></script>
	<script src="js/scroll.js"></script>
	<script src="js/main.js"></script>

	<script>
		var _gaq = [ [ '_setAccount', 'UA-XXXXX-X' ], [ '_trackPageview' ] ];
		(function(d, t) {
			var g = d.createElement(t), s = d.getElementsByTagName(t)[0];
			g.src = '//www.google-analytics.com/ga.js';
			s.parentNode.insertBefore(g, s)
		}(document, 'script'));
	</script>

	<!-- SlidesJS Required: Link to jquery.slides.js -->
	<script src="js/jquery.slides.min.js"></script>
	<!-- End SlidesJS Required -->
	<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.9.1/jquery-ui.min.js"></script>
	<script src="js/jquery.blockUI.js"></script>
	
	<!-- SlidesJS Required: Initialize SlidesJS with a jQuery doc ready -->
	<script>
		$(function() {
			$('#slides').slidesjs({
				width : 940,
				height : 400,
				play : {
					active : true,
					auto : true,
					interval : 4000,
					swap : true
				}
			});
		});
	</script>
	<!-- End SlidesJS Required -->

	<!-- Sign in 영역-->
	<div class="modal fade" id="myModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-hidden="true">&times;</button>
					<h4 class="modal-title" id="myModalLabel">Sign in</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" role="form">
						<div class="form-group">
							<label for="inputEmail3" class="col-sm-2 control-label">Email</label>
							<div class="col-sm-10">
								<input type="email" class="form-control" id="inputEmail3"
									placeholder="Email">
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label">Password</label>
							<div class="col-sm-10">
								<input type="password" class="form-control" id="inputPassword3"
									placeholder="Password">
							</div>
						</div>
						<div class="form-group">
							<label for="inputPassword3" class="col-sm-2 control-label">Confirm Password</label>
							<div class="col-sm-10">
								<input type="password" class="form-control" id="inputPassword3"
									placeholder="Confirm Password">
							</div>
						</div>
						<div class="form-group">
							<div class="col-sm-offset-2 col-sm-10">
								<button type="submit" class="btn btn-info">Sign in</button>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>
			<!-- /.modal-content -->
		</div>
		<!-- /.modal-dialog -->
	</div>
	<!-- /.modal -->
	<!-- Sign in 영역 끝-->

	<script type="text/javascript">
		function start() {
			$.blockUI({ message: '<h1><img src="img/ajax-loader.gif" /> Just a moment...</h1>' }); 
			$.ajax({
				url : "test",
				dataType : "json",
				type : "post", // post 또는 get
				data : {
					id : "test",
					
				}, // 호출할 url 에 있는 페이지로 넘길 파라메터
				success : function(result) {
					$("#progressbar").attr("style","display: ");
					var options = { to: { width: 200, height: 60 } };
					
					$(".row").effect( "explode", options, 1000, null );
					$("#about").effect( "explode", options, 1000, null );
					$("#faq").effect( "explode", options, 1000, null );
					$("#slides").effect( "explode", options, 1000, callback );
					function callback() {
						//5초뒤에 다음페이지로 이동
						setTimeout(function() {location.href="list.jsp";}, 3000);
				    };
				}
			});
		}
	</script>
</body>
</html>
