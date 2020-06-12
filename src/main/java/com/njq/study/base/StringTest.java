package com.njq.study.base;

import java.lang.reflect.Field;

public class StringTest {
    public final String str ="oldValue";

    public static void main(String[] args) throws Exception {
//        Class c = FinalMajor.class;
//        System.out.println();
Class.forName("com.njq.study.base.FinalMajora");
        Field field1 = StringTest.class.getField("str");
        field1.setAccessible(true);
        StringTest t = new StringTest();
        field1.set(t, "newValue");


        System.out.println(field1.get(t));
        System.out.println(t.str);
    }
}
