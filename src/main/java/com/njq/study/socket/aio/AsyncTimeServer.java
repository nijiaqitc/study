package com.njq.study.socket.aio;

public class AsyncTimeServer {
 
    public static void main(String[] args) {
        AsyncTimeServerHandler timeServer = new AsyncTimeServerHandler(9999);
        new Thread(timeServer, "AIO-AsyncTimeServerHandler-001").start();
    }
 
}
