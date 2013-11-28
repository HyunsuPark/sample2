package board.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateViewServlet
 */
@WebServlet("/updateview")
public class UpdateViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateViewServlet() {
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
		// 수정하기 페이지 뷰 출력용 서블릿
		response.setContentType("text/html;charset=utf-8");
		
//		int no = Integer.parseInt(request.getParameter("no"));
//		
//		NoticeDao ndao = new NoticeDao();
//		Notice notice = ndao.selectRow(no);
//		
//		if(notice != null)
//		{
//			RequestDispatcher rd = request.getRequestDispatcher("updateView.jsp");
//			request.setAttribute("notice", notice);
//			rd.forward(request, response);
//		}else{
//			response.sendRedirect("datailError.html");
//		}
	}

}
