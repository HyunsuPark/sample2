package member.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.dao.MemberDao;
import member.model.dto.Member;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 클라이언트가 보낸 로그인 정보를 받아서 처리함
		//request : 전달된 폼의 값을 받는 객체임
		//response : 서비스를 요청한 클라이언트정보를 받는 객체임
		
		//1. 문자 인코딩 처리
		//서비스 요청한 클라이언트쪽으로 내보낼 값에 한글이 있을 경우
		//response.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		//서블릿쪽으로 전달된 값에 한글이 포함되어 있을 경우
		request.setCharacterEncoding("utf-8");
		
		//2. 전달받은 값 꺼내기
		String uid = request.getParameter("user_id");
		String upwd = request.getParameter("user_pwd");
		
		//3. 로그인 처리용 dao클래스 객체 생성
		MemberDao mdao = new MemberDao();
		//4. dao클래스가 가진 로그인 처리용 메소드 실행함
		// 메소드에 아이디, 암호값 넘김 => 결과값 받음
		Member m = mdao.loginCheck(uid, upwd);
		
		PrintWriter out = response.getWriter();
		//5. 리턴된 결과를 가지고, 로그인 성공/실패 처리함
		if(m != null)	//조회한 회원정보가 있다면 로그인 성공 처리함
		{
			//로그인 상태관리를 위해서, 해당 클라이언트의 세션 객체 생성함
			HttpSession session = request.getSession();
			session.setAttribute("user", m);
			session.setMaxInactiveInterval(1800);   //5분
			//System.out.println("발급된 세션 ID : " + session.getId());
			
			response.sendRedirect("loginSuccess.jsp");
			/*out.print("<html><head><meta charset='utf-8'></head><body>");
			out.print("로그인 성공");
			out.print("<br/>" + m.getName() + " 님 환영합니다.<br/>");
			out.print("<br/>로그아웃<br/>");
			out.print("<br/><a href='index.html'>첫 페이지로 이동</a><br/>");
			out.print("</body></html>");*/
		}
		else	//조회한 회원정보가 없다면 로그인 실패 처리함
		{
			out.print("<html><head><meta charset='utf-8'></head><body>");
			out.print("로그인 실패 : 아이디 또는 암호 다시 확인");
			out.print("<br/><a href='index.html'>첫 페이지로 이동</a><br/>");
			out.print("<a href='login.html'>로그인 페이지로 이동</a><br/>");
			out.print("</body></html>");
		}
		/*
		out.print("<html><head><meta charset='utf-8'></head><body>");
		out.print("로그인 서비스 요청받음 ");
		out.print("<br/>전달받은 아이디 : " + uid + "<br/>");
		out.print("전달받은 암호 : " + upwd + "<br/>");
		out.print("</body></html>");*/
		out.close();
	}

}
