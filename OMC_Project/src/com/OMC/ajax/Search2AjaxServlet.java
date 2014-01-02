package com.OMC.ajax;
//com.OMC.ajax.SearchAjaxServlet
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


import com.OMC.daos.SearchManager;

import com.OMC.dtos.search.Search2ConDto;
import com.OMC.dtos.search.Search2Dto;

public class Search2AjaxServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	public void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/json; charset=utf-8");
			
			SearchManager manager = new SearchManager();
			
			String bldCd = request.getParameter("bldCd");
			System.out.println("1: bldCd=  "+bldCd);
			String roomCd = request.getParameter("roomCd");
			System.out.println("2: roomCd=  "+roomCd);
			String year = request.getParameter("year");
			System.out.println("3: year=  "+year);
			String smtSel = request.getParameter("smtSel");
			System.out.println("4: smtSel=  "+smtSel);

			Search2ConDto cDto = new Search2ConDto(bldCd,roomCd,year,smtSel);
			List<Search2Dto> lists = manager.getSearch2List(cDto);
			
			Map<String, List<Search2Dto>> map = new HashMap<String, List<Search2Dto>>();
			map.put("sear2dto", lists);
			JSONObject jsonObject = JSONObject.fromObject(map);
			System.out.println("6: "+jsonObject.toString());
			PrintWriter pr= response.getWriter();
			jsonObject.write(pr);
			
			
	}
}
