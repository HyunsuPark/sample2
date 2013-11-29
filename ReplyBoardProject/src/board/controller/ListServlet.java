package board.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.dao.BoardDao;
import board.model.vo.Board;

/**
 * Servlet implementation class ListServlet
 */
@WebServlet("/list")
public class ListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// a 태그나 form태그의 method=get 일때 
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 게시글 전체 조회 서비스 처리용 서블릿임
		//내보낼 값에 한글이 있을 경우, 문자 인코딩 처리
		response.setContentType("text/html;charset=utf-8");
		
		//비즈니스 로직을 처리할 모델 객체 생성하고
		BoardDao ndao = new BoardDao();
		//전체조회 처리용 메소드 실행함
		ArrayList<Board> list = ndao.selectAll();
			
		//리턴값을 가지고 뷰를 선택함.
		if(list != null)
		{
			RequestDispatcher rd = request.getRequestDispatcher("listView.jsp");
			request.setAttribute("list", list);
			rd.forward(request, response);
		}
		else
		{
			response.sendRedirect("errorPage.jsp");
		}
	}

}
