package notice.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import notice.model.dao.NoticeDao;

/**
 * Servlet implementation class DeleteNoticeServlet
 */
@WebServlet("/delete")
public class DeleteNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteNoticeServlet() {
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
		// 글 삭제용 서블릿
		response.setContentType("text/html;charset=utf-8");
		
		int no = Integer.parseInt(request.getParameter("no"));
		
		NoticeDao ndao = new NoticeDao();
		int result = ndao.deleteRow(no);
		
		if(result > 0)
		{
			response.sendRedirect("list");
		}else{
			response.sendRedirect("deleteError.html");
		}
	}

}
