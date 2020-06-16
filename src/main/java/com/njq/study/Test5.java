package com.njq.study;

import java.lang.ref.WeakReference;

public class Test5 {
    public static final WeakReference<String> reference = new WeakReference<>(new String("hello"));

    public static void main(String[] args) {
        System.out.println(reference.get());
        System.gc(); //垃圾回收
        System.out.println(reference.get());
    }
}
