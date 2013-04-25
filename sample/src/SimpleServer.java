import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer extends Thread{
	private ServerSocket serverSocket;

	public static void main(String[] args) {
		SimpleServer simpleServer = new SimpleServer();
		simpleServer.start();
	}
	
	private void boot() throws IOException {
		//포트를 설정한다.
		serverSocket = new ServerSocket(8000);
		//접속기다림
		Socket socket = serverSocket.accept(); //블럭
		System.out.println(socket); //접속정보
		// 스트림으로 읽음
		InputStream in = socket.getInputStream();
		
		int oneInt = -1;
		
		while((oneInt=in.read()) != -1){
			System.out.print((char)oneInt);
		}
		
		System.out.println("END");
		in.close();
		socket.close();
	}
	
	@Override
	public void run() {
		try {
			boot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
