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
import com.OMC.dtos.search.Search1ConDto;
import com.OMC.dtos.search.Search1Dto;

public class SearchAjaxServlet extends HttpServlet {

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
			
			int comYear = Integer.parseInt(request.getParameter("comYear"));
			System.out.println("1: comYear=  "+comYear);
			String comClass = request.getParameter("comClass");
			System.out.println("2: comClass=  "+comClass);
			String year = request.getParameter("year");
			System.out.println("3: year=  "+year);
			String smtSel = request.getParameter("smtSel");
			System.out.println("4: smtSel=  "+smtSel);
			String mojSel = request.getParameter("mojSel");
			System.out.println("5: mojSel=  "+mojSel);

			Search1ConDto cDto = new Search1ConDto(comYear,comClass,year,smtSel,mojSel);
			List<Search1Dto> lists = manager.getSearch1List(cDto);
			
			Map<String, List<Search1Dto>> map = new HashMap<String, List<Search1Dto>>();
			map.put("seardto", lists);
			JSONObject jsonObject = JSONObject.fromObject(map);
			System.out.println("6: "+jsonObject.toString());
			PrintWriter pr= response.getWriter();
			jsonObject.write(pr);
			
			
	}
}
