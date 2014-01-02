package com.OMC.dtos.search.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.OMC.daos.OMCManager;
import com.OMC.daos.SearchManager;
import com.OMC.dtos.search.LecturePlanDto;

/**
 * Servlet implementation class LecturePlanAjaxServlet1
 */
public class LecturePlanAjaxServlet1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	  public void doPost(HttpServletRequest request,
	    	HttpServletResponse response) throws ServletException, IOException {
	    	request.setCharacterEncoding("utf-8");
	    	response.setContentType("text/json; charset=euc-kr");
	    	SearchManager manager=new SearchManager();
			List<LecturePlanDto> lists = manager.getLecturePlan1();
			Map<String, List<LecturePlanDto>> map = new HashMap<String, List<LecturePlanDto>>();
			map.put("plandto", lists);
			JSONObject jsonObject = JSONObject.fromObject(map);
			System.out.println("3: "+jsonObject.toString());
			PrintWriter pr= response.getWriter();
			jsonObject.write(pr);
		}

}
