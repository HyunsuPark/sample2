package sample.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

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
       
	private static Logger logger = Logger.getLogger("sample.controller.Sample");
	
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
		HashMap<String, String> oMap = new HashMap<String, String>();
		oMap.put("title", "test");
		oMap.put("content", "test1222");
		
		SampleDao oDao = new SampleDao();
		oDao.insertData(oMap);
		
		ArrayList<HashMap<String, String>> list = oDao.getBoard();
		logger.log(Level.INFO,"데이터 추가!");
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("list.jsp");
		request.setAttribute("list", list);
		dispatcher.forward(request, response);
	}

}
