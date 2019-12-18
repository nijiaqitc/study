package com.njq.study.socket.aio;

/**
 * @author: nijiaqi
 * @date: 2019/12/18
 */
public class AsyncTimeClient {
    public static void main(String[] args) {
        int port = 9999;
        new Thread(new AsyncTimeClientHandler("127.0.0.1", port),"asynclient").start();
    }
}
