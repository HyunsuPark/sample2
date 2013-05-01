package com.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ChatServerHandler extends Thread{
	 protected  Socket  socket;
     String  line;      //서버로부터  읽어온  문자열  저장      

     public  ChatServerHandler(Socket  socket)  {
             this.socket  =  socket;  
     }

     public  void  run()  {
             try  {
                     BufferedReader  reader  =  new  BufferedReader(new  InputStreamReader(socket.getInputStream(),"utf-8"));
                     while(true){
                             line  =  reader.readLine();
                             System.out.println("받은글:  "  +  line);
                             System.out.print("☞  ");
                     }

             }  catch(IOException  ignored)  {
             }  finally  {
                     try  {
                             socket.close();
                     }  catch(IOException  ignored)  {}
             }
     }

}
