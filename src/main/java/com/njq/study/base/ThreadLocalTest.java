package com.njq.study.base;

import com.njq.study.model.Man;

import java.lang.ref.WeakReference;

public class ThreadLocalTest {
    private static ThreadLocal<String> local1 = new ThreadLocal();
    private static ThreadLocal<Man> local2 = new ThreadLocal() {
        @Override
        protected Object initialValue() {
            Man rule = new Man();
            rule.setName("123");
            return rule;
        }
    };

    public static void main(String[] args) {
//        local1.set("123");
//
//        Man m = local2.get();
//        m.setName("456");
//        System.out.println(m.getName());
//        System.out.println(local2.get().getName());
//
//        local2.set(new Man());
//        System.out.println(local2.get().getName());

//        String abc = new String("123");
//        WeakReference<String>  wf = new WeakReference<>(abc);
        WeakReference<String>  wf = new WeakReference<>(new String("123"));
        System.out.println(wf.get());
        System.gc();
        System.out.println(wf.get());
    }
}
