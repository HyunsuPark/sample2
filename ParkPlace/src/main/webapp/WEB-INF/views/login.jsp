<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE HTML>
<html>
<head>
<title>한국주차장 관리협회 로그인</title>
<meta charset="UTF-8" />
<meta name="Designer" content="PremiumPixels.com">
<meta name="Author" content="$hekh@r d-Ziner, CSSJUNTION.com">
<link rel="stylesheet" href="<c:url value="/resources/css/reset.css" />" type="text/css" media="all" />
<link rel="stylesheet" href="<c:url value="/resources/css/structure.css" />" type="text/css" media="all" />
</head>

<body>
<header>
</header>
<form class="box login" action="j_spring_security_check" method="post">
	<fieldset class="boxBody">
	  <label>아이디
	  <a href="#" class="rLink" tabindex="5">비밀번호찾기</a>
	  <a href="join.do" class="rLink" tabindex="5">회원가입</a>
	  </label>
	  <input type="text" name="j_username" tabindex="1" required>
	  <label>
	  비밀번호</label>
	  <input type="password" name="j_password" tabindex="2" required>
	</fieldset>
	<footer>
	  <label><input type="checkbox" tabindex="3">아이디기억</label>
	  <input type="submit" class="btnLogin" value="로그인" tabindex="4">
	</footer>
</form>
<footer id="main">
  <a href="http://wwww.cssjunction.com">Simple Login Form (HTML5/CSS3 Coded) by CSS Junction</a> | <a href="http://www.premiumpixels.com">PSD by Premium Pixels</a>
</footer>
</body>
</html>
