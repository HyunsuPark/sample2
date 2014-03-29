<%@ include file="/WEB-INF/views/common/head.jsp" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%> 
<body>
<%@ include file="/WEB-INF/views/common/nav.jsp" %>
 <!-- Main jumbotron for a primary marketing message or call to action -->
      <div class="container">
        <h1>등록 주차장 목록</h1>
        <table class="table">
        	<tr>
        		<th>#</th>
        		<th>주차장이름</th>
        		<th>대표/관리자</th>
        		<th>등록일</th>
        	</tr>
        	<c:forEach var="result" items="${data}" varStatus="status">
        	<tr>
        		<td>${status.count}</td>
        		<td><a href="detailView.do?seq=${result.seq}">${result.parking_name}</a></td>
        		<td>${result.owner}</td>
        		<td>${result.regdate}</td>
        	</tr>
        	</c:forEach>
        </table>
      </div>
</body>
</html> 