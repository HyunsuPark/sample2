package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EmployeeDao;
import entity.EmployeeEntity;

/**
 * Servlet implementation class EmployeeViewServlet
 */
@WebServlet("/view")
public class EmployeeViewServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeViewServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=utf-8");
		String no = request.getParameter("no");
		
		EmployeeDao ndao = new EmployeeDao();
		EmployeeEntity row = ndao.searchRow(no);
		
		if(row != null)
		{
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			request.setAttribute("row", row);
			rd.forward(request, response);
		}else{
			response.sendRedirect("Error.html");
		}
	}

}
