package com.chat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Enumeration;

public  class  ChatServer  {
    BufferedWriter  writer=null;
    Socket  socket=null;
    ServerSocket  server  =  null;

    public  void  serverStart() throws UnknownHostException{
    		InetAddress Address = InetAddress.getLocalHost();
    	
            System.out.println(getLocalIpAddress()+"로 접속하세요.");
            try  {
                    server  =  new  ServerSocket(57891);
                    socket  =  server.accept();
                    writer  =  new  BufferedWriter(new  OutputStreamWriter(socket.getOutputStream()));
                  
                    System.out.println("연결되었습니다.");
                    //Client와  통신할  스레드  구현  클래스
                    ChatServerHandler  handler  =  new  ChatServerHandler(socket);
                    handler.start();
                  
                    BufferedReader  in  =  new  BufferedReader(new  InputStreamReader(System.in,"utf-8"));                    
                    String  s="";
                  
                    while(true)  {
                            try  {
                                System.out.print("☞  ");
                                s  =  in.readLine();  //키보드로부터  입력
                                if(s.equals("999"))  break;  //종료코드
                                writer.write(s);
                                writer.newLine();    //줄바뀜  기호가  있어야  BufferedReader의  readLine()이  인식함
                                writer.write("---------------------------------------------------------------");
                                writer.newLine();
                                writer.flush();
                            }  catch  (Exception  e)  {
                                System.out.println("Error:  "  +  e.toString());
                            }      
                            //System.out.println("보낸  글:"  +  s);//입력받은  내용  출력
                    }
            }  catch(IOException  ioe)  {
            	System.err.println("오류로 인해 연결이 종료되었습니다.");
            }  finally  {
                    try  {
                            server.close();
                    }  catch(IOException  ignored)  {
                    	System.err.println("오류로 인해 연결이 종료되었습니다.");
                    }
            }
          
    }

    public String getLocalIpAddress() {
        try {
            for (Enumeration<NetworkInterface> en = NetworkInterface
                    .getNetworkInterfaces(); en.hasMoreElements();) {
                NetworkInterface intf = en.nextElement();
                for (Enumeration<InetAddress> enumIpAddr = intf
                        .getInetAddresses(); enumIpAddr.hasMoreElements();) {
                    InetAddress inetAddress = enumIpAddr.nextElement();
                    if (!inetAddress.isLoopbackAddress()) {
                        return inetAddress.getHostAddress().toString();
                    }
                }
            }
        } catch (SocketException ex) {
            
        }
        return "";
    }
    
    public  static  void  main(String[]  args) throws UnknownHostException  {
            ChatServer  cs  =  new  ChatServer();
            cs.serverStart();
    }
}