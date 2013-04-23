import java.io.*;
import java.net.*; //소켓


public class UserServer{
	public static void main(String[] args) 
	{
		try{
			//순서1 - 서버소켓생성후 client 접속 대기중
			ServerSocket server = new ServerSocket(1111);
			System.out.println("서버소켓 생성됨. 대기모드로 전환!");

			//순서2 - 일반소켓으로 서버소켓의 접속을 받음
			Socket socket = server.accept();
			System.out.println("Client 접속허용");

			//순서3 - 접속한 client 주소 표시
			InetAddress add = socket.getInetAddress();
			System.out.println(add+" Client접속함");

			//순서 4 - 소켓으로 접속한 stream처리
			//Stream 은 자바에서 기본적으로 byte로 처리한다.
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();

			//순서 5 - while문으로 소켓으로 연결된 데이터 주고받기
			//byte단위를 쉽게 처리하도록 Reader/Writer로 변환
			InputStreamReader isr = new InputStreamReader(is);
			OutputStreamWriter osw = new OutputStreamWriter(os);


			//스트림 reader / 스트림 writer 변환 다시 BufferedReader로...
			BufferedReader br = new BufferedReader(isr);
			PrintWriter pw = new PrintWriter(osw);
			while(true){
				String data = br.readLine();
				if (data.equals("Q")||data.equals("q")){
					System.out.println("에코 Server 채팅종료");
					break;
				}

				System.out.println("client 내용 : "+data);
			}
			br.close(); pw.close(); socket.close(); isr.close(); osw.close();
		}catch(Exception ex){
			System.out.println("Occured ERROR!");
		}
	}
}
