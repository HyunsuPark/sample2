import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;


public class NonBlockIO{
	
	public static void main(String[] args) throws IOException, InterruptedException {
		//소켓열고
				ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
				//소켓 채녈 논블럭킹설정
				serverSocketChannel.socket().bind(new InetSocketAddress(8000));
//				serverSocketChannel.configureBlocking(false);	
				
				while (true) {
					System.out.println("connecting....");
					SocketChannel socketChannel = serverSocketChannel.accept();
					
					if(socketChannel == null){
						Thread.sleep(2000); // 논블락이라 잠깐 정지시킬용도
					}else{
					
						String response = "Hello " + socketChannel.socket().getInetAddress() + " on port "
						          + socketChannel.socket().getPort() + "\r\n";
						      response += "This is " + serverSocketChannel.socket() + " on port "
						          + serverSocketChannel.socket().getLocalPort() + "\r\n"
						          + "연결되었습니다";
						
						byte[] data = response.getBytes();
						ByteBuffer buffer = ByteBuffer.wrap(data);
						
						socketChannel.write(buffer);
						socketChannel.close();
					}
				}
	}
}
