package com.njq.study;

import java.util.concurrent.TimeUnit;

public class Testb1 {


    public synchronized static final void getstaticfinalvalue(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("static final");
    }

    public synchronized static void getstaticvalue(){
        System.out.println("static");
    }


    public synchronized void getvalue(String a){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("value"+a);
    }

    public void getv1(){
        System.out.println("v1");
    }
}
