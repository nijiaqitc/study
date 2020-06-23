package com.njq.study.guava;

import java.util.stream.IntStream;

/**
 * 令牌桶测试类
 */
public class TokenBuckTest {
    public static void main(String[] args) {
        final TokenBuck tokenBuck = new TokenBuck(200);
        IntStream.range(0, 300).forEach(i -> {
            //目前测试时，让一个线程抢一次，不用循环抢
            //tokenBuck::buy 这种方式 产生一个Runnable
            new Thread(tokenBuck::buy).start();
        });
    }
}