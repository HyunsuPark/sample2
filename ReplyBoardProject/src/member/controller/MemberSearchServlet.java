package member.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import member.model.dao.MemberDao;
import member.model.dto.Member;

/**
 * Servlet implementation class MemberSearchServlet
 */
@WebServlet("/msearch")
public class MemberSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberSearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 회원정보 검색용 서블릿 => 수정페이지로 넘김
		//1. 인코딩
		response.setContentType("text/html;charset=utf-8");
		
		//2. 전송값 꺼내기
		String uid = request.getParameter("uid");
		
		//3. dao 로 넘김
		MemberDao mdao = new MemberDao();
		Member m = mdao.selectMember(uid);
		System.out.println("m : " + m);
		//4. 연결페이지에서 사용할 수 있게 사용자 정보를 저장함
		HttpSession session = request.getSession(false);
		session.setAttribute("member", m);
		
		//5. 연결페이지로 넘김
		response.sendRedirect("updateMember.jsp");
	}

}
