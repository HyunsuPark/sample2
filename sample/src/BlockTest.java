import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class BlockTest {
	public static void main(String[] args) throws IOException {
		//소캣만듬
		ServerSocket serverSocket = new ServerSocket(8000);
		//접속을 기다림 Block
		Socket socket = serverSocket.accept();
		//스트림데이터를 받음(헤더메시지) 
		InputStream inputStream = socket.getInputStream();
		
//		inputStream.read() 를 변수에 넣어 읽은것이다. 왜냐면 스트림데이터는 한번읽으면 없어지기 때문 
		int oneByte = -1;
		
		// 헤더메시지 끝이날때까지 block 
		while(-1 != (oneByte = inputStream.read())){
			System.out.print((char)oneByte); //decimal형태의 데이터를 char로 변환하면 알파벳이 됨 (아스키코드)
		}
		
		System.out.println("end");

		socket.close();
		serverSocket.close();
	}
}
