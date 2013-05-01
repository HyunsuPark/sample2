package com.chat;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

class ChatClient{
	BufferedWriter  writer=null;
    
    Socket  socket  =  null;
    String  line;      //서버로부터  읽어온  문자열  저장
    int  cnt=0;
  
    public  void  clientStart(String  ip){
            System.out.println("클라이언트  프로그램  작동.....");
            try  {
                    socket  =  new  Socket(ip,  2006);
                    writer  =  new  BufferedWriter(new  OutputStreamWriter(socket.getOutputStream()));
                  
                    //Server와  통신할  스레드  구현  클래스
                    ChatClientHandler  handler  =  new  ChatClientHandler(socket);
                    handler.start();
                  
                    BufferedReader  in  =  new  BufferedReader(new  InputStreamReader(System.in,"utf-8"));                    
                    String  s="";
                  
                    while(true)  {
                            try  {
                                System.out.print("☞  ");      
                                s  =  in.readLine();  //키보드로부터  입력
                                if(s.equals("999"))  break;  //종료코드
                                writer.write(new String(s.getBytes("UTF-8")));
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
                            socket.close();
                    }  catch(IOException  ignored)  {}
            }
        
    }

    public  static  void  main(String[]  args)  {
            ChatClient  cc  =  new  ChatClient();
            cc.clientStart("127.0.0.1");
    }
}	

