package com.njq.study.base;

/**
 * @author: nijiaqi
 * @date: 2019/6/28
 */
public class TestImpl implements TestInterface {

    @Override
    public String test1() {
        System.out.println("方法1");
        return "方法1";
    }

    @Override
    public String test2(String v1) {
        System.out.println("方法2");
        return "方法2";
    }
}
