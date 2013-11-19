package travel.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import travel.model.dao.TravelDao;
import travel.model.vo.Travel;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/tlist")
public class AllSearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AllSearchServlet() {
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
		// 로그인 처리용 서블릿
		response.setContentType("text/html;charset=utf-8");
		
		TravelDao tDao = new TravelDao();
		ArrayList<Travel> list = tDao.listAll();
		
		if(list != null)
		{
			HttpSession session = request.getSession();
			session.setAttribute("list", list);
			response.sendRedirect("listView.jsp");
		}else{
			response.sendRedirect("fail.html");
		}
	}

}
