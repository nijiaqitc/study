package com.njq.study.base.lock;

public class Testb {


    public static void main(String[] args) throws Exception {
        Testb1 b1 = new Testb1();

        new Thread(new Runnable() {
            @Override
            public void run() {
//                    Testb1.getstaticvalue();
//                    Testb1.getstaticfinalvalue();
//                b1.getvalue("1");
//                b1.getv2("1");

                try{

                    b1.getvalue("1");
                }catch (Exception e){

                }
            }

        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
//                b1.getvalue("2");
//                Testb1.getstaticvalue();
//                b1.getv1();
//                b1.getv2("2");
                b1.getvalu1("2");
            }
        }).start();
    }
}
