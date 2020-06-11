package com.njq.study.base;

import java.util.ArrayList;
import java.util.List;

public class StackException {
    public static void main(String[] args) {
        //模拟堆栈溢出的场景
//        ClassA a = new ClassA();
//        a.toString(new ClassB());

//        testRecursion(100000);

        List<String> list = new ArrayList<String>();
        /*循环创建对象，消耗堆内存*/
        //设置内存大小为 -Xmx1m ， 这样就会出现 OutOfMemoryError错误
        for (int i= 0;i < 100000;i++){
            list.add(new String("test"));
        }

    }

    public static class ClassA {
        public String toString(ClassB b) {
            return b.toString(this);
        }
    }

    public static class ClassB {
        public String toString(ClassA a) {
            return a.toString(this);
        }
    }

    private static void testRecursion(int n){
        n--;
        //递归，结束条件
        if (n == 0){
            return;
        }
        testRecursion(n);
    }

}
