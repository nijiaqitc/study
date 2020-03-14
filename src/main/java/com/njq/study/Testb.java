package com.njq.study;

import java.util.concurrent.TimeUnit;

public class Testb {


    public static void main(String[] args) {
        Testb1 b1 = new Testb1();

        new Thread(new Runnable(){
            @Override
            public void run() {
//                    Testb1.getstaticvalue();
                    Testb1.getstaticfinalvalue();
//                b1.getvalue("1");

            }
        }).start();
        new Thread(new Runnable(){
            @Override
            public void run() {
//                b1.getvalue("2");
                Testb1.getstaticvalue();
//                b1.getv1();
            }
        }).start();
    }
}
