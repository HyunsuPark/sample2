package com.chat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public  class  ChatServer  {
    BufferedWriter  writer=null;
    Socket  socket=null;
    ServerSocket  server  =  null;

    public  void  serverStart(){
            System.out.println("접속자를  기다리는  중입니다.");
            try  {
                    server  =  new  ServerSocket(57891);
                    socket  =  server.accept();
                    writer  =  new  BufferedWriter(new  OutputStreamWriter(socket.getOutputStream()));
                  
                    System.out.println("클라이언트  IP:  "  +  socket.getInetAddress().getHostAddress()  +  "  이름:  "  +    socket.getInetAddress().getHostName()  +  "  연결되었습니다.");
                    //Client와  통신할  스레드  구현  클래스
                    ChatServerHandler  handler  =  new  ChatServerHandler(socket);
                    handler.start();
                    BufferedReader  in  =  new  BufferedReader(new  InputStreamReader(System.in));                    
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
                    System.err.println("Exception  generated...");
            }  finally  {
                    try  {
                            server.close();
                    }  catch(IOException  ignored)  {}
            }
          
    }

    public  static  void  main(String[]  args)  {
            ChatServer  cs  =  new  ChatServer();
            cs.serverStart();
    }
}