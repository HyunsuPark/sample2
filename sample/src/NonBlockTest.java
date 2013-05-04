import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class NonBlockTest {
	
	static ServerSocketChannel serverSocketChannel=null;
	static Selector selector =null;
	
	public static void main(String[] args) throws IOException, InterruptedException {
		//셀럭터열기
		selector = Selector.open();
		//소켓열음
		serverSocketChannel = ServerSocketChannel.open();
		//포트 설정
		serverSocketChannel.socket().bind(new InetSocketAddress(8000));
		//논블럭킹 설정
		serverSocketChannel.configureBlocking(false);
		
		System.out.println("블록킹상태확인:::::::: " + serverSocketChannel.isBlocking() );
		
		//Selector를 이용해 감지할이벤트 설정
		serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
		
		while(true){
			System.out.println("연결중......,");
			//준비된 이벤트가 있는지? 이벤틈마다 다른 숫자 반환 있을때까지 블럭킹
			selector.select(); //블럭킹메소드
//			int accept = selector.selectNow(); //논블럭
			
			// 이벤트 발생하였을때 
				//셀렉터의 SelectSet에 준비된 이벤트 들을 하나씩 처리함.
				Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
				
				while (iterator.hasNext()) {
					SelectionKey selectionKey = (SelectionKey) iterator.next();
					
					//key에 따른 분기처리 
					if(selectionKey.isAcceptable()){
						//서버소켓채널에 클라이언트가 접속시도
						accept(selectionKey);
					}else if(selectionKey.isReadable()){
						//이미 연결된 클라이언트가 메시지를 보낸경우
						read(selectionKey);
					}
					//이미처리된이벤트는 제거
					iterator.remove();
				
				}//while 끝
		}
	}

	/**
	 * 클라이언트가 접속한후에 처리되는 메소드
	 * @param selectionKey
	 * @throws IOException 
	 */
	private static void accept(SelectionKey selectionKey) throws IOException {
		// TODO Auto-generated method stub
		//받아들인 채널로 서버소켓채널 생성
		ServerSocketChannel server = (ServerSocketChannel)selectionKey.channel();
		//받아들인 서버소켓채널로 소켓채널 생성
		SocketChannel sc = server.accept();
		sc.configureBlocking(false); // 받아들인게 논블럭킹이니까 이것도 논블럭킹으로 해야함 
		//접속된후에는 읽기 모드로 변경
		sc.register(selector, SelectionKey.OP_READ);
		System.out.println(sc.toString()+"접속되었습니다.");
		
	}
	
	/**
	 * 접속한후에 read된 내용의 byte크기를 알려줌
	 * @param key
	 */
	private static void read(SelectionKey key){
		// SelectionKey로부터 소켓 채널을 얻어옴
		SocketChannel sc = (SocketChannel)key.channel();
		// ByteBuffer를 생성함 1024 byte제한
		ByteBuffer buffer = ByteBuffer.allocateDirect(1024);
		try{
			// 요청한 클라이언트의 소켓채널로부터 데이터를 읽어 들임
			int read = sc.read(buffer);
			System.out.println(read + "byte읽었습니다");
		}catch(IOException e){
			try{
				sc.close();
			}catch(IOException e1){}
		}
		
		// 버퍼 메모리를 해제함
		clearBuffer(buffer);
	}
	
	/**
	 * buffer내용을 클리어
	 * @param buffer
	 */
	private static void clearBuffer(ByteBuffer buffer) {
		// TODO Auto-generated method stub
		if(buffer != null){
			buffer.clear();
			buffer = null;
		}
	}

}
