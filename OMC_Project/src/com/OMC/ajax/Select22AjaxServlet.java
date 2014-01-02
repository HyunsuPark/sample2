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
import com.OMC.dtos.search.Select22Dto;

public class Select22AjaxServlet extends HttpServlet {

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

			List<Select22Dto> lists = manager.getSelect22List(bldCd);
			
			Map<String, List<Select22Dto>> map = new HashMap<String, List<Select22Dto>>();
			map.put("select22dto", lists);
			JSONObject jsonObject = JSONObject.fromObject(map);
			System.out.println("6: "+jsonObject.toString());
			PrintWriter pr= response.getWriter();
			jsonObject.write(pr);
			
			
	}
}
