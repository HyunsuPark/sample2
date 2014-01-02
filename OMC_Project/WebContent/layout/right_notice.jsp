<%@page import="com.OMC.dtos.LoginUserDto"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<%@page import="java.util.List"%>
<%@page import="com.OMC.dtos.NoticeDto"%>
<%@page import="com.OMC.daos.OMCManager"%>
<%@ page language="java" contentType="text/html; charset=utf-8" %>
<% request.setCharacterEncoding("utf-8"); %>
<html>
<head>
<link rel='stylesheet' type='text/css' href='./css/omc.css'>
<%!
	SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm");
	String urls="menu_control.jsp";
%>
<% 
	Object objs = session.getAttribute("login"); 
	LoginUserDto login = (LoginUserDto)objs;
%>
<%
	//--------------페이지수 관련
	int startPage=1;     //시작 페이지
	int curPage=0;       //현재 페이지
	int curendPage=0;    //현재페이지의 끝
	int countPerPage=3;  //페이지당 글 수
	int totalCount=0;    //전체 글수
	int totalPage=0;     //전체 페이지수 = 전체 글수/페이지당 글 수
	//------------시작 페이지 구하기
	String sStartPage=request.getParameter("startPage");
	//System.out.println("startPage = "+sStartPage);
	if(sStartPage==null || sStartPage.equals("")){
		startPage=1;
	}else{
		startPage=Integer.parseInt(sStartPage);
	}
	//------------------------------
	OMCManager manager = new OMCManager();
	totalCount = manager.totalNotice();
	//------------- 한 블록에서 페이지에 보이기
	totalPage= (int)Math.ceil(totalCount*1.0/countPerPage);
	curPage=totalPage==1?1:(startPage-1)*countPerPage+1;
	curendPage=(totalPage!=startPage)?(startPage)*countPerPage:
	(totalCount%countPerPage==0?(startPage)*countPerPage:(curPage-1)+totalCount%countPerPage);
	//------------------------------------------------
	//NoticeDto dto = manager.getNotice(1);
	List<NoticeDto> lists = manager.getAllNotice(curPage,curendPage);
	
	NoticeDto dto = null;
	int seq=lists.get(0).getSeq(); //게시물 번호
	
	String obj = request.getParameter("seq");
	
	if(obj != null){
		seq = Integer.parseInt((String)obj);
		dto = manager.getNotice(seq);
		if(dto==null){
		seq = lists.get(0).getSeq();
		dto = manager.getNotice(seq);
		}
	}else{
		dto = manager.getNotice(seq);
	}
%>
<script type="text/javascript">
function del(seq){
	var r=confirm("삭제하시겠습니까?!");
	if (r==true)
	  {
	  location.href="./menu_control.jsp?command=delnotice&seq="+seq;
	  }
	else
	  {
	  
	  }
}
function update(seq){
	var r=confirm("수정하시겠습니까?!");
	if (r==true)
	  {
	  location.href="./menu_control.jsp?command=updatenotice&seq="+seq;
	  }
	else
	  {
	  
	  }
}
</script>
<title>공지사항</title>
</head>
<body>
<br>
<table border='0' width='85%' cellspacing='0' cellpadding="0" >
	<tr align="left">
		<th id='info'> |  공지사항</th>
	</tr>
	<tr>
	    	<td valign="bottom"><hr color="#8daad7" ></td>
	    </tr>
</table>
<p>
	<table border="0" width="70%" cellspacing='0' cellpadding='0' >
	    
		<tr>
			<td>
			<%if(obj!= null){ %>
			<table border="1" width="100%" cellspacing='0' cellpadding='0' bordercolor="#b4b3a1">
			<cols width='100'/>	
			<cols width='550'/>		
				<tr>
					<td id='info'>제목</td>
					<td id='content'><%=dto.getTitle() %></td>
				</tr>
				<tr>
					<td id='info'>작성자</td>
					<td id='content'><%=dto.getUserid() %></td>
				</tr>
				<tr>
					<td id='info'>작성일자</td>
					<td id='content'><%=sdf.format(dto.getRegi()) %></td>
				</tr>
				<tr>
					<td id='info' colspan="4" >내용</td>
				</tr>
				<tr>					
					<td id='content' colspan="4" height="100"><%=dto.getContent().replace("\r\n","<br>") %></td>
				</tr>
				<tr>
					<td colspan="4" align="right">
					<%if(login.getStudent_cd().equalsIgnoreCase(dto.getUserid())){ %>
					<input type="button" onclick="del(<%=dto.getSeq() %>)" value="삭제">
					<input type="button" onclick="update(<%=dto.getSeq() %>)" value="수정">
					<%} %>
					<a href="./menu_control.jsp?command=addnotice">작성하기</a></td>
				</tr>				
			</table>
			<%}else{ %>
				<table border="1" b width="100%" cellpadding="0" cellspacing="0" bordercolor="#b4b3a1">
				<cols width='100'/>	
				<cols width='550'/>	
					<tr>
						<td id='info'>제목</td>
						<td id='content' colspan='3'><%= lists.get(0).getTitle()%></td>
					</tr>
					<tr>
						<td id='info'>작성자</td>
						<td id='content'><%= lists.get(0).getUserid()%></td>
						<td id='info'>작성일자</td>
						<td id='content'><%= sdf.format(lists.get(0).getRegi()) %></td>
					</tr>
					<tr>
					<td id='info' colspan="4" >내용</td>
					</tr>
					<tr>						
						<td id='content' colspan="4" height="100"><%= lists.get(0).getContent().replace("\r\n","<br>") %></td>
					</tr>
					<tr>
						<td colspan="4" align="right">
						<%if(login.getStudent_cd().equalsIgnoreCase(dto.getUserid())){ %>
						<input type="button" onclick="del(<%=dto.getSeq() %>)" value="삭제">
						<input type="button" onclick="update(<%=dto.getSeq() %>)" value="수정">
						<%} %>
						<a href="./menu_control.jsp?command=addnotice">작성하기</a></td>
					</tr>				
			</table>
			<%} %>
			</td>
		</tr>
	</table>
	<br>
	
	<!-- 글 목록 보기 -->
	<table border="1" width="70%" align="center" cellpadding="0" cellspacing="0">
	<cols width='150' />
	<cols width='450' />
	<cols width='100' />
		<tr align="center">
			<td id='info'>번호</td>
			<td id='info'>제목</td>
			<td id='info'>날짜</td>
		</tr>
		<%for(NoticeDto udto : lists){ %>
		<tr align="center">
			<td id='list'><%=udto.getSeq() %></td>
			<td id='list'>
			<a href="./menu_control.jsp?command=main&seq=<%=udto.getSeq()%>&startPage=<%=startPage%>"><%=udto.getTitle() %></a></td>
			<td id='list'><%=sdf.format(udto.getRegi()) %></td>
		</tr>
		<%} %>
	</table>
	<br><br>
	<!-- 페이지 넘버 -->
	<table>
	<tr align="center">					
		<td id='list' colspan="3" align="center">
		<%
			for(int i=1;i<=totalPage;i++){
			//---현재 페이지에 따른 글 들 보이기---
			StringBuffer sb=new StringBuffer();
			sb.append("<a href='"+urls+"?command=main&seq="+seq+"&startPage=%d'>");
			if(i==totalPage){
				sb.append(" "+(i)+" ");
				sb.append("</a>");
			}else{
				sb.append((i));
				sb.append("</a>");
				sb.append("&nbsp;|&nbsp;");
			}
			
			String sss=String.format(sb.toString(),(i));
			%>
			<%=sss %>
				<%//sss는 스트링버퍼에서 넣은 %d에 숫자를 넣어주기위한 것
			}
			%>
			</td>
		</tr>
	</table>
	
</body>
</html>