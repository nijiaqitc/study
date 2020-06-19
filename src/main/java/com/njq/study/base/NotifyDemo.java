package com.njq.study.base;

public class NotifyDemo {

    private static void sleep(long sleepVal){
        try{
            Thread.sleep(sleepVal);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    private static void log(String desc){
        System.out.println(Thread.currentThread().getName() + " : " + desc);
    }

    Object lock = new Object();

    public void startThreadA(){
        new Thread(() -> {
            synchronized (lock){
                log("get lock");
                startThreadB();
                log("start wait");
                try {
                    sleep(10);
                    lock.wait();
                }catch(InterruptedException e){
                    e.printStackTrace();
                }

                log("get lock after wait");
                log("release lock");
            }
        }, "thread-A").start();

        new Thread(() -> {
            synchronized (lock){
                log("Dget lock");
                log("Drelease lock");
            }
        }, "thread-D").start();
    }

    public void startThreadB(){
        new Thread(()->{
            synchronized (lock){
                log("get lock");
                startThreadC();
                sleep(1000);
                log("start notify");
                lock.notify();
                log("release lock");

            }
        },"thread-B").start();
    }

    public void startThreadC(){
        new Thread(() -> {
            synchronized (lock){
                log("get lock");
                log("release lock");
            }
        }, "thread-C").start();
    }

    public static void main(String[] args){
        new NotifyDemo().startThreadA();
    }
}