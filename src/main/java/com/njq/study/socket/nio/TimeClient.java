package com.njq.study.socket.nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author: nijiaqi
 * @date: 2019/12/16
 */
public class TimeClient {
    public static void main(String[] args) {
        int port = 8800;
        Socket socket = null;
        BufferedReader in = null;
        PrintWriter out = null;
        try {
            socket = new Socket("127.0.0.1",port);
            in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            out = new PrintWriter(socket.getOutputStream(),true);
            out.println("QUERY TIME ORDER");
//            socket.shutdownOutput();
            out.flush();
            System.out.println("SEND order 2 server succedd.");
            System.out.println("ddddddddddddddddddd");
            String resp  = in.readLine();
            System.out.println("Now is :"+resp);
            out.println("success");
            socket.shutdownOutput();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(out != null){
                out.close();
                out = null;
            }
            if(in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                in = null;
            }
            if(socket != null){
                try {
                    socket.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                socket = null;
            }
        }

    }
}
