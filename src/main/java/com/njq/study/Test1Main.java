package com.njq.study;


import org.springframework.beans.BeanUtils;

import javax.sound.midi.Soundbank;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.time.Period;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * @author: nijiaqi
 * @date: 2019/7/3
 */
public class Test1Main {

    public static void main(String[] args) throws Exception {
//        A a = new Test1Main.A();
//        B b = new Test1Main.B();
//        C c =new Test1Main.C();
//
//
//        aaa(c);


//        String abc  = "1111,2222,3333";
//        Set<String> sets = new HashSet<>(Arrays.asList(abc.split(",")));
//        System.out.println(sets.size());
//        System.out.println(sets);
//        DecimalFormat decimalFormat = new DecimalFormat("0.##");
//        System.out.println(decimalFormat.format(4.0));


//        List<TestA> l1 = new ArrayList<>();
//        TestA a = new TestA();
//        a.setName("1111");
//        l1.add(a);
//        TestA b = new TestA();
//        List<TestA> l2 = new ArrayList<>();
//        BeanUtils.copyProperties(a, b);
//        BeanUtils.copyProperties(l1, l2);
//        System.out.println(l2);

//        try {
//            System.out.println(URLEncoder.encode("乔先生的黑月光 ", "utf-8"));
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }

//        %E7%A5%9E%E7%A7%98%E5%A4%8D%E8%8B%8F


//        String abc = "aa";
//        abc += "bb";
//        String bcd ="aa";
//        bcd += "bb";
//        System.out.println(abc.intern() == bcd.intern());

//        List<String> aa = new ArrayList<>();
//        aa.add("11");
//        aa.add("22" );
//        String opt = aa.stream().filter(n->n=="33").findFirst().orElse(null);
//        System.out.println(opt);


//        String created = "2019-09-16 20:29:01";
//        Date createdAt = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(created);
//        System.out.println(createdAt);
//        Date now = new Date();
//        System.out.println(now.after(new DateTime(chanceData.getUpdatedAt()).plusMinutes(5).toDate()));

//        Testa1 a1 = new Testa1();
//
//        Thread t1 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                a1.test1();
//            }
//        });
//
//        Thread t2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(a1.getValue());
//            }
//        });
//
//        t1.start();
//        t2.start();

        aaa a = new bbb();
        a.c1.getValue();
        ((bbb)a).c1.getValue();
//        System.out.println();?
//        System.out.println();
    }


    public static  class  aaa{
        public String aqaq="1";
        public ccc c1;

        public aaa() {
            c1 = new ccc();
            c1.aqaq="1212121";
        }
    }

    public static  class  bbb extends aaa{
        public String aqaq="2";
        public ccc c1;
        public bbb() {
            c1 = new ccc();
            c1.aqaq="2323232323";
        }

    }

    public static  class  ccc {
        public String aqaq="3";

        public void getValue(){
            System.out.println(aqaq);
        }
    }




    public static class Testa1{
        public  Integer abc = null;

        public synchronized void test1(){
            try {
                System.out.println("进入1");
                Thread.sleep(2000);
                abc =1;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        public   Integer getValue(){
            return  abc;
        }
    }


    public static void aaa(B b) {

        System.out.println(b instanceof D);
    }

    public static class A {

    }


    public static class B extends A {

    }


    public static interface D {

    }

    public static class C extends B implements D {

    }

}
