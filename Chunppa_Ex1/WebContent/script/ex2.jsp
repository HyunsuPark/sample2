<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<!-- 
피보나치 수열의 각 항은 바로 앞의 항 두 개를 더한 것이 됩니다. 1과 2로 시작하는 경우 이 수열은 아래와 같습니다.

1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...

짝수이면서 4백만 이하인 모든 항을 더하면 얼마가 됩니까?
 -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>오일러 프로그램 Problem2</title>

<script type="text/javascript">


function setAdd() {
	var num1=0, num2=0, num3=0, sumVal=0;
	var temp;
	
	num1 = 0;
	num2 = 1;
	
	while(num3 < 4000000) {
		
		num3 = num1 + num2;	
		if( (num3 % 2) == 0) {
			sumVal += num3;
		}
		
		num1 = num2;
		num2 = num3;
	}
	document.getElementById("answer").innerHTML = "정답::" + sumVal;
}
</script>
</head>
<body>
<p>피보나치 수열의 각 항은 바로 앞의 항 두 개를 더한 것이 됩니다. 1과 2로 시작하는 경우 이 수열은 아래와 같습니다.</p>
<p>1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...</p>
<p>짝수이면서 4백만 이하인 모든 항을 더하면 얼마가 됩니까?</p>
<p id="answer">정답은????</p>
<button onclick="setAdd();">확인</button>
</body>
</html>