package com.chat;

import java.awt.AWTException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.logging.Logger;

public class ChatServerHandler extends Thread {
	protected Socket socket;
	String line; // 서버로부터 읽어온 문자열 저장
	Logger logger = Logger.getLogger(ChatServerHandler.class.getName());

	public ChatServerHandler(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		try {
			MoveHandler handler = new MoveHandler();

			BufferedReader reader = new BufferedReader(new InputStreamReader(
					socket.getInputStream(), "utf-8"));
			while (true) {
				line = reader.readLine();
				// System.out.println("받은글:  " + line);
				// System.out.print("☞  ");
//				logger.info("받은글:  " + line);
				
				if(line.equals("R")){
					handler.mouseRightClick();
				}else if(line.equals("L")){
					handler.mouseLeftClick();
				}else{
					handler.mouseMove(line);
				}
				
//				if(!line.equals("")){
//					handler.mouseMove(line);
//				}
			}

		} catch (IOException ignored) {
			System.err.println("오류로 인해 연결이 종료되었습니다.");
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				socket.close();
			} catch (IOException ignored) {
				System.err.println("오류로 인해 연결이 종료되었습니다.");
			}
		}
	}

}
