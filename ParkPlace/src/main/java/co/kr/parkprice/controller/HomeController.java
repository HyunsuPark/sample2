package co.kr.parkprice.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import co.kr.parkprice.model.User;
import co.kr.parkprice.service.HomeService;
import co.kr.parkprice.service.UserService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private HomeService homeService;
	
	@Autowired
	private UserService userService;
	
	/**
	 * 세션정보맵
	 * @param request
	 * @return
	 */
	public HashMap<String, String> getSessionMap(HttpServletRequest request){
		HashMap<String, String> ssMap = new HashMap<String, String>();
		
		HttpSession session = request.getSession();  
	    Enumeration attributeNames = session.getAttributeNames();  
	    while (attributeNames.hasMoreElements()) {  
	          
	        String name = (String) attributeNames.nextElement();  
	        if (name.equals("SPRING_SECURITY_CONTEXT")) {  
	            SecurityContext value =   
	                (SecurityContext) session.getAttribute(name);  
	            Authentication authentication = value.getAuthentication();  
	            String username = authentication.getName();  
	            String password = (String) authentication.getCredentials();  
	  
	            ssMap.put("username", username);
	        }  
	    }  
	    
	    return ssMap;
	}
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/index.do", method = RequestMethod.GET)
	public String home(HttpServletRequest request) {
		String username = getSessionMap(request).get("username");
		
		HttpSession session = request.getSession();
		session.setAttribute("username", username);
		
		return "main";
	}
	
	@RequestMapping(value = "/contact.do", method = RequestMethod.GET)
	public String contact(@RequestParam HashMap<String,String> params){
		return "contact";
	}
	
	@RequestMapping(value = "/registration.do", method = RequestMethod.GET)
	public String registration(){
		return "registration";
	}
	
	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String login(){
		return "login";
	}
	
	@RequestMapping(value = "/join.do", method = RequestMethod.GET)
	public String join(){
		return "join";
	}
	
	@RequestMapping(value = "/contactSave.do", method = RequestMethod.POST)
	public void saveContact(@RequestParam HashMap<String,String> params){
		homeService.saveContact(params);
	}
	
	@RequestMapping(value = "/addUser.do", method = RequestMethod.POST)
	public ModelAndView addUser(@RequestParam HashMap<String,String> params){
		ModelAndView model = new ModelAndView();
		
		User user = new User();
		user.setId(params.get("id"));
		user.setPassword(params.get("pass"));
		
		String result = userService.addUser(user);
//		
		model.addObject("result", result);
		if(result.equals("ok")){
			model.setViewName("main");
		}else{
			model.setViewName("common/fail");
		}
		
		return model;
	}
	
	@RequestMapping(value = "/loginUser.do", method = RequestMethod.POST)
	public ModelAndView loginUser(@RequestParam HashMap<String,String> params){
		ModelAndView model = new ModelAndView();
		
		User user = new User();
		user.setId(params.get("id"));
		user.setPassword(params.get("pass"));
		
		
		
		return model;
	}
	
}
