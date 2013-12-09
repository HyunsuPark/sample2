package Homework;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ObjectCalculatorServer {
	
	public static void main(String[] args) {
		Socket sock = null;

		ServerSocket server;
		
		try {
			server = new ServerSocket(10005);
			System.out.println("접속 대기중 ...");

			while (true) {
				sock = server.accept();
				System.out.println("["+sock.getInetAddress() + "]"+"에서 접속하였습니다.");
				ServerReceiver thread = new ServerReceiver(sock);
				thread.start();
			} 
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
