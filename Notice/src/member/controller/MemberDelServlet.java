package member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
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
@WebServlet("/mdelete")
public class MemberDelServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberDelServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException {
    	// TODO Auto-generated method stub
    	doPost(req, resp);
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
		String uid = request.getParameter("userid");
		
		//꺼낸 값들을 Member 객체에 저장함
		Member m = new Member(uid);
		
		//4. 회원정보 처리용 dao 클래스 객체 생성
		MemberDao mdao = new MemberDao();
		//5. 전송값 처리용 dao 메소드 실행하고, 결과값 받음
		int result = mdao.deleteMember(m);
		
		//6. 받은 결과로 성공/실패에 대한 화면(view) 파일을 선택
		if(result > 0)	//탈퇴 성공
		{
			RequestDispatcher rd = request.getRequestDispatcher("infoView.jsp");
			request.setAttribute("info", "del");
			rd.forward(request, response);
		}
		else	//탈퇴 실패
		{
			response.sendRedirect("insertFail.html");
		}
	}

}
