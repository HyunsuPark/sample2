package notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.model.dao.NoticeDao;
import notice.model.vo.Notice;

/**
 * Servlet implementation class UpdateNoticeServlet
 */
@WebServlet("/update")
public class UpdateNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateNoticeServlet() {
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
		// 글제목 또는 글내용 수정용 서블릿
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		int no = Integer.parseInt(request.getParameter("no"));
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		Notice updateNotice = new Notice();
		updateNotice.setNoticeNo(no);
		updateNotice.setNoticeWriter(writer);
		updateNotice.setNoticeTitle(title);
		updateNotice.setNoticeContent(content);
		
		NoticeDao ndao = new NoticeDao();
		int result = ndao.updateRow(updateNotice);
		
		if(result > 0)
		{
			response.sendRedirect("list");
		}else{
			response.sendRedirect("updateError.html");
		}
	}

}
