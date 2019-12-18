package com.njq.study.socket.nio;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 * @author: nijiaqi
 * @date: 2019/12/16
 */
public class Client1 {
    public static void main(String argv[]) throws UnknownHostException, IOException {
        String str[] = {"4", "5", "6"};
        Socket socket = new Socket("localhost", 8080);
        DataInputStream input = new DataInputStream(socket.getInputStream());
        DataOutputStream output = new DataOutputStream(socket.getOutputStream());
        for (String str1 : str) {
            output.writeUTF(str1);
            String yourStr = input.readUTF();
            System.out.println(yourStr);
        }
        socket.close();
    }
}
