package org.thinker.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CCommandImpl implements Command {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
System.out.println("CCommandImpl......");
		
		return "c.jsp";
	}

}
