package com.njq.study.base;

/**
 * toString导致无限递归死循环的场景
 * 以及调用获取别的内部来执行这个内部类的外部私有方法
 */
public class InnerMain {
    public static void main(String[] args) {
        InnerTesta a = new InnerTesta();
        //通过实现内部类，来调用外部类的私有方法
        a.getObj().invoke();
    }

    /**
     * 不能这么写，调用此方法会报错， 因为拼接的是字符串，发现是引用对象，会调用它的toString，这样就会发生递归
     *
     * @return
     */
    @Override
    public String toString() {
        return "aaa" + this;
    }
}
