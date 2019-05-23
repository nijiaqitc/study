package com.njq.study.unmodiobj;

import java.lang.reflect.Field;

/**
 * 通过反射破坏不变类对象
 */
public class ModiUnModiObj {

    /**
     * 证明不可变对象其实可以是改变的，可以通过反射的方式进行修改
     * 修改不可变对象的值
     *
     * @author Administrator
     */
    public static void main(String[] args) {
        try {
            String s = "Hello World";
            //Hello World
            System.out.println("s = " + s);
            //获取String类中的value字段
            Field valueFieldOfString = String.class.getDeclaredField("value");
            //改变value属性的访问权限
            valueFieldOfString.setAccessible(true);
            //获取s对象上的value属性的值
            char[] value = (char[]) valueFieldOfString.get(s);
            //改变value所引用的数组中的第5个字符
            value[5] = '_';
            //Hello_World
            System.out.println("s = " + s);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }
}
