package com.njq.study.socket.aa;



public class TimeServer {
    public static void main(String[] args) throws Exception {
        MultiplexerTimeServer timeServer = new MultiplexerTimeServer(8080);
        new Thread(timeServer, "NIO-MultiplexerTimeServer-001").start();
    }
}
