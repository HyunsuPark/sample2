package travel.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
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
@WebServlet("/tdelete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteServlet() {
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
		
		String[] travel_code = request.getParameterValues("travel_code");
		
		int result = 0;
		
		TravelDao tDao = new TravelDao();
		
		for (int i = 0; i < travel_code.length; i++) {
			result += tDao.listDelete(travel_code[i]);
		}
		
		if(result > 0)
		{
			ArrayList<Travel> list = tDao.listAll();
			
			RequestDispatcher rd = request.getRequestDispatcher("listDelete.jsp");
			request.setAttribute("list", list);
			rd.forward(request, response);
		}else{
			response.sendRedirect("fail.html");
		}
	}

}
