<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="common/js/vendor/jquery-1.10.1.min.js"></script>
<script type="text/javascript">

function start() {
	$.ajax({
	    url : "moni",
	    dataType : "html",
	    type : "post",  // post 또는 get
	    data : { time:$("#time").val()},   // 호출할 url 에 있는 페이지로 넘길 파라메터
	    success : function(result){
	        return;
	    }
	});
	alert("시작되었습니다.");
	$("#loading").attr("style","");
}

function stop() {
// 	$.ajax({
// 	    url : "moni?div=stop",
// 	    dataType : "html",
// 	    type : "post",  // post 또는 get
// 	    data : { },   // 호출할 url 에 있는 페이지로 넘길 파라메터
// 	    success : function(result){
// 	        return;
// 	    }
// 	});
// 	alert("중지되었습니다.");
// 	$("#loading").attr("style","display: none;");
}


</script>
</head>
<body>
모니터링 주기 <input type="text" id="time"> (초) <input type="button" value="시작" onclick="start()"> 

<input type="button" value="정지" onclick="stop()" >

<br><br><br>
<marquee scrollamount="7"><div id="loading" style="display: none;"><img  src="common/images/bugsbunny.gif" > 모니터링중....</div></marquee>

</body>
</html>