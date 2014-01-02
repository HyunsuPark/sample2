package com.OMC.dtos.lectureapply.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.OMC.daos.ClassService;
import com.OMC.dtos.lectureapply.CustUserDtos;

/**
 * Servlet implementation class classesAjaxServlet
 */
public class classesAjaxServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public classesAjaxServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(req, resp);
	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("들어왔니1?");
		req.setCharacterEncoding("utf-8");
		resp.setContentType("text/json; charset=utf-8");
		
		String curi_num = req.getParameter("st").trim();
		System.out.println("들어왔니2?");
		String student_cd=req.getParameter("st1").trim();
		System.out.println("들어왔니3?");
		String curi_num1=req.getParameter("st").trim();
		ClassService service=ClassService.getInstance();
		System.out.println("들어왔니4?");
		System.out.println("1: st = "+curi_num);
		System.out.println("1: st = "+student_cd);
		System.out.println("1: st = "+curi_num1);
		
		CustUserDtos dto = service.getCheck(new CustUserDtos(student_cd, curi_num, curi_num1));
		String lec_check =dto.getLec_check();
		System.out.println(lec_check+"+++********");
		Map<String, String> map=new HashMap<String, String>();
		map.put("lec_check", lec_check);
		System.out.println(map);
		JSONObject jsonObject = JSONObject.fromObject(map);
		System.out.println("3: "+jsonObject.toString());
		PrintWriter pr= resp.getWriter();
		jsonObject.write(pr);		
	}

}
