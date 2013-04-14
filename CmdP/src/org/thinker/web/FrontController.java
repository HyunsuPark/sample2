package org.thinker.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.thinker.command.Command;

/**
 * Servlet implementation class FrontController
 */
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = Logger.getLogger(FrontController.class);

	private CommandFactory commandFactory;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init() throws ServletException {
    	 
    	commandFactory = new CommandFactory();
    	
    	try {
    		//설정로딩
			commandFactory.init();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.info("service..........");
		
		try {
			process(request, response);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		//확장자가 있는경우 getPathInfo()
		String path = request.getPathInfo();
		logger.info("path ::: " + path);
		//확장자 없는경우 
		if(path==null){
		 path = request.getServletPath();
		}

		String callPath = getPath(path);
		
		
		if(callPath == null ||  callPath.trim().length() == 0){
		 throw new Exception("null path");
		}
		
		logger.info("callPath ::: "+ callPath);
		
		Command command = commandFactory.lookup(callPath);
		
		String viewPath = command.execute(request, response);
	
		RequestDispatcher dispather = request.getRequestDispatcher(viewPath);
		
		dispather.forward(request, response);
	}
	
	/**
	 * 
	 * @param path
	 * @return
	 */
	private String getPath(String path){
		String result = null;

		if(path.indexOf(".")>=0){
		 result = path.substring(0,path.indexOf("."));
		}else{
		 result = path;
		}

		return result;
	}

		
}
