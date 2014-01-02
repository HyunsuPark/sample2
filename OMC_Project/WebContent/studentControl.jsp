<%@page import="com.sun.java.swing.plaf.windows.resources.windows"%>
<%@page import="com.OMC.dtos.grade.GradeDto"%>
<%@page import="java.util.List"%>
<%@page import="com.OMC.dtos.student.StudentDto"%>
<%@page import="com.OMC.dtos.LoginUserDto"%>
<%@page import="com.OMC.daos.StudentService"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>StudentControl</title>

</head>
<body>
<%	
		String command = request.getParameter("command");
		StudentService service = StudentService.getInstance();
		Object obj = session.getAttribute("login"); 
		LoginUserDto login = (LoginUserDto)obj;
		String student_cd = login.getStudent_cd();
		
		if(command.equalsIgnoreCase("stsearch")){

			System.out.println(student_cd);
			
			System.out.println("������");
			StudentDto sdto = service.getStudent(student_cd);
			StudentDto stu = service.getStudentTab1(student_cd); //tab1
			StudentDto pro = service.getStudentTab2(student_cd); //tab2
			
			List<StudentDto> sulist = service.getStudentTab4(student_cd); //tab4
			List<GradeDto> gList= service.getStudentTab5(new GradeDto(student_cd));//tab5
			
			request.setAttribute("sdto", sdto);
			request.setAttribute("stu", stu);
			request.setAttribute("pro", pro);
			request.setAttribute("sulist", sulist);
			request.setAttribute("gList", gList);
			pageContext.forward("./menu_control.jsp?command=stsearch");
			
		}else if(command.equalsIgnoreCase("stupdate")){
			
			
			System.out.println("stupdate ���Դ�.");
			System.out.println(student_cd);
			
			StudentDto stup = service.getStudent(student_cd);
			StudentDto stup2 = service.getStudentTab1(student_cd);			
			List<StudentDto> bklist = service.getBankList();
// 			System.out.println("zzzzzz");
// 			System.out.println(bklist.get(0));
			request.setAttribute("stup", stup);
			request.setAttribute("stup2", stup2);
			request.setAttribute("bklist", bklist);
			
			pageContext.forward("./menu_control.jsp?command=stupdate");
			
		}else if(command.equalsIgnoreCase("update")){
			
			String engNM = request.getParameter("engNM");
			String mPhone = request.getParameter("mPhone");
			String phone = request.getParameter("phone");
			String email = request.getParameter("email");
			//String zip = request.getParameter("zip");
			String addr1 = request.getParameter("addr1");
			String addr2 = request.getParameter("addr2");
			String bank = request.getParameter("bank"); //�����
			String bnNM = request.getParameter("bnNM"); // ������
			String bnNUM = request.getParameter("bnNUM"); 
			
			System.out.print(engNM);
			boolean isS = service.updateStudent(new StudentDto(phone, mPhone, email, addr1, addr2, bnNUM, bnNM, engNM, bank, student_cd));
			System.out.print("������");
// 			request.setAttribute("isS", isS);
			
			System.out.println(isS);
			if(isS){
				System.out.println("������Ʈ�� �����Ͽ����ϴ�.");
				StudentDto stup = service.getStudent(student_cd);
				StudentDto stup2 = service.getStudentTab1(student_cd);			
				List<StudentDto> bklist = service.getBankList();
				
				out.println("<javascript:alert('���� ������ �Ϸ�Ǿ����ϴ�.');/>");
				
				request.setAttribute("stup", stup);
				request.setAttribute("stup2", stup2);
				request.setAttribute("bklist", bklist);
				pageContext.forward("./menu_control.jsp?command=stupdate");
			}else{
				System.out.println("������Ʈ�� �����Ͽ����ϴ�.");
				out.println("<script>alert('���� ������ �����Ͽ����ϴ�.');</script>");
				response.sendRedirect("./menu_control.jsp?command=stupdate");
			}
		}		
		 
%>
</body>
</html>