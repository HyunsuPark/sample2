package board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.dao.BoardDao;
import board.model.vo.Board;

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
//		
		int idx = Integer.parseInt(request.getParameter("idx"));
		String subject = request.getParameter("subject");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		Board board = new Board();
		board.setIdx(idx);
		board.setSubject(subject);
		board.setWriter(writer);
		board.setContent(content);
		
		BoardDao ndao = new BoardDao();
		int result = ndao.updateRow(board);
		
		if(result > 0)
		{
			response.sendRedirect("detail?idx="+idx);
		}else{
			response.sendRedirect("errorPage.jsp");
		}
	}

}
