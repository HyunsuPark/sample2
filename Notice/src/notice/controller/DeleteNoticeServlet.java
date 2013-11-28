package board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.dao.BoardDao;

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
		
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		BoardDao ndao = new BoardDao();
		int result = ndao.deleteRow(idx);
		
		if(result > 0)
		{
			response.sendRedirect("list");
		}else{
			response.sendRedirect("deleteError.html");
		}
	}

}
