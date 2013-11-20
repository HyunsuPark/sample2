package travel.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import travel.model.dao.TravelDao;
import travel.model.vo.Travel;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/tupdateList")
public class SearchUdtServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchUdtServlet() {
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
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String loc =  request.getParameter("loc");
		
		TravelDao tDao = new TravelDao();
		
		ArrayList<Travel> list = null;
		
		if("".equals(loc) || loc == null){
			list = tDao.listAll();
		}else{
			list = tDao.listSearch(loc);
		}
		
		if(list != null)
		{
			RequestDispatcher rd = request.getRequestDispatcher("listUpdate.jsp");
			request.setAttribute("list", list);
			rd.forward(request, response);
		}else{
			response.sendRedirect("fail.html");
		}
	}

}
