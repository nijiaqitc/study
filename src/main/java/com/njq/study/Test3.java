package com.njq.study;

import com.njq.study.model.Person;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.List;

/**
 * @author: nijiaqi
 * @date: 2019/5/25
 */
public enum Test3 {
    AAA("1") {
        @Override
        void fun() {
            System.out.println(11);
        }
    }, BBB("2") {
        @Override
        void fun() {
            System.out.println(22);
        }
    };
    String abc;
    Test3(String abc) {
        this.abc = abc;
    }

    abstract void fun();


    public static void main(String[] args) {


        List<String> aaa1= new ArrayList<>();
        aaa1.add("111");
        aaa1.add("222");
        aaa1.add("333");
        System.out.println(Arrays.toString(aaa1.subList(0,2).toArray()) );


        String aaa = "\n";


        System.out.println(getBindId(aaa));
    }


    private static String getBindId(String url) {
        String[] urlStrArea = url.split("\\?")[0].split("\\/");
        if (urlStrArea.length < 3) {
            return null;
        }
        return urlStrArea[urlStrArea.length - 2] + "/" + urlStrArea[urlStrArea.length - 1];
    }
}
