package sample.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import sample.dao.SampleDao;

/**
 * Servlet implementation class sample
 */
@WebServlet("/board")
public class Sample extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Sample() {
        super();
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
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("title", "test");
		map.put("content", "test1222");
		
		SampleDao dao = new SampleDao();
		dao.insertData(map);
//		System.out.println(dao.getBoardCnt());
		
		ArrayList<HashMap<String, String>> list = dao.getBoard();
		System.out.println(list);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
		request.setAttribute("list", list);
		dispatcher.forward(request, response);
	}

}
