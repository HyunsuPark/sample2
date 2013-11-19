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
@WebServlet("/tinsert")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertServlet() {
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
		
		String travel_code = request.getParameter("travel_code");
		String location = request.getParameter("location");
		String travel_title = request.getParameter("travel_title");
		String departure_date = request.getParameter("departure_date");
		String return_date = request.getParameter("return_date");
		String price = request.getParameter("price");
		String airline = request.getParameter("airline");
		
		TravelDao tDao = new TravelDao();
		int result = tDao.listInsert(new Travel(travel_code, location, travel_title, departure_date, return_date, price, airline));
		
		ArrayList<Travel> list = tDao.listAll();
		
		if(result > 0)
		{
			HttpSession session = request.getSession();
			session.setAttribute("list", list);
			response.sendRedirect("listView.jsp");
		}else{
			response.sendRedirect("fail.html");
		}
	}

}
