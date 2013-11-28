<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글쓰기</title>
</head>
<body>

<jsp:include page="../menu.jsp" /> <%-- 절대경로 사용못함 --%>
	<hr/>
	<h1>게시판 글쓰기</h1>
	<hr/>
	<form action="/replyb/insertB" method="post" enctype="multipart/form-data">
	게시자 아이디 : 
	게시글 제목 : 
	게시글 내용 : 
	첨부파일올리기 : <input type="file" name="fileup"> <br/>
	<input type="submit" value="글올리기">
	<input type="reset" value="취소" onClick="document.replace('listB');">
	</form>
</body>
</html>