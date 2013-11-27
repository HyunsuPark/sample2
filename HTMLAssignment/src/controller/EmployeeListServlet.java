package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDao;
import entity.EmployeeEntity;

/**
 * Servlet implementation class EmployeeListServlet
 */
@WebServlet("/list")
public class EmployeeListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeListServlet() {
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
		response.setContentType("text/html;charset=utf-8");

		EmployeeDao edao = new EmployeeDao();
		ArrayList<EmployeeEntity> list = edao.selectAll();
		
		String div = request.getParameter("div");
		
		if("insert".equals(div)){
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			request.setAttribute("regi", "regi");
			rd.forward(request, response);
		}else{
			if(list != null)
			{
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				request.setAttribute("list", list);
				rd.forward(request, response);
			}
			else
			{
				response.sendRedirect("Error.html");
			}
		}
		
		
	}

}
