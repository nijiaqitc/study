package com.njq.study;

import java.util.concurrent.locks.LockSupport;

public class T3 {
    private static class Task extends Thread{
        private Thread other;
        public void run(){
            try {
                other.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("in one park");
            LockSupport.park();
//            LockSupport.unpark(this);
            System.out.println("out one park");
        }
    }
 
    public static void main(String[] args) {
        Task t1=new Task();
        t1.other=Thread.currentThread();
        t1.start();
        System.out.println("Main invoke unpark");
//        LockSupport.park(t1);
        LockSupport.unpark(t1);
        System.out.println("Main invoke unpark ok");
    }
 
}