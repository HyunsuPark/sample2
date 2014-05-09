<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ include file="/WEB-INF/views/common/head.jsp" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%> 
<body>
<%@ include file="/WEB-INF/views/common/nav.jsp" %>
      <div class="container">
        <h3>주차장 리스트</h3>
        <div>total : ${pagingMap['total_record']}</div>
        <table class="table"> 
        	<tr>
        		<th>No</th>
        		<th>유형</th>
        		<th>이름</th>
        		<th>주소</th>
        		<th>운영시간</th>
        		<th>요금표</th>
        		<th>기본<br>분당&nbsp;원</th>
        		<th>추가<br>분당&nbsp;원</th>
        		<th>기타 상세정보</th>
        		<th>주차가능여부</th>
        		<th>삭제</th>
        	</tr>
        	<c:forEach var="result" items="${data}" varStatus="status">
        	<tr>
        		<td>${result.p_idx}</td>
        		<td>${result.p_type}</td>
        		<td>${result.p_name}</td>
        		<td>${result.p_address}</td>
        		<td>${result.p_time}</td>
        		<td>${result.p_pricetable}</td>
        		<td>${result.p_price1}&nbsp;${result.p_per1}</td>
        		<td>${result.p_price2}&nbsp;${result.p_per2}</td>
        		<td>${result.p_etc}</td>
        		<td>${result.p_state}</td>
        		<td><a class="btn btn-default" onclick="if(confirm('정말삭제하시겠습니까?')) location.href='parkingDel.do?idx=${result.p_idx}'">삭제</a></td>
        	</tr>
        	</c:forEach>
        </table>
        
        <a href="parkingList.do?pageNo=1">[맨앞으로]</a>
		<a href="parkingList.do?pageNo=${pagingMap['prev_pageno']}">[이전]</a> 
		<c:forEach var="i" begin="${pagingMap['page_sno']}" end="${pagingMap['page_eno']}" step="1" >    
        	<a href="parkingList.do?pageNo=${i}">${i} </a> 
		</c:forEach>
		<a href="parkingList.do?pageNo=${pagingMap['next_pageno']}" >[다음]</a>
		<a href="parkingList.do?pageNo=${pagingMap['total_page']}">[맨뒤로]</a>

      </div>
</body>
</html> 