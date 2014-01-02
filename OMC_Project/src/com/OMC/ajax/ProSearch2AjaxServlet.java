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
import com.OMC.dtos.search.ProSearch1Dto;
import com.OMC.dtos.search.Search3ConDto;
import com.OMC.dtos.search.Search3Dto;

public class ProSearch2AjaxServlet extends HttpServlet {

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
			
			String contDeptCd = request.getParameter("contDeptCd");
			System.out.println("1: contDeptCd=  "+contDeptCd);

			List<ProSearch1Dto> lists = manager.getProSearch2List(contDeptCd);
			
			Map<String, List<ProSearch1Dto>> map = new HashMap<String, List<ProSearch1Dto>>();
			map.put("prosear1dto", lists);
			JSONObject jsonObject = JSONObject.fromObject(map);
			System.out.println("6: "+jsonObject.toString());
			PrintWriter pr= response.getWriter();
			jsonObject.write(pr);
			
			
	}
}
