package board.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.dao.BoardDao;
import board.model.vo.Board;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class InsertNoticeServlet
 */
@WebServlet("/reply")
public class ReplyNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReplyNoticeServlet() {
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
		
		String view = request.getParameter("view");
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		if("ok".equals(view)){
			BoardDao ndao = new BoardDao();
			Board row = ndao.selectRow(idx);
			
			if(row != null)	//글쓰기 추가 성공시
			{
				RequestDispatcher rd = request.getRequestDispatcher("reply.jsp");
				request.setAttribute("row", row);
				rd.forward(request, response);
			} 
		}else{
			String writer = request.getParameter("writer");
			String pwd = request.getParameter("pwd");
			String subject = request.getParameter("subject");
			String content = request.getParameter("content");
			int lev = Integer.parseInt(request.getParameter("lev"));
			
			///////////////////////////////////////////////////////////////////////
			Board board = new Board();
			
			board.setWriter(writer);
			board.setPwd(pwd);
			board.setSubject(subject);
			board.setContent(content);
			
			BoardDao ndao = new BoardDao();
			int result = ndao.insertReply(board, idx, lev);
			
			if(result > 0)	//글쓰기 추가 성공시
			{
				response.sendRedirect("list");
			}else	//글 추가 실패시
			{
				response.sendRedirect("insertError.html");
			}
		}
		
	}

}
