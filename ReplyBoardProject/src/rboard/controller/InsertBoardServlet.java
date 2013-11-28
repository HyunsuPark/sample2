package rboard.controller;

import java.io.IOException;

import javax.servlet.GenericServlet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class InsertBoardServlet
 */
@WebServlet(name = "InsertBoard", urlPatterns = { "/insertB" })
public class InsertBoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertBoardServlet() {
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
		// 게시판 글쓰기 처리용 서블릿임.
		//1. 인코딩 처리
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		
		//2. 전송값 꺼내기
		
		//전송된 파일 정보 꺼내기
		
		//방법 1 : ServletInputStream 이용, byte[]로 읽어들임
		/*String fileType = request.getContentType();
		int fileSize = request.getContentLength();
		String filePath = request.getContextPath();
		
		System.out.println(fileType + ", " + fileSize + ", " + filePath);
		
		ServletInputStream in = request.getInputStream();
		byte filedata[] = new byte[1024]; 
		int n = 0;
		while((n = in.read(filedata)) != -1)
		{
			String fileStr = new String(filedata, 0, n);
			System.out.println(fileStr);
		}
		in.close();*/
		
		//방법 2 : MultipartRequest 를 이용
		// www.servlets.com/cos 에서 다운받음
		// 파일이 저장될 서버의 경로. 되도록이면 getRealPath를 이용함.
		// String savePath = "D:/Projects/workspace/projectName/WebContent/folderName";
		String savePath = request.getServletContext().getRealPath("fileUpload");

		// 파일 크기 15MB로 제한하고자 할 경우
		int sizeLimit = 1024*1024*15;

		//  ↓ request 객체,               ↓ 저장될 서버 경로,       ↓ 파일 최대 크기,    ↓ 인코딩 방식,       ↓ 같은 이름의 파일명 방지 처리
		// (HttpServletRequest request, String saveDirectory, int maxPostSize, String encoding, FileRenamePolicy policy)
		// 아래와 같이 MultipartRequest를 생성만 해주면 파일이 업로드 된다.(파일 자체의 업로드 완료)
		MultipartRequest multi = new MultipartRequest(request, savePath, sizeLimit, "utf-8", new DefaultFileRenamePolicy());
 		//객체 생성이 성공하면 파일 업로드 완성
		//객체 생성이 실패하면 IOException 발생
		
		//확인
		/*System.out.println("파일명 : " + mr.getFilesystemName("fileup"));
		System.out.println("컨텐츠타입 : " + mr.getContentType("fileup"));
		
		java.io.File file = mr.getFile("fileup");
		long filesize = file.length();
		System.out.println("파일용량 : " + filesize);*/
		
		
		
		//3. dao 쪽으로 값 넘기기
		
		//4. dao가 처리한 결과를 가지고, 뷰 선택
	}

}
