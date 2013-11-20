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
@WebServlet("/tupdate")
public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServlet() {
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
		String[] price = request.getParameterValues("price");
		
		ArrayList<HashMap> uList = new ArrayList<HashMap>();
		
		int result = 0;
		
		TravelDao tDao = new TravelDao();
		
		for (int i = 0; i < travel_code.length; i++) {
			if(price[i].equals("")) continue;
			result += tDao.listUpdate(travel_code[i], price[i]);
			HashMap<String,String> uMap = new HashMap<String,String>();
			uMap.put("code", travel_code[i]);
			uMap.put("price", price[i]);
			uList.add(uMap);
		}
		
		if(result > 0)
		{
			ArrayList<Travel> list = udtList(tDao, uList);
			
			RequestDispatcher rd = request.getRequestDispatcher("updateSuccess.jsp");
			request.setAttribute("list", list);
			rd.forward(request, response);
		}else{
			response.sendRedirect("fail.html");
		}
	}
	
	/**
	 * 업데이트내역
	 * @param tDao
	 * @param arrList
	 * @return
	 */
	private ArrayList<Travel> udtList(TravelDao tDao,ArrayList<HashMap> arrList){
		ArrayList list = new ArrayList();
		
		for (int i = 0; i < arrList.size(); i++) {
			Travel t = new Travel();
			t.setTravel_title(tDao.titleSearch((String)arrList.get(i).get("code")));
			t.setPrice((String)arrList.get(i).get("price"));
			
			list.add(t);
		}
		
		return list;
	}

}
