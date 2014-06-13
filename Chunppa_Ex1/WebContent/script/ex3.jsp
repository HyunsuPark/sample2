<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<!-- 
어떤 수를 소수의 곱으로만 나타내는 것을 소인수분해라 하고, 이 소수들을 그 수의 소인수라고 합니다.

예를 들면 13195의 소인수는 5, 7, 13, 29 입니다.

600851475143의 소인수 중에서 가장 큰 수를 구하세요.
 -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>오일러 프로그램 Problem3</title>

<script type="text/javascript">


function setAdd() {
	
	var inVal, sumVal ;
	
	for(var i = 0 ; i <= 13195; i++) {
		
	}
	
	document.getElementById("answer").innerHTML = "정답::" + sumVal;
}
</script>
</head>
<body>
<p>어떤 수를 소수의 곱으로만 나타내는 것을 소인수분해라 하고, 이 소수들을 그 수의 소인수라고 합니다.</p>
<p>예를 들면 13195의 소인수는 5, 7, 13, 29 입니다.</p>
<p>600851475143의 소인수 중에서 가장 큰 수를 구하세요.</p>
<p id="answer">정답은????</p>
<button onclick="setAdd();">확인</button>
</body>
</html>