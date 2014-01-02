<%@page import="com.OMC.dtos.LoginUserDto"%>
<%@page import="com.OMC.dtos.lectureapply.CustUserDtos"%>
<%@page import="com.OMC.daos.ClassService"%>
<%@page import="java.lang.reflect.Array"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
</head>
<body>
<%
String command = request.getParameter("command");
ClassService service = ClassService.getInstance();
Object obj = session.getAttribute("login"); 
LoginUserDto login = (LoginUserDto)obj;
String student_cd=login.getStudent_cd();
if(command.equalsIgnoreCase("getall")){

	int student_year=Integer.parseInt( request.getParameter("student_year"));
	CustUserDtos dto=service.getCustUser(new CustUserDtos(student_cd));
	String dept_cd=dto.getDept_cd();
	List<CustUserDtos> lists=service.getAllList(new CustUserDtos(student_year,dept_cd));
	request.setAttribute("lists",lists);
	pageContext.forward("./menu_control.jsp?command=classapply");
	
}else if(command.equalsIgnoreCase("checked")){

	CustUserDtos student_info=service.getCustUser(new CustUserDtos(student_cd));
	CustUserDtos lec_info=new CustUserDtos();
	String dept_cd=student_info.getDept_cd();
	String com_year=request.getParameter("com_year");
	String[] curi_num2=request.getParameterValues("curi_num");
 	if(curi_num2==null ||curi_num2.length==0){
 	 	request.setAttribute("errm","err");
 			
 		}
	else{
	String[] curi_class=new String[curi_num2.length];
	String[][] curi=new String[curi_num2.length][2];
	
 
	for(int i=0;i<curi_num2.length;i++){
		
		curi[i][0]=curi_num2[i].substring(0,6);//curi_num
		curi[i][1]=curi_num2[i].substring(6);//curi_class
	
		curi_num2[i]=curi[i][0];
		curi_class[i]=curi[i][1];
	}
	System.out.println(curi_num2.length+"curinum2 길이");
	String[] curi_num3=curi_num2;
	List<String> curi_nm = new ArrayList<String>();

	CustUserDtos dto = new CustUserDtos();;
	CustUserDtos dto1=new CustUserDtos();
	for(int i=0; i<curi_num2.length;i++){
		//요기부분 수정
		dto= service.getOverlapCheck(new CustUserDtos(student_cd, curi_num2[i].trim(),curi_num3[i].trim()));
		int over_check =Integer.parseInt(dto.getOver_check());
		System.out.println(curi_num2[i]);
		System.out.println(curi_class[i]);
		dto1=service.getTimeCheck(student_cd,curi_num2[i],curi_class[i]);
		int time_check=Integer.parseInt(dto1.getTime_check());
		System.out.println("강아지");
		System.out.println(over_check);
		System.out.println(time_check);
	//요기동
	if(over_check==0&&time_check==0){
		
		lec_info=service.getLecInfo(new CustUserDtos(curi_num2[i],curi_class[i]));
		int cdt_num=lec_info.getCdt_num();
		String class_div=lec_info.getClass_div();
		String comdiv_cd=lec_info.getComdiv_cd();
		
		System.out.println(cdt_num);
		System.out.println(class_div);
		boolean isS = service.insertLecture(new CustUserDtos(student_cd,
		 		curi_num2[i],curi_class[i],dept_cd,com_year,cdt_num,class_div,comdiv_cd));
		}
	else{
		
		 lec_info=service.getLecInfo(new CustUserDtos(curi_num2[i],curi_class[i]));
		 System.out.println("ZZZZZZZZZZZ");
		 System.out.println(lec_info);
		  curi_nm.add(lec_info.getCuri_nm());
		  System.out.println(curi_nm);
	}
	
	}//여기동
	request.setAttribute("curi_nm",curi_nm);
	
 	}
	pageContext.forward("./menu_control.jsp?command=classapply");


}else if(command.equalsIgnoreCase("muldel")){
	String[] ids=request.getParameterValues("curi_nums");
	if(ids == null || ids.length==0){
		request.setAttribute("muldelerr","err");
		
	}
	else{
	 boolean isS= service.mulDelLecture(ids);
	}

		pageContext.forward("./menu_control.jsp?command=classapply");
	
}
%>

</body>
</html>