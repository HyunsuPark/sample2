package com.OMC.dtos.lectureapply.ajax;
//com.OMC.dtos.student.ajax.StuSearchAjaxServlet
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

import com.OMC.daos.ClassManager;
import com.OMC.dtos.lectureapply.LectureConfirmDto;


public class LecConfirmAjaxServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	public void doGet(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}
	public void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/json; charset=utf-8");
			
			ClassManager manager = new ClassManager();
			
			String stuId = request.getParameter("stuId");
			System.out.println("1: stuId=  "+stuId);
			String year = request.getParameter("year");
			System.out.println("2: year=  "+year);
			String smtSel = request.getParameter("smtSel");
			System.out.println("3: smtSel=  "+smtSel);


			LectureConfirmDto cDto = new LectureConfirmDto(stuId,year,smtSel);
			List<LectureConfirmDto> lists = manager.getLactureConfirmList(cDto);
			
			Map<String, List<LectureConfirmDto>> map = new HashMap<String, List<LectureConfirmDto>>();
			map.put("lecconfirmdto", lists);
			JSONObject jsonObject = JSONObject.fromObject(map);
			System.out.println("6: "+jsonObject.toString());
			PrintWriter pr= response.getWriter();
			jsonObject.write(pr);
			
			
	}
}
