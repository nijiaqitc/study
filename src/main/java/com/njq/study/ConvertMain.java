package com.njq.study;

/**
 * @author: nijiaqi
 * @date: 2019/10/28
 */
public class ConvertMain {
    public static ConvertMain  lock = new ConvertMain();
    public static void main(String[] args) {
        new Thread(new Task()).start();
        new Thread(new Task()).start();
        new Thread(new Task()).start();
        new Thread(new Task()).start();
    }

    static class Task implements Runnable {
        @Override
        public void run() {
            synchronized (lock) {
                try {
                    lock.wait();
                    //TimeUnit.SECONDS.sleep(100000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
