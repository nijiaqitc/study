package com.njq.study.unmodiobj;

/**
 * 如何定义一个不可变对象
 */
//1、类要定义成final 不能继承
public final class UnModiObj {

    //2、属性要定义成私有和final
    private final String a;

    //3、赋值的时候要用复制的方式
    public UnModiObj(String bb) {
        this.a = String.copyValueOf(bb.toCharArray());
    }

    //4、返回的是要用复制的方式返回
    public String getValue() {
        return String.copyValueOf(a.toCharArray());
    }

    //5、不能设置set方法
//	public void setValue(String cc) {
//		this.a = String.copyValueOf(cc.toCharArray());
//	}

}
