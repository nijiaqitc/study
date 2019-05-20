package com.njq.study.base;

/**
 * @author: nijiaqi
 * @date: 2019/5/20
 */
public class OverloadingVarargs {
    //动态数组参数
    static  void f(Character...args){
        System.out.println("first");
        for (Character c:args){
            System.out.println(" "+c);
        }
    }
    //动态数组参数
    static void f(Integer...args){
        System.out.println("second");
        for(Integer i:args){
            System.out.println(" "+i);
        }
    }
    //动态数组参数
    static void f(Long...args){
        System.out.println("third");
    }

    public static void main(String[] args) {
        f('a','b','c');
        f(1);
        f(2,1);
        f(0);
        f(0L);
        //无参数不确定调用哪个，这样会报错
        //f();
    }
}
