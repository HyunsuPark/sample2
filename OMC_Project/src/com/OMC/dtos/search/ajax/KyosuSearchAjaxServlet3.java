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
import com.OMC.dtos.search.KyosuSearchDto;

/**
 * Servlet implementation class kyosuSearchAjaxServlet3
 */
public class KyosuSearchAjaxServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KyosuSearchAjaxServlet3() {
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
    	String subject = request.getParameter("subject").trim();
    	String kor_nm = request.getParameter("kor_nm").trim();
    	System.out.println("1 subject ="+subject);
    	System.out.println("1 kor_nm ="+kor_nm);
    	List<KyosuSearchDto> lists = manager.getKyosuSearch3(kor_nm,subject);
		System.out.println(": dto=  "+lists);
		Map<String, List<KyosuSearchDto>> map = new HashMap<String, List<KyosuSearchDto>>();
		map.put("kyosusearch", lists);
		JSONObject jsonObject = JSONObject.fromObject(map);
		System.out.println("3: "+jsonObject.toString());
		PrintWriter pr= response.getWriter();
		jsonObject.write(pr);
	}

}
