package com.njq.study.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;

public class CustomThread {


    private static class MyThreadDemo extends Thread {
        @Override
        public void run() {
            System.out.println(1111);
        }
    }


    /**
     * 实现多线程的3种方式
     *
     * @param args
     * @throws InterruptedException
     * @throws ExecutionException
     */
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        //1、thread实现线程
        Thread t1 = new CustomThread.MyThreadDemo();
        t1.start();
        System.out.println(2222);

        //2、利用runnable实现线程
        Thread t2 = new Thread(new MyRunDemo());
        t2.start();


        //3、利用线程池 future callable 实现线程
        FutureTask<String> ft = new FutureTask<String>(new MyCallDemo());
        Executors.newSingleThreadExecutor().execute(ft);
        System.out.println(ft.isDone());
        if (ft.isDone()) {
            System.out.println(ft.get());
        }
        System.out.println(ft.get());
    }


    private static class MyRunDemo implements Runnable {
        @Override
        public void run() {
            System.out.println(3333);
        }
    }


    private static class MyCallDemo implements Callable<String> {

        @Override
        public String call() throws Exception {
            System.out.println(4444);
            if (1 == 1) {
                throw new RuntimeException();
            }
            return "6666";
        }

    }


}
