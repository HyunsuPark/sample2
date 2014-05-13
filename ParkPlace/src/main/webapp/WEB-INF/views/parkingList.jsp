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
        		<th width="5%">유형</th>
        		<th width="15%">이름</th>
        		<th width="20%">주소</th>
        		<th width="4%">운영시간</th>
        		<th width="12%">요금표</th>
        		<th width="">기본<br>분당/원</th>
        		<th width="">추가<br>분당/원</th>
        		<th width="17%">기타 상세정보</th>
        		<th width="11%">주차가능여부</th>
        		<th width="">삭제</th>
        	</tr>
        	<c:forEach var="result" items="${data}" varStatus="status">
        	<tr style="cursor: pointer;" onclick="location.href='getParkRegi.do?p_idx=${result.p_idx}'">
        		<td>${result.p_idx}</td>
        		<td>${result.p_type}</td>
        		<td>${result.p_name}</td>
        		<td>${result.p_address}</td>
        		<td>${result.p_time}</td>
        		<td>${result.p_pricetable}</td>
        		<td>${result.p_price1}/${result.p_per1}</td>
        		<td>${result.p_price2}/${result.p_per2}</td>
        		<td>${result.p_etc}</td>
        		<td>${result.p_state}</td>
<%--         		<td><button onclick="if(confirm('정말삭제하시겠습니까?')) location.href='parkingDel.do?idx=${result.p_idx}'">삭제</button></td> --%>
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

		<form action="searchParking.do">
			<input type="text" name="p_name">
			<input type="submit" value="찾기">
		</form>
      </div>
</body>
</html> 