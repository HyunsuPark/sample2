package board.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board.model.dao.BoardDao;
import board.model.vo.Board;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class InsertNoticeServlet
 */
@WebServlet("/insert")
public class InsertNoticeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertNoticeServlet() {
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
		// 글 추가 서비스용
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		// 저장경로
		String savePath = request.getServletContext().getRealPath("fileUpload");
		// 파일 크기 15MB로 제한
		int sizeLimit = 1024*1024*15;
		MultipartRequest multi = fileupload(request, savePath, sizeLimit);
		 
		String writer = multi.getParameter("writer");
		String pwd = multi.getParameter("pwd");
		String subject = multi.getParameter("subject");
		String content = multi.getParameter("content");
		String fileName = "";
		if(multi.getFilesystemName("fileup") != null) fileName = multi.getFilesystemName("fileup");
		File file = multi.getFile("fileup");
		long filesize = 0;
		if(file != null) filesize = file.length();
		
		///////////////////////////////////////////////////////////////////////
		Board newNotice = new Board();
		newNotice.setWriter(writer);
		newNotice.setPwd(pwd);
		newNotice.setSubject(subject);
		newNotice.setContent(content);
		newNotice.setFilename(fileName);
		newNotice.setFilesize(filesize);
		
		BoardDao ndao = new BoardDao();
		int result = ndao.insertRow(newNotice);
		
		if(result > 0)	//글쓰기 추가 성공시
		{
			response.sendRedirect("list");
		}else	//글 추가 실패시
		{
			response.sendRedirect("insertError.html");
		}
	}
	
	private MultipartRequest fileupload(HttpServletRequest request,String savePath,int sizeLimit){
		MultipartRequest multi = null;
		try {
			multi = new MultipartRequest(request, savePath, sizeLimit, "utf-8", new DefaultFileRenamePolicy());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return multi;
	}

}
