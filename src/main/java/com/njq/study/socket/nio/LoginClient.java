package com.njq.study.socket.nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class LoginClient {
    public static void main(String[] args) {  
        try {  
            //1.建立客户端socket连接，指定服务器位置及端口  
            Socket socket =new Socket("localhost",8800);
            //2.得到socket读写流  
            PrintWriter pw=new PrintWriter(socket.getOutputStream(),true);
            BufferedReader br=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            //3.利用流按照一定的操作，对socket进行读写操作  
            String info="用户名：Tom,用户密码：123456";  
            pw.write(info);  
//            socket.shutdownOutput();
            //接收服务器的相应  
            String reply=null;  
            while(!((reply=br.readLine())==null)){  
                System.out.println("接收服务器的信息："+reply);  
            }  
            //4.关闭资源  
            br.close();  
            pw.close();
            socket.close();
        } catch (UnknownHostException e) {  
            e.printStackTrace();  
        } catch (IOException e) {
            e.printStackTrace();  
        }  
    }  
} 