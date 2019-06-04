package com.njq.study;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author: nijiaqi
 * @date: 2019/5/22
 */
public class test1 {
    public static Unsafe getUnsafe() {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            return (Unsafe) field.get(null);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }




}
