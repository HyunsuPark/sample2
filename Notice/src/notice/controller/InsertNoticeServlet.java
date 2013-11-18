package notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import notice.model.dao.NoticeDao;
import notice.model.vo.Notice;
import member.model.dto.Member;

/**
 * Servlet implementation class InsertNoticeServlet
 */
@WebServlet("/insert")
public class InsertNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertNoticeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 글 추가 서비스용
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		//글쓴이의 아이디 추출
		HttpSession loginSession = request.getSession(false);
		Member loginMember = (Member)loginSession.getAttribute("user");
		String writer = loginMember.getMemberId();
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		Notice newNotice = new Notice();
		newNotice.setNoticeWriter(writer);
		newNotice.setNoticeTitle(title);
		newNotice.setNoticeContent(content);
		
		NoticeDao ndao = new NoticeDao();
		int result = ndao.insertRow(newNotice);
		
		if(result > 0)	//글쓰기 추가 성공시
		{
			response.sendRedirect("list");
		}else	//글 추가 실패시
		{
			response.sendRedirect("insertError.html");
		}
	}

}
