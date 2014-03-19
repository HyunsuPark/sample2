package sample.service;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import sample.dao.SampleDao;

public class ContactService {
	public int insert(HttpServletRequest request){
		HashMap<String, String> map = new HashMap<String, String>();
		map.put("subject", request.getParameter("subject"));
		map.put("phone", request.getParameter("phone"));
		map.put("email", request.getParameter("email"));
		map.put("question", request.getParameter("question"));
		
		SampleDao dao = new SampleDao();
		dao.insertData(map);
		
		return 0;
	}
}
