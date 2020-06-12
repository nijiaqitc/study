package com.njq.study.simpleDubbo.test;


/**
 * Created by kai.yang on 2018/11/1.
 */
public class TestApiImpl implements TestApi{

    @Override
    public String sayHello() {
        System.out.println("进入测试类");
        return "你好，这是测试类";
    }

    @Override
    public String goBack(String nn) {
        return nn+"回家吧";
    }

    @Override
    public void sayVoid(int dd) {
        System.out.println("无返回值方法");
    }

    @Override
    public boolean sayboolean() {
        return false;
    }

    @Override
    public int setInt(int o) {
        return o;
    }
}
