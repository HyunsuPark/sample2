package board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.dao.BoardDao;
import board.model.vo.Board;

/**
 * Servlet implementation class DetailServlet
 */
@WebServlet("/detail")
public class DetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 게시글 목록에서 글제목 클릭시 상세보기 처리용
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 게시글 상세보기는 전송된 글번호를 가지고
		//dao에서 db로가서 해당글에대한 행을 조회해 옴
		//이 행의 정보를 뷰에 출력시킴
		response.setContentType("text/html;charset=utf-8");
		
		//전송값 꺼내기
		int idx = Integer.parseInt(request.getParameter("idx"));
		
		//dao 객체 생성하고, 메소드 실행하고, 반환값 받음
		BoardDao ndao = new BoardDao();
		ndao.updateReadNum(idx); //조회수 증가
		Board row = ndao.selectRow(idx);
		
		String uploadFolder = "fileUpload";
		String filePath = uploadFolder+"/"+row.getFilename();
		
		if(row != null)
		{
			RequestDispatcher rd = request.getRequestDispatcher("detailView.jsp");
			request.setAttribute("row", row);
			request.setAttribute("filePath", filePath);
			rd.forward(request, response);
		}else{
			response.sendRedirect("errorPage.jsp");
		}
	}

}
