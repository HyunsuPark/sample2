<%@page import="com.OMC.dtos.NoticeDto"%>
<%@page import="com.OMC.daos.OMCService"%>
<%@page import="com.OMC.daos.OMCManager"%>
<%@page import="com.OMC.dtos.LoginUserDto"%>
<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@page import="org.apache.tiles.servlet.context.ServletUtil"%>
<%@page import="org.apache.tiles.TilesContainer"%>
<% request.setCharacterEncoding("utf-8"); %>
<%!
public void tilesGO(String tname,HttpServletRequest request,HttpServletResponse response){
	TilesContainer container = ServletUtil.getContainer(
	        request.getSession().getServletContext());
	container.render(tname, request, response);	
}
private boolean isNull(String str){
	return str==null || str.trim().equals("");
}//
%>
<body>
<%
//OMCManager manager = new OMCManager();
String command = request.getParameter("command");

if(command.equalsIgnoreCase("login")){
	OMCService manager = OMCService.getInstance();
	String id=request.getParameter("id");
	String password=request.getParameter("password");
	LoginUserDto login = new LoginUserDto(id.trim(),password.trim());
	if(isNull(id) ||isNull(password) ){
		out.println("<script>alert('오류발생1!!');</script>");
		response.sendRedirect("index.jsp");
		//errGo("아이디와 패스워드를 입력하셔야 합니다.","boardcontrol.jsp?command=index",request,response);
	}else{//if
		LoginUserDto udto = manager.getUserLogin(login);
		System.out.println("line35 = "+udto.getStudent_cd());
		if(udto !=null && udto.getStudent_cd().equalsIgnoreCase(id)){
			session.setAttribute("login",udto);
			tilesGO("login",request,response);
		}else{
			
			session.invalidate();//세션 완전삭제
			out.println("<script>alert('비밀번호 또는 암호가 틀립니다!!');history.back();</script>");
			//response.sendRedirect("index.jsp");
			//errGo("로그인 실패 다시 아이디 확인후 다시 로그인해주세요.","boardcontrol.jsp?command=index",request,response);
		}
	}
}else if(command.equalsIgnoreCase("logout")){
	session.invalidate();//세션 완전삭제
	response.sendRedirect("index.jsp");
}else if(command.equalsIgnoreCase("addnotice")){
	tilesGO("addnotice",request,response);
}else if(command.equalsIgnoreCase("addednotice")){
	Object obj = session.getAttribute("login"); 
	LoginUserDto login = (LoginUserDto)obj;
	
	OMCService manager = OMCService.getInstance();
	String title=request.getParameter("title");
	String content=request.getParameter("content");
	boolean isS=manager.addNotice(new NoticeDto(login.getStudent_cd(),title,content));
	if(isS){
		System.out.print("작성 성공");
		tilesGO("main",request,response);
	}else{
		System.out.print("작성 실패");
		tilesGO("main",request,response);
	}
}else if(command.equalsIgnoreCase("delnotice")){
	OMCService manager = OMCService.getInstance();
	String seq=request.getParameter("seq");
	boolean isS=manager.delNotice(Integer.parseInt(seq));
	if(isS){		
		System.out.print("삭제 성공");
		tilesGO("main",request,response);
	}else{
		System.out.print("삭제 실패");
		tilesGO("main",request,response);
	}
}else if(command.equalsIgnoreCase("updatenotice")){
	tilesGO("updatenotice",request,response);
}else if(command.equalsIgnoreCase("updatednotice")){
	Object obj = session.getAttribute("login"); 
	LoginUserDto login = (LoginUserDto)obj;
	
	OMCService manager = OMCService.getInstance();
	String title=request.getParameter("title");
	String content=request.getParameter("content");
	String seq=request.getParameter("seq");
	System.out.println(seq);
	boolean isS=manager.setNotice(new NoticeDto(Integer.parseInt(seq),title,content));
	if(isS){
		System.out.print("작성 성공");
		tilesGO("main",request,response);
	}else{
		System.out.print("작성 실패");
		tilesGO("main",request,response);
	}
	tilesGO("main",request,response);
}else if(command.equalsIgnoreCase("main")){
	tilesGO("main",request,response);
}else if(command.equalsIgnoreCase("haksa")){
	tilesGO("haksa",request,response);
}else if(command.equalsIgnoreCase("class")){
	tilesGO("class",request,response);
}else if(command.equalsIgnoreCase("thisgrade")){
	tilesGO("thisgrade",request,response);
}else if(command.equalsIgnoreCase("allgrade")){
	tilesGO("allgrade",request,response);
}else if(command.equalsIgnoreCase("stsearch")){
	tilesGO("stsearch",request,response);
}else if(command.equalsIgnoreCase("stupdate")){
	tilesGO("stupdate",request,response);
}else if(command.equalsIgnoreCase("stapply")){
	tilesGO("stapply",request,response);
}else if(command.equalsIgnoreCase("classapply")){
	tilesGO("classapply",request,response);
}else if(command.equalsIgnoreCase("classapplysearch")){
	tilesGO("classapplysearch",request,response);
}else if(command.equalsIgnoreCase("studentschedule")){
	tilesGO("studentschedule",request,response);
}else if(command.equalsIgnoreCase("timetable1")){
	tilesGO("timetable1",request,response);
}else if(command.equalsIgnoreCase("timetable2")){
	tilesGO("timetable2",request,response);
}else if(command.equalsIgnoreCase("timetable3")){
	tilesGO("timetable3",request,response);
}else if(command.equalsIgnoreCase("lecsearch")){
	tilesGO("lecsearch",request,response);
}else if(command.equalsIgnoreCase("leccommit")){
	tilesGO("leccommit",request,response);
}

/* 
OMCService service = OMCService.getInstance("grade");
//GradeManager service = new GradeManager();
Object obj = session.getAttribute("login"); 
LoginUserDto login = (LoginUserDto)obj;
if(command.equalsIgnoreCase("thisgrade")){
	String year=request.getParameter("year");
	String smt=request.getParameter("smt");
	String student_cd=request.getParameter("student_cd");
	
	System.out.println("thisgrade="+smt);
	System.out.println("thisgrade="+student_cd);
	System.out.println("thisgrade="+year);
	
	List<GradeDto> lists = service.getGradeThis(new GradeDto(year,smt,student_cd));
	System.out.print(lists.get(0));
// 	List<GradeSumDto> sumlists = service.getSumThisGrade(new GradeSumDto(year,smt,student_cd));
	request.setAttribute("lists",lists);
// 	request.setAttribute("sumlists",sumlists);
	request.setAttribute("year",year);
	request.setAttribute("smt",smt);
	request.setAttribute("student_cd",student_cd);
	pageContext.forward("./menu_control.jsp?command=thisgrade");
}else if(command.equalsIgnoreCase("allgrade")){
	String student_cd=login.getStudent_cd();
	
	System.out.println("allgrade="+login.getStudent_cd());
	
	List<GradeDto> lists = service.getGradeAll(new GradeDto(student_cd));
	System.out.print(lists.get(0));
	String smt  = lists.get(0).getSmt();
	String year = lists.get(0).getYear();
// 	List<GradeSumDto> sumlists = service.getSumAllGrade(new GradeSumDto(student_cd));
	request.setAttribute("lists",lists);
	request.setAttribute("smt",smt);
	request.setAttribute("year",year);
	request.setAttribute("student_cd",student_cd);
	pageContext.forward("./menu_control.jsp?command=allgrade");
} */
%>
</body>
</html>