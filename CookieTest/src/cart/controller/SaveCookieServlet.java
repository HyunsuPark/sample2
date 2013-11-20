package cart.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SaveCookieServlet
 */
@WebServlet("/saveCookie")
public class SaveCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SaveCookieServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 전송된 값을 쿠키에 저장해서, 쿠키를 클라이언트에게 보냄
		response.setContentType("text/html;charset=utf-8");
		
		String p = request.getParameter("product");
		
		//전송된 request 에서 쿠키 정보를 꺼냄
		Cookie cookies[] = request.getCookies();
		//새로운 쿠키 객체 생성 : 새 정보를 저장함
		Cookie c = null;
		
		//request에 쿠키 정보가 없다면, 
		if(cookies == null || cookies.length == 0)
		{
			//쿠키에 저장할 이름을 "cart1" 이라고 함
			c = new Cookie("cart1", p);
		}else		//전송된 쿠키 정보가 있다면
		{
			//쿠키에 저장할 이름을 "cartN번째" 라고 함
			c = new Cookie("cart" + (cookies.length+1), p);
		}
		
		//응답 객체에 쿠키 저장함
		response.addCookie(c);
		
		//뷰를 내보냄
		response.sendRedirect("saveCart.html");
	}

}
