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
import com.OMC.dtos.search.LectureSearchDto;

/**
 * Servlet implementation class lectureSearchAjaxServlet3
 */
public class LectureSearchAjaxServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LectureSearchAjaxServlet3() {
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
		System.out.println(request.getParameter("curi_num").trim());
		System.out.println(request.getParameter("curi_nm").trim());
		String curi_num=request.getParameter("curi_num").trim();
		String curi_nm=request.getParameter("curi_nm").trim();
		System.out.println("1: curi_num=  "+curi_num);
		System.out.println("1: curi_nm=  "+curi_nm);
		List<LectureSearchDto> lists = manager.getLectureSearch2(curi_num,curi_nm);
		System.out.println(": dto=  "+lists);
		Map<String, List<LectureSearchDto>> map = new HashMap<String, List<LectureSearchDto>>();
		map.put("searchdto", lists);
		JSONObject jsonObject = JSONObject.fromObject(map);
		System.out.println("3: "+jsonObject.toString());
		PrintWriter pr= response.getWriter();
		jsonObject.write(pr);
	}

}
