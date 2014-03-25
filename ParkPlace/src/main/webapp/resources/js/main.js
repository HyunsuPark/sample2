$(document).ready(function() {
	// 회원가입 (멤버 추가);
	$("#addUser").click(function() { // click
//		if ($("#inputPassword2").val() != $("#inputPassword3").val()) {
//			alert("비밀번호가 일치하지 않습니다");
//			return false;
//		}
//		var regex=/^([\w-]+(?:\.[\w-]+)*)@((?:[\w-]+\.)*\w[\w-]{0,66})\.([a-z]{2,6}(?:\.[a-z]{2})?)$/; 
//		
//		if (!(regex.test($("#inputEmail3").val()))) {
//			alert("올바른 이메일 형식이 아닙니다.");
//			return false;
//		}
		
//		var formData = {
//			id : $("#id").val(),
//			password : $("#pass").val()
//		};
//		
//		$.ajax({
//			url : "addUser.do",
//			dataType : "text",
//			type : "post", // post 또는 get
//			headers: { 
//		        'Accept': 'application/json',
//		        'Content-Type': 'application/json' 
//		    },
//			data : JSON.stringify(formData) , // 호출할 url 에 있는 페이지로 넘길 파라메터
//			success : function(result) {
//				if(result == "ok"){
//					alert("회원가입되었습니다.");
//					location.href = "main.do";
//				}else{
//					alert("이미 가입된 회원입니다.");
//					return;
//				}
//			},
//			error : function (request,status,error) {
//				alert("code:"+request.status+"\n"+"message:"+request.responseText+"\n"+"error:"+error);
//			}
//		});
	});
});

