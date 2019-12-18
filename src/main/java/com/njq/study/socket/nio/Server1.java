package com.njq.study.socket.nio;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author: nijiaqi
 * @date: 2019/12/16
 */
public class Server1 {
    public static void main(String argv[]) throws UnknownHostException, IOException {
        String str[] = {"1", "2", "3"};
        ServerSocket server = new ServerSocket(8080);
        Socket socket = server.accept();
        System.out.println("succeed");
        DataInputStream input = new DataInputStream(socket.getInputStream());
        DataOutputStream output = new DataOutputStream(socket.getOutputStream());
        for (String str1 : str) {
            String yourStr = input.readUTF();
            System.out.println("收到消息:" + yourStr);
            output.writeUTF("回复："+str1);
        }
        socket.close();
        server.close();
    }
}
