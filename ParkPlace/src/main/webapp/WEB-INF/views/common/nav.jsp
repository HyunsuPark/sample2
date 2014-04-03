<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%> 
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
  <!--[if lt IE 7]>
            <p class="browsehappy">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
        <![endif]-->
    <div class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="/">한국주차장협회</a>
        </div>
        <div class="navbar-collapse collapse">
        	<c:choose>
				<c:when test='${username == null || username == ""}'>
					<form class="navbar-form navbar-right" role="form"
						action="j_spring_security_check" method="post">
						<div class="form-group">
							<input type="text" placeholder="아이디" class="form-control"
								name="j_username" required="required">
						</div>
						<div class="form-group">
							<input type="password" placeholder="비밀번호" class="form-control"
								name="j_password" required="required">
						</div>
						<button type="submit" class="btn btn-danger">로그인</button>
						<button type="button" class="btn btn-primary" id="btnJoin">회원가입</button>
					</form>
				</c:when>
				<c:otherwise>
					<ul class="nav navbar-nav">
						<li><a href="registration.do"><span class="glyphicon glyphicon-hand-right"></span>&nbsp;주차장 등록</a></li>
						<li><a href="regiView.do"><span class="glyphicon glyphicon-hand-right"></span>&nbsp;등록 주차장 목록</a></li> 
					</ul>
					<form class="navbar-form navbar-right" role="form" action="j_spring_security_logout">
						<button type="button" class="btn btn-primary" style="width: 120px;"><c:out value="${username}"></c:out></button>
						<button type="submit" class="btn btn-danger" id="btnLogout">로그아웃</button>
					</form>
					
				</c:otherwise>
			</c:choose>
				
	       	
				
         
        </div><!--/.navbar-collapse -->
      </div>
    </div>