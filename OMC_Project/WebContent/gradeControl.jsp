<%@page import="com.OMC.daos.GradeService"%>
<%@page import="com.OMC.daos.GradeManager"%>
<%@page import="com.OMC.dtos.LoginUserDto"%>
<%@page import="com.OMC.dtos.grade.GradeSumDto"%>
<%@page import="java.util.List"%>
<%@page import="com.OMC.dtos.grade.GradeDto"%>
<%@ page language="java" contentType="text/html; charset=utf-8" %>
<%@page import="org.apache.tiles.servlet.context.ServletUtil"%>
<%@page import="org.apache.tiles.TilesContainer"%>
<% request.setCharacterEncoding("utf-8"); %>

<body>
<%
String command = request.getParameter("command");
GradeService service = GradeService.getInstance();
Object obj = session.getAttribute("login"); 
LoginUserDto login = (LoginUserDto)obj;
if(command.equalsIgnoreCase("thisgrade")){
	String year=request.getParameter("year");
	String smt=request.getParameter("smt");
	String student_cd=request.getParameter("student_cd");
	
	List<GradeDto> lists = service.getGradeThis(new GradeDto(year,smt,student_cd));
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
	String smt  = lists.get(0).getSmt();
	String year = lists.get(0).getYear();
// 	List<GradeSumDto> sumlists = service.getSumAllGrade(new GradeSumDto(student_cd));
	request.setAttribute("lists",lists);
	request.setAttribute("smt",smt);
	request.setAttribute("year",year);
	request.setAttribute("student_cd",student_cd);
	pageContext.forward("./menu_control.jsp?command=allgrade");
}
%>
</body>
</html>