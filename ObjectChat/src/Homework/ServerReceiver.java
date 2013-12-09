package Homework;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;

public class ServerReceiver extends Thread {
	ObjectOutputStream oos = null;
	ObjectInputStream ois = null;
	Socket sock = null;

	HashMap clients = null;

	public ServerReceiver(Socket sock) {
		this.sock = sock;
		clients = new HashMap();
	}

	@Override
	public void run() {
		try {
			oos = new ObjectOutputStream(sock.getOutputStream());
			ois = new ObjectInputStream(sock.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}

		String name = "";// 대화명을 저장할 변수
		try {
			name = ois.toString();
			clients.put(name, oos);// HashMap에 서버에 접속한 클라이언트를 저장한다.
			System.out.println("현재 서버접속자 수는 " + clients.size() + "입니다.");

			Object obj = null;
			
			obj = ois.readObject();
					
			while (obj != null) {
				SendData sd = (SendData) obj;
				int op1 = sd.getOp1();
				int op2 = sd.getOp2();
				String opcode = sd.getOpcode();

				if (opcode.equals("+")) {
					oos.writeObject(op1 + " + " + op2 + " = " + (op1 + op2));
					oos.flush();
				} else if (opcode.equals("-")) {
					oos.writeObject(op1 + " - " + op2 + " = " + (op1 - op2));
					oos.flush();
				} else if (opcode.equals("*")) {
					oos.writeObject(op1 + " * " + op2 + " = " + (op1 * op2));
					oos.flush();
				} else if (opcode.equals("/")) {
					if (op2 == 0) {
						oos.writeObject("0으로 나눌수 없습니다.");
						oos.flush();
					} else {
						oos.writeObject(op1 + " / " + op2 + " = " + (op1 / op2));
						oos.flush();
					}
				}
			}
			System.out.println("결과를 전송하였습니다.");
		} catch (Exception e) {
			System.out.println("사용자가 비정상적으로 종료함.");
		} finally {
			// 접속해제
			clients.remove(name);
			System.out.println("[" + sock.getInetAddress() + "]"
					+ "에서 접속을 종료하였습니다..");
			System.out.println("현재 서버접속자 수는 " + clients.size() + "입니다.");
			try {
				if (oos != null)
					oos.close();
				if (ois != null)
					ois.close();
				if (sock != null)
					sock.close();
			} catch (Exception ex) {
				System.out.println("사용자가 비정상적으로 종료함.");
			}
		}
	} // run()
}
