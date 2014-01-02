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

import com.OMC.daos.SearchManager;
import com.OMC.dtos.search.LecturePlanDto;

/**
 * Servlet implementation class LecturePlanAjaxServlet2
 */
public class LecturePlanAjaxServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LecturePlanAjaxServlet2() {
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
		request.setCharacterEncoding("utf-8");
    	response.setContentType("text/json; charset=euc-kr");
    	SearchManager manager=new SearchManager();
		String curi_num1=request.getParameter("curi_num1").trim();
		String curi_nm1=request.getParameter("curi_nm1").trim();
		String semester = request.getParameter("smt").trim();
		System.out.println("1: curi_num1=  "+curi_num1);
		System.out.println("1: curi_nm1=  "+curi_nm1);
		System.out.println("1: smt= "+semester);
		List<LecturePlanDto> lists = manager.getLecturePlan2(curi_num1, curi_nm1,semester);
		System.out.println(": dto=  "+lists);
		Map<String, List<LecturePlanDto>> map = new HashMap<String, List<LecturePlanDto>>();
		map.put("plandto", lists);
		JSONObject jsonObject = JSONObject.fromObject(map);
		System.out.println("3: "+jsonObject.toString());
		PrintWriter pr= response.getWriter();
		jsonObject.write(pr);
	}

}
