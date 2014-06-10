<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<!-- 
10보다 작은 자연수 중에서 3 또는 5의 배수는 3, 5, 6, 9 이고, 이것을 모두 더하면 23입니다.
1000보다 작은 자연수 중에서 3 또는 5의 배수를 모두 더하면 얼마일까요?
 -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>오일러 프로그램 Problem1</title>
<script type="text/javascript">
function setAdd() {
	var sum = 0;
	for(var i = 1; i < 1000; i ++) {
		if((i%3) == 0 || (i%5) == 0) {
			sum += i;
		}
	}
	alert("sum::" + sum);
}
</script>
</head>
<body>
<p>10보다 작은 자연수 중에서 3 또는 5의 배수는 3, 5, 6, 9 이고, 이것을 모두 더하면 23입니다.</p>
<p>1000보다 작은 자연수 중에서 3 또는 5의 배수를 모두 더하면 얼마일까요?</p>
<button onclick="setAdd();">확인</button>
</body>
</html>