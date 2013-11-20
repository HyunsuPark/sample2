package cart.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class BasketCookieServlet
 */
@WebServlet("/basketCookie")
public class BasketCookieServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BasketCookieServlet() {
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
		// 전송된 쿠키 정보를 꺼내서 출력
		response.setContentType("text/html;charset=utf-8");
		
		//클라이언트 쪽으로 내보낼 출력용 객체 생성
		PrintWriter out = response.getWriter();
		
		//전송받은 정보에서 쿠키를 꺼냄
		Cookie[] cookies = request.getCookies();
		
		//출력
		out.print("<!DOCTYPE html>");
		out.print("<html><head><title>장바구니보기</title>");
		out.print("<meta charset=utf-8></head>");
		out.print("<body><h1>장바구니에 저장된 상품 정보 보기</h1>");
		out.print("<hr/>");
		
		if(cookies != null)
		{
			//쿠키에 저장된 정보를 하나씩 꺼내서 화면에 출력함
			for(int i = 0; i < cookies.length; i++)
			{
				out.print(cookies[i].getName() + ", " + 
						cookies[i].getValue() + "<br>");
			}
		}
		else
		{
			out.print("<h2>저장된 상품 정보가 없습니다</h2>");
		}
		
		out.print("<a href=productCookie.html>상품 선택페이지로 이동</a><br>");
		out.print("</body></html>");
		out.close();
	}

}
