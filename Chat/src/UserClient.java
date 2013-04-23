import java.io.*;
import java.net.*;//소켓

public class UserClient{ //쓰레드 + 벡터 + String클레스메소드 + awt + awt.event
	public static void main(String[] args) {
		try{
			//순서 1 서버소켓생성후 - 클라이언트 접속을 대기중
			//순서 2 일반소켓으로 서버소켓의 접속을 받음
			//순서 3 접속한 client주소 표시

			//순서 A 서버접속을 위한 ip, port 번호 필요
			Socket socket = new Socket("127.0.0.1",1111);
			//순서 B 소켓으로 접속한 stream처리
			InputStream is = socket.getInputStream();
			OutputStream os = socket.getOutputStream();

			//순서 5 - while문으로 소켓으로 연결된 데이터 주고받기
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			PrintWriter pw = new PrintWriter ( new OutputStreamWriter(os));
			//client가 키보드에서 데이터 입력
			BufferedReader key = new BufferedReader(new InputStreamReader(System.in));
			while(true){
				System.out.print("메세지 입력 : ");
				String data = key.readLine();//키보드입력
				if (data.equals("Q")||data.equals("q")){
					System.out.println("에코 Server 채팅종료");
					break;
				}
				pw.println(data); pw.flush();
			}//while END
			br.close(); pw.close(); socket.close(); key.close();
		}catch(Exception ex){}

	}
}
