package member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import member.model.dao.MemberDao;
import member.model.dto.Member;

/**
 * Servlet implementation class MemberInServlet
 */
@WebServlet("/minsert")
public class MemberInServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberInServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 회원가입 처리용 서블릿
		//1. 전송되어 온 값에 한글이 있을 경우, 인코딩처리
		request.setCharacterEncoding("utf-8");
		//2. 서비스 요청자에게 내보낼 값에 한글이 있을 경우, MiMi type 지정
		response.setContentType("text/html;charset=utf-8");
		
		//3. 전송되어 온 값 꺼내기
		//하나의 이름에 한 개의 값이 전송된 경우
		String uid = request.getParameter("memberId");
		String uname = request.getParameter("name");
		String upwd = request.getParameter("password");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String marriage = request.getParameter("marriage");
		String pwdQuestion = request.getParameter("passwordQuestion");
		String pwdAnswer = request.getParameter("passwordAnswer");
		String etc = request.getParameter("etc");
		
		//하나의 이름으로 여러 개의 값이 전송되었을 경우
		String hobby[] = request.getParameterValues("hobby");
		//DB 테이블의 hobby 기록용 컬럼이 한 개일 때
		//문자열 배열을 하나의 문자열 값으로 합치지할 필요가 있음
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < hobby.length; i++)
		{
			sb.append(hobby[i]);
			sb.append(",");
		}
		//마지막에 붙은 ',' 는 제거함
		if(sb.charAt(sb.length() -1) == ',')
			sb.deleteCharAt(sb.length() - 1);
			
		String hob = sb.toString();
		//System.out.println(hob);
		
		//꺼낸 값들을 Member 객체에 저장함
		Member m = new Member(uid, uname, upwd, 
				address, phone, pwdQuestion, 
				pwdAnswer, marriage, hob, etc);
		
		//4. 회원정보 처리용 dao 클래스 객체 생성
		MemberDao mdao = new MemberDao();
		//5. 전송값 처리용 dao 메소드 실행하고, 결과값 받음
		int result = mdao.insertMember(m);
		
		//6. 받은 결과로 성공/실패에 대한 화면(view) 파일을 선택
		if(result > 0)	//회원가입 성공
		{
			response.sendRedirect("insertSuccess.html");
		}
		else	//회원가입 실패
		{
			response.sendRedirect("insertFail.html");
		}
	}

}
