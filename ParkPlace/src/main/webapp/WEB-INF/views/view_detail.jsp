<%@ include file="/WEB-INF/views/common/head.jsp" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%> 
<body>
<%@ include file="/WEB-INF/views/common/nav.jsp" %>
 <!-- Main jumbotron for a primary marketing message or call to action -->
      <div class="container">
      
      	<h1>회원 주차장 정보</h1>
        <table class="table table-condensed">
        	<c:forEach var="result" items="${data}" varStatus="status">
        	<tr>
        		<th width="30%">주차장명</th><td><c:out value="${result.parking_name}"></c:out></td>
        	</tr>
        	<tr>	
        		<th>대표/관리자</th><td><c:out value="${result.owner}"></c:out></td>
        	</tr>	
        	<tr>	
        		<th>전화번호</th><td><c:out value="${result.phone}"></c:out></td>
        	</tr>	
        	<tr>	
        		<th>주소</th><td><c:out value="${result.addr}"></c:out></td>
        	</tr>
        	<tr>	
        		<th>관리자 핸드폰</th><td><c:out value="${result.owner_phone}"></c:out></td>
        	</tr>
        	<tr>	
        		<th>주차장 형태</th><td><c:out value="${result.parking_type}"></c:out></td>
        	</tr>
        	<tr>	
        		<th>총 주차대수</th><td><c:out value="${result.all_cnt}"></c:out></td>
        	</tr>
        	<tr>	
        		<th>정기 주차대수</th><td><c:out value="${result.avg_cnt}"></c:out></td>
        	</tr>
        	<tr>	
        		<th>10분당 요금</th><td><c:out value="${result.pay1}"></c:out></td>
        	</tr>
        	<tr>	
        		<th>일일최대요금</th><td><c:out value="${result.pay2}"></c:out></td>
        	</tr>
        	<tr>	
        		<th>월정 정기요금</th><td><c:out value="${result.pay3}"></c:out></td>
        	</tr>
        	<tr>	
        		<th>여유 주차대수</th><td><c:out value="${result.cnt1}"></c:out></td>
        	</tr>
        	<tr>	
        		<th>부족 주차대수</th><td><c:out value="${result.cnt2}"></c:out></td>
        	</tr>
        	<tr>	
        		<th>P-Peck/Time</th><td><c:out value="${result.time1}"></c:out></td>
        	</tr>
        	<tr>	
        		<th>P-Lose/Time</th><td><c:out value="${result.time2}"></c:out></td>
        	</tr>
        	<tr>	
        		<th>할인방식</th><td><c:out value="${result.dc_type}"></c:out></td>
        	</tr>
        	<tr>	
        		<th>주차관제시스템</th><td><c:out value="${result.system}"></c:out></td>
        	</tr>
        	<tr>	
        		<th>회원 아이디</th><td><c:out value="${result.id}"></c:out></td>
        	</tr>
        	<tr>	
        		<th>등록일자</th><td><c:out value="${result.regdate}"></c:out></td>
        	</tr>
        	<tr>	
        		<th>첨부이미지</th>
        		<td>
        			<c:if test="${result.file1 != null}">
        				<img src="file/${result.file1}" style="width: 75%;height: auto;">
        			</c:if>
        			<c:if test="${result.file2 != null}">
        				<img src="file/${result.file2}" style="width: 75%;height: auto;">
        			</c:if>
        			<c:if test="${result.file3 != null}">
        				<img src="file/${result.file3}" style="width: 75%;height: auto;">
        			</c:if>	
        		</td>
        	</tr>
        	</c:forEach>
        </table>
      </div>
</body>
</html> 