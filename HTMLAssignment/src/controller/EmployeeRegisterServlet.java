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
 * Servlet implementation class EmployeeRegisterServlet
 */
@WebServlet("/register")
public class EmployeeRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeRegisterServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		String no = request.getParameter("no");
		String name = request.getParameter("name");
		String jik = request.getParameter("jik");
		String tel = request.getParameter("tel");
		String[] hobby = request.getParameterValues("hobby");
		String etc = request.getParameter("etc");
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = 0; i < hobby.length; i++)
		{
			sb.append(hobby[i]);
			sb.append(",");
		}
		if(sb.charAt(sb.length() -1) == ',')
			sb.deleteCharAt(sb.length() - 1);
			
		String hob = sb.toString();
		
		EmployeeEntity emp = new EmployeeEntity(no, name, jik, tel, hob, etc);
		EmployeeDao edao = new EmployeeDao();
		int result = edao.insertEmployee(emp);
		
		ArrayList<EmployeeEntity> list = edao.selectAll();
		if(list != null)
		{
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			request.setAttribute("list", list);
			rd.forward(request, response);
		}
		 
	}

}
