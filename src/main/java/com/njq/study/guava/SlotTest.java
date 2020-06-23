package com.njq.study.guava;

import com.google.common.util.concurrent.RateLimiter;

import java.util.concurrent.TimeUnit;

public class SlotTest {
    public static void main(String[] args) {
        test5();
    }


    public static void test1() {
        //QPS = 5，每秒允许5个请求
        RateLimiter limiter = RateLimiter.create(5);
        //limiter.acquire() 返回获取token的耗时，以秒为单位
        System.out.println(limiter.acquire());
        System.out.println(limiter.acquire());
        System.out.println(limiter.acquire());
        System.out.println(limiter.acquire());
        System.out.println(limiter.acquire());
        System.out.println(limiter.acquire());
        System.out.println(limiter.acquire());
        System.out.println(limiter.acquire());
        System.out.println(limiter.acquire());
    }

    public static void test2() {
        //每秒允许5个请求，表示桶容量为5且每秒新增5个令牌，即每隔0.2毫秒新增一个令牌
        RateLimiter limiter = RateLimiter.create(5);
        //一次性消费5个令牌
        System.out.println(limiter.acquire(5));
        //limiter.acquire(1)将等待差不多1秒桶中才能有令牌
        System.out.println(limiter.acquire(1));
        //固定速率
        System.out.println(limiter.acquire(1));
        //固定速率
        System.out.println(limiter.acquire(1));
        //固定速率
        System.out.println(limiter.acquire(1));
    }

    public static void test3() {
        //每秒允许5个请求，表示桶容量为5且每秒新增5个令牌，即每隔0.2毫秒新增一个令牌
        RateLimiter limiter = RateLimiter.create(5);
        //第一秒突发了10个请求
        System.out.println(limiter.acquire(10));
        //limiter.acquire(1)将等待差不多2秒桶中才能有令牌
        System.out.println(limiter.acquire(1));
        //固定速率
        System.out.println(limiter.acquire(1));
        //固定速率
        System.out.println(limiter.acquire(1));
        //固定速率
        System.out.println(limiter.acquire(1));
    }


    public static void test4() {
        //permitsPerSecond:每秒新增的令牌数  warmupPeriod:从冷启动速率过渡到平均速率的时间间隔
        //系统冷启动后慢慢的趋于平均固定速率（即刚开始速率慢一些，然后慢慢趋于我们设置的固定速率）
        RateLimiter limiter = RateLimiter.create(10, 1000, TimeUnit.MILLISECONDS);
        for (int i = 0; i < 10; i++) {
            //获取一个令牌
            System.out.println(limiter.acquire(1));
        }
    }

    public static void test5() {
        //限流，每秒允许10个请求进入秒杀
        RateLimiter limiter = RateLimiter.create(10);
        for (int i = 0; i < 100; i++) {
            //100个线程同时抢购
            new Thread(() -> {
                //每个秒杀请求如果100ms以内得到令牌，就算是秒杀成功，否则就返回秒杀失败
                if (limiter.tryAcquire(50, TimeUnit.MILLISECONDS)) {
                    System.out.println("恭喜您，秒杀成功");
                } else {
                    System.out.println("秒杀失败，请继续努力");
                }
            }).start();
            //等待新的令牌生成
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
