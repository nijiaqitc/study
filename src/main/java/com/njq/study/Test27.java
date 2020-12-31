package com.njq.study;

import com.sun.xml.internal.ws.assembler.jaxws.TerminalTubeFactory;
import org.joda.time.DateTime;

public class Test27 {


    public static void main(String[] args) {
//        Boolean aa = Boolean.FALSE;
//        aa = null;
//        if (aa instanceof Boolean) {
//            System.out.println(true);
//        } else {
//            System.out.println(false);
//        }

//        test(11);
        DateTime firstDay =DateTime.now().dayOfMonth().withMinimumValue();
        System.out.println(DateTime.now().monthOfYear().withMaximumValue().getMonthOfYear());
        System.out.println(firstDay.plusMonths(1).monthOfYear().get());
        System.out.println(firstDay.plusMonths(2).monthOfYear().get());

//        System.out.println(DateTime.now().dayOfMonth().withMinimumValue().toString("yyyy-MM-dd"));
    }


    public static void test(double a){
        System.out.println("double");
    }

    public static void test(long a){
        System.out.println("long");
    }

//    public static void test(int a){
//        System.out.println("int");
//    }
}
