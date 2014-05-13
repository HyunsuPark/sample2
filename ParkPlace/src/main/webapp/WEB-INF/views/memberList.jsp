<%@ taglib uri="http://java.sun.com/jstl/fmt" prefix="fmt" %>
<%@ include file="/WEB-INF/views/common/head.jsp" %>
<%@ page pageEncoding="UTF-8" contentType="text/html; charset=UTF-8"%> 
<body>
<%@ include file="/WEB-INF/views/common/nav.jsp" %>
      <div class="container">
        <h3>회원 리스트</h3>
        <div>total : ${pagingMap['total_record']}</div>
        <table class="table">
        	<tr>
        		<th>No</th>
        		<th>ID</th>
        		<th>REGIST_DATE</th>
        		<th>1daykey</th>
        		<th>7daykey</th>
        		<th>30daykey</th>
        		<th>distance</th>
        		<th>point</th>
        		<th>code</th>
        		<th>phone</th>
        	</tr>
        	<c:forEach var="result" items="${data}" varStatus="status">
        	<tr style="cursor: pointer;" onclick="location.href='getMember.do?m_idx=${result.m_idx}'">
        		<td>${result.m_idx}</td>
        		<td>${result.m_userid}</td>
        		<td>${result.m_registdate}</td>
        		<td>${result.m_1daykey}</td>
        		<td>${result.m_7daykey}</td>
        		<td>${result.m_30daykey}</td>
        		<td>${result.m_distance}</td>
        		<td>${result.m_point}</td>
        		<td>${result.m_code}</td>
        		<td>${result.m_phone}</td>
        	</tr>
        	</c:forEach>
        </table>
        
        <a href="memberList.do?pageNo=1">[맨앞으로]</a>
		<a href="memberList.do?pageNo=${pagingMap['prev_pageno']}">[이전]</a> 
		<c:forEach var="i" begin="${pagingMap['page_sno']}" end="${pagingMap['page_eno']}" step="1" >    
        	<a href="memberList.do?pageNo=${i}">${i} </a> 
		</c:forEach>
		<a href="memberList.do?pageNo=${pagingMap['next_pageno']}" >[다음]</a>
		<a href="memberList.do?pageNo=${pagingMap['total_page']}">[맨뒤로]</a>

		<form action="searchMember.do">
			<input type="text" name="m_userid">
			<input type="submit" value="찾기">
		</form>
      </div>
</body>
</html> 