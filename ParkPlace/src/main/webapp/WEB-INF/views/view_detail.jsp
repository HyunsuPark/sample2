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
        		<th width="300px">주차장명</th><td>${result.parking_name}</td>
        	</tr>
        	<tr>	
        		<th>대표/관리자</th><td>${result.owner}</td>
        	</tr>	
        	<tr>	
        		<th>전화번호</th><td>${result.phone}</td>
        	</tr>	
        	<tr>	
        		<th>주소</th><td>${result.addr}</td>
        	</tr>
        	<tr>	
        		<th>관리자 핸드폰</th><td>${result.owner_phone}</td>
        	</tr>
        	<tr>	
        		<th>주차장 형태</th><td>${result.parking_type}</td>
        	</tr>
        	<tr>	
        		<th>총 주차대수</th><td>${result.all_cnt}</td>
        	</tr>
        	<tr>	
        		<th>정기 주차대수</th><td>${result.avg_cnt}</td>
        	</tr>
        	<tr>	
        		<th>10분당 요금</th><td>${result.pay1}</td>
        	</tr>
        	<tr>	
        		<th>일일최대요금</th><td>${result.pay2}</td>
        	</tr>
        	<tr>	
        		<th>월정 정기요금</th><td>${result.pay3}</td>
        	</tr>
        	<tr>	
        		<th>여유 주차대수</th><td>${result.cnt1}</td>
        	</tr>
        	<tr>	
        		<th>부족 주차대수</th><td>${result.cnt2}</td>
        	</tr>
        	<tr>	
        		<th>P-Peck/Time</th><td>${result.time1}</td>
        	</tr>
        	<tr>	
        		<th>P-Lose/Time</th><td>${result.time2}</td>
        	</tr>
        	<tr>	
        		<th>할인방식</th><td>${result.dc_type}</td>
        	</tr>
        	<tr>	
        		<th>주차관제시스템</th><td>${result.system}</td>
        	</tr>
        	<tr>	
        		<th>회원 아이디</th><td>${result.id}</td>
        	</tr>
        	<tr>	
        		<th>등록일자</th><td>${result.regdate}</td>
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