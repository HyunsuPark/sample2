import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
	private ServerSocket serverSocket;
	
	public static void main(String[] args) throws IOException {
		
		SimpleServer c = new SimpleServer();
		c.boot();
	}
	
	private void boot() throws IOException {
		//포트를 설정한다.
		serverSocket = new ServerSocket(8000);
		//접속기다림
		Socket socket = serverSocket.accept();
		System.out.println(socket); //접속정보
		// 스트림으로 읽음
		InputStream in = socket.getInputStream();
		
		int oneInt = -1;
		
		while((oneInt=in.read()) != -1){
			System.out.print((char)oneInt);
		}
		
		in.close();
		socket.close();
	}
}
