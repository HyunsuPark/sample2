package com.chat;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.PointerInfo;
import java.awt.Robot;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ChatServerHandler extends Thread {
	protected Socket socket;
	String line; // 서버로부터 읽어온 문자열 저장

	public ChatServerHandler(Socket socket) {
		this.socket = socket;
	}

	public void run() {
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(
					socket.getInputStream()));
			while (true) {
				line = reader.readLine();
				System.out.println("받은글:  " + line);
				System.out.print("☞  ");
				if (line.equals("m")) {
					//현재 마우스 포인터 위치를 구함.
					PointerInfo pointerInfo = MouseInfo.getPointerInfo();
					Robot robot = new Robot();
					
					// x,y좌표
					int X = pointerInfo.getLocation().x;
					int Y = pointerInfo.getLocation().y;
					
					robot.mouseMove(X + 1, Y);
				}
			}

		} catch (IOException ignored) {
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				socket.close();
			} catch (IOException e) {
			}
		}
	}

}
