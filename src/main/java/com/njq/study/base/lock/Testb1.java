package com.njq.study.base.lock;

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


    public synchronized void getvalue(String a) throws  Exception{
        try {
            System.out.println("valuesleep0");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        throw new Exception("11");
//        System.out.println("value"+a);
    }

    public synchronized void getvalu1(String a){
        System.out.println("value"+a);
    }

    public void getv1(){
        System.out.println("v1");
    }

    public void getv2(String a){
        try {
            System.out.println("valuesleep");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("value"+a);
    }
}
