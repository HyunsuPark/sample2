import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Iterator;

public class NonBlockIO_Selectort {

	public static void main(String[] args) throws IOException,
			InterruptedException {
		//Selector 
		Selector selector = Selector.open(); 
		
		// 소켓열고
		ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
		// 소켓 채녈 논블럭킹설정
		serverSocketChannel.socket().bind(new InetSocketAddress(8000));
		serverSocketChannel.configureBlocking(false);
		
		/**
		 *  SelectionKey.OP_READ - 채널로부터 데이터를 읽어올 수 있는 경우. 값은 1
			SelectionKey.OP_WRITE - 채널에 데이터를 쓸 수 있는 경우. 값은 4
			SelectionKey.OP_ACCEPT - 소켓 연결이 들어온 경우. 값은 16
			SelectionKey.OP_CONNECT - 연결 요청이 이뤄진 경우. 값은 8
		 */
		//감지할 이벤트 지정
		serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
		
		while (true) {
			 System.out.println("connecting.....");
			 //셀렉터의 select() 메소드로 준비된 이벤트가 있는지 확인함
			 selector.select();
			 Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
			 
			 while (iterator.hasNext()) {
				SelectionKey selectionKey = (SelectionKey) iterator.next();
				iterator.remove(); // 이미 처리한 이벤트 이므로 반드시 삭제함
				
				// 서버 소켓 채널에 클라이언트가 접속을 시도한 경우
				if (selectionKey.isAcceptable()) {
					serverSocketChannel = (ServerSocketChannel) selectionKey.channel();
					SocketChannel socketChannel = serverSocketChannel.accept();
					ByteBuffer byteBuffer = ByteBuffer.allocate(1024); // 쓰기 가능 영역 크기
					socketChannel.write(byteBuffer);
				}
			} //while (iterator.hasNext())
		}//while
	}//main
}
