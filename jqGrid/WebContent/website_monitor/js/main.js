function start() {
	$.blockUI({
		message : '<h1><img src="img/ajax-loader.gif" /> Just a moment...</h1>'
	});
	$.ajax({
		url : "test",
		dataType : "json",
		type : "post", // post 또는 get
		data : {
			id : "test",
			
		}, // 호출할 url 에 있는 페이지로 넘길 파라메터
		success : function(result) {
			$("#progressbar").attr("style", "display: ");
			var options = {
				to : {
					width : 200,
					height : 60
				}
			};

			$(".row").effect("explode", options, 1000, null);
			$("#about").effect("explode", options, 1000, null);
			$("#faq").effect("explode", options, 1000, null);
			$("#slides").effect("explode", options, 1000, callback);
			function callback() {
				// 5초뒤에 다음페이지로 이동
				setTimeout(function() {
					location.href = "list.jsp";
				}, 3000);
			};
		}
	});
}