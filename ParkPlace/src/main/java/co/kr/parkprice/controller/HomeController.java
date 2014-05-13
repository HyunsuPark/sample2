package co.kr.parkprice.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import co.kr.parkprice.model.Member;
import co.kr.parkprice.model.Parking;
import co.kr.parkprice.model.Registration;
import co.kr.parkprice.model.User;
import co.kr.parkprice.service.HomeService;
import co.kr.parkprice.service.UserService;
import co.kr.parkprice.util.PagingUtil;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {

	private static final Logger logger = LoggerFactory
			.getLogger(HomeController.class);

	@Autowired
	private HomeService homeService;

	@Autowired
	private UserService userService;

	/**
	 * 세션정보맵
	 * 
	 * @param request
	 * @return
	 */
	public HashMap<String, String> getSessionMap(HttpServletRequest request) {
		HashMap<String, String> ssMap = new HashMap<String, String>();

		HttpSession session = request.getSession();
		Enumeration attributeNames = session.getAttributeNames();
		while (attributeNames.hasMoreElements()) {

			String name = (String) attributeNames.nextElement();
			if (name.equals("SPRING_SECURITY_CONTEXT")) {
				SecurityContext value = (SecurityContext) session
						.getAttribute(name);
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

		return "main";
	}

//	@RequestMapping(value = "/contact.do", method = RequestMethod.GET)
//	public String contact(@RequestParam HashMap<String, String> params) {
//		return "contact";
//	}
//
//	@RequestMapping(value = "/registration.do", method = RequestMethod.GET)
//	public String registration() {
//		return "registration";
//	}

	@RequestMapping(value = "/login.do", method = RequestMethod.GET)
	public String login() {
		return "login";
	}

//	@RequestMapping(value = "/cmn/join.do", method = RequestMethod.GET)
//	public String join() {
//		return "join";
//	}
	
	//////////////////////////////////////////////////////////
	@RequestMapping(value = "/memberList.do", method = RequestMethod.GET)
	public ModelAndView memberList(@RequestParam("pageNo") int pageNo) {
		ModelAndView model = new ModelAndView();
		PagingUtil paging = new PagingUtil();
		
		Member mem = new Member();
		mem.setPageNo(paging.getPageCnt(pageNo));
		
		ArrayList<Member> list = homeService.getMember(mem);
		model.setViewName("memberList");
		model.addObject("data", list);
		
		HashMap<String, Integer> pagingMap = paging.getPageObj(pageNo,list.get(0).getTotalCnt());
		model.addObject("pagingMap", pagingMap);

		return model;
	}
	
	@RequestMapping(value = "/getMember.do", method = RequestMethod.GET)
	public ModelAndView getParking(@RequestParam("m_idx") String m_idx) {
		ModelAndView model = new ModelAndView();
		
		Member park = new Member();
		park.setM_idx(m_idx);
		
		ArrayList<Member> list = homeService.getMember(park);
		model.setViewName("memberModify");
		model.addObject("data", list.get(0));
		
		return model;
	}
	
	@RequestMapping(value = "/modifyMember.do", method = RequestMethod.POST)
	public String modifyMember(
			@ModelAttribute("Member") Member mem,@RequestParam("m_idx") String m_idx,
			HttpServletRequest request) throws IOException {

		homeService.udtMember(mem);

		return "redirect:getMember.do?m_idx="+m_idx+"&save=ok";
	}
	
	@RequestMapping(value = "/parkingList.do", method = RequestMethod.GET)
	public ModelAndView parkingList(@RequestParam("pageNo") int pageNo) {
		ModelAndView model = new ModelAndView();
		PagingUtil paging = new PagingUtil();
		
		Parking park = new Parking();
		park.setPageNo(paging.getPageCnt(pageNo));
		
		ArrayList<Parking> list = homeService.getParking(park);
		model.setViewName("parkingList");
		model.addObject("data", list);
		
		HashMap<String, Integer> pagingMap = paging.getPageObj(pageNo,list.get(0).getTotalCnt());
		model.addObject("pagingMap", pagingMap);

		return model;
	}
	
	@RequestMapping(value = "/parkRegi.do", method = RequestMethod.GET)
	public String parkRegi() {
		return "parkRegi";
	}
	
	@RequestMapping(value = "/saveParkRegi.do", method = RequestMethod.POST)
	public String savePark(
			@ModelAttribute("Parking") Parking park,
			HttpServletRequest request) throws IOException {

		homeService.insParking(park);

		return "redirect:parkingList.do?pageNo=1";
	}
	
	@RequestMapping(value = "/getParkRegi.do", method = RequestMethod.GET)
	public ModelAndView getParkRegi(@RequestParam("p_idx") String p_idx ) throws IOException {
		ModelAndView model = new ModelAndView();
		
		Parking parking = new Parking();
		parking.setP_idx(p_idx);
		
		homeService.getParking(parking);

		ArrayList<Parking> list = homeService.getParking(parking);
		model.setViewName("parkModify");
		model.addObject("parkData", list.get(0));
		
		return model;
	}
	
	@RequestMapping(value = "/modifyPark.do", method = RequestMethod.POST)
	public String modifyPark(
			@ModelAttribute("Parking") Parking park,@RequestParam("p_idx") String p_idx,
			HttpServletRequest request) throws IOException {

		homeService.udtParking(park);

		return "redirect:getParkRegi.do?p_idx="+p_idx+"&save=ok";
	}
	
	
	@RequestMapping(value = "/searchParking.do", method = RequestMethod.GET)
	public ModelAndView searchParking(@RequestParam("p_name") String p_name ) throws IOException {
		
		ModelAndView model = new ModelAndView();
		
		Parking parking = new Parking();
		parking.setP_name(p_name);
		
		ArrayList<Parking> list = homeService.getParking(parking);
		model.setViewName("parkingList");
		model.addObject("data", list);
		
		return model;
	}
	
	@RequestMapping(value = "/searchMember.do", method = RequestMethod.GET)
	public ModelAndView searchMember(@RequestParam("m_userid") String m_userid ) throws IOException {
		
		ModelAndView model = new ModelAndView();
		
		Member member = new Member();
		member.setM_userid(m_userid);
		
		ArrayList<Member> list = homeService.getMember(member);
		model.setViewName("memberList");
		model.addObject("data", list);
		
		return model;
	}
	
	
	
	
	
	
	
	
	/////////////////////////////////////////////////////////
	
	@RequestMapping(value = "/cmn/fail.do", method = RequestMethod.GET)
	public ModelAndView fail(HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		
		model.addObject("result", request.getParameter("msg"));
		model.setViewName("common/fail");
		
		return model;
	}
	
	@RequestMapping(value = "/cmn/ok.do", method = RequestMethod.GET)
	public ModelAndView ok(HttpServletRequest request) {
		ModelAndView model = new ModelAndView();
		
		model.addObject("result", request.getParameter("msg"));
		model.addObject("next_url", request.getParameter("next"));
		model.setViewName("common/ok");
		
		return model;
	}

//	@RequestMapping(value = "/regiView.do", method = RequestMethod.GET)
//	public ModelAndView regiView(HttpServletRequest request) {
//		ModelAndView model = new ModelAndView();
//
//		Registration regi = new Registration();
//		regi.setId((String) request.getSession().getAttribute("username"));
//
//		ArrayList<Registration> list = homeService.getRegi(regi);
//		model.setViewName("view");
//		model.addObject("data", list);
//
//		return model;
//	}
//
//	@RequestMapping(value = "/detailView.do", method = RequestMethod.GET)
//	public ModelAndView detailView(@RequestParam("seq") int seq,
//			HttpServletRequest request) {
//		ModelAndView model = new ModelAndView();
//
//		Registration regi = new Registration();
//		regi.setId((String) request.getSession().getAttribute("username"));
//		regi.setSeq(seq);
//
//		ArrayList<Registration> list = homeService.getRegi(regi);
//		model.setViewName("view_detail");
//		model.addObject("data", list);
//
//		return model;
//	}
//
//	@RequestMapping(value = "/cmn/addUser.do", method = RequestMethod.POST)
//	public ModelAndView addUser(@RequestParam HashMap<String, String> params) {
//		ModelAndView model = new ModelAndView();
//
//		User user = new User();
//		user.setId(params.get("id"));
//		user.setPassword(params.get("pass"));
//		user.setEmail(params.get("email"));
//
//		String result = userService.addUser(user);
//		//
//		if (result.equals("ok")) {
//			model.setView(new RedirectView("ok.do?msg=join_ok&next=index.do"));
//		} else {
//			model.setView(new RedirectView("fail.do?msg=duple_id"));
//		}
//
//		return model;
//	}
//
//	@RequestMapping(value = "/saveRegi.do", method = RequestMethod.POST)
//	public ModelAndView saveRegi(
//			@ModelAttribute("Registration") Registration regi,
//			HttpServletRequest request) throws IOException {
//
//		ModelAndView model = new ModelAndView();
//		try {
//			fileUpload(regi,request);
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//		regi.setId((String) request.getSession().getAttribute("username"));
//		homeService.saveRegi(regi);
//
//		model.setView(new RedirectView("regiView.do"));
//
//		return model;
//	}

	public void fileUpload(Registration regi,HttpServletRequest request) throws IOException {
		List<MultipartFile> files = regi.getFiles();

		List<String> fileNames = new ArrayList<String>();
		if (null != files && files.size() > 0) {
			for (MultipartFile multipartFile : files) {
				if(multipartFile.getSize()>0){
//					String fileName = multipartFile.getOriginalFilename();
					String uniqueFileName = UUID.randomUUID().toString().replace("-", "");
					 
				    String path = request.getSession().getServletContext().getRealPath("")
				    		+File.separator+"WEB-INF"+File.separator+"upload"+File.separator+uniqueFileName;
				    logger.info(path);
				    File f = new File(path);
//				    boolean bb = f.createNewFile();
//				    logger.info(bb+""); 
//				    
//				    logger.info(f.canWrite()+"");
				    try {
						multipartFile.transferTo(f);
					} catch (IllegalStateException e) {
						e.printStackTrace();
					} catch (IOException e) {
						e.printStackTrace();
					}
				    fileNames.add(uniqueFileName);
				}
				
			}
			
			if (fileNames.size()>=1) {
				regi.setFile1(fileNames.get(0));
			}
			
			if (fileNames.size()>=2) {
				regi.setFile2(fileNames.get(1));
			}
			
			if (fileNames.size()>=3) {
				regi.setFile3(fileNames.get(2));
			}
			
		}
		
	}

}
