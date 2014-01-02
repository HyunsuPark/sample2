<%@ page language="java" contentType="text/html; charset=utf-8" %>
<% request.setCharacterEncoding("utf-8"); %>
<html>
<head>
<script type="text/javascript">
var Check = {
		// val 전체가 공백인지 체크
		chkValue: function (val) { var tmp = val.replace(/\s|　/gi, ''); if (tmp == '') { return false; } else { return true; } },

		// 콤마 처리
		setComma: function (val) {
		 var temp_str = String(val);
		for(var i = 0 , retvalue = String() , stop = temp_str.length; i < stop ; i++) {
		retvalue = ((i%3) == 0) && i != 0 ? temp_str.charAt((stop - i) -1) + "," + retvalue : temp_str.charAt((stop - i) -1) + retvalue; 
		}
		return retvalue; 
		},

		// 콤마 제거
		removeComma: function (n) { return str = parseInt(n.replace(/,/g, ""));}
		}

function back(){
	alert("이동합니다");
	location.href="./menu_control.jsp?command=main";
}
function submit_form(){
	var forms = document.forms[0];
	//Check.chkValue(forms.title.value) : 스트링의 공백을 체크 합니다.

	//Check.setComma(forms.title.value) : 숫자를 3자리 단위로 콤마를 처리 후 문자여로 리턴합니다.

	//Check.removeComma(forms.title.value) : 콤마처리된 문자를 콤마를 제거 합니다.

if(!Check.chkValue(forms.title.value)){
	alert("제목을 작성해 주세요");
}else if(!Check.chkValue(forms.content.value)){
	alert("내용을 작성해 주세요");
}else{
	forms.submit();
}
	
}
</script>
<title>Insert title here</title>
</head>
<body>
<form action="menu_control.jsp" method="post" name="frm">
<input type="hidden" name="command" value="addednotice">

	<table border="1" width="65%" >
		<tr>
			<td align="center">제목</td>
			<td><input name="title" maxlength="50" size="50" ></td>
		</tr>
		<tr >
			<td align="center">내용</td>
			<td><textarea name="content" cols="50" rows="20"></textarea></td>
		</tr>
		<tr>
			<td colspan="2"><input type="button" value="뒤로가기" onclick="back()">
			<input type="button" onclick="submit_form()"value="작성"></td>
		</tr>
	</table>
</form>
</body>
</html>