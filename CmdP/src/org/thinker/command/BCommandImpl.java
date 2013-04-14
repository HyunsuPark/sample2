package org.thinker.command;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BCommandImpl implements Command {

	@Override
	public String execute(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
System.out.println("BCommandImpl......");
		
		return "b.jsp";
	}

}
