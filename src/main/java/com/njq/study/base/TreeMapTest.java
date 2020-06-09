package com.njq.study.base;

import java.util.TreeMap;

public class TreeMapTest {
    public static void main(String[] args) {
        TreeMap t = new TreeMap();
        t.put("a","a");
        t.put("b","a");

        //treemap将字符串强转成Comparable，然后比较  这个是自然排序的方式
        Comparable aaa = (Comparable)"a";
        System.out.println(aaa);
        System.out.println(aaa.compareTo("b"));
    }
}
