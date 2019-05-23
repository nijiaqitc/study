package com.njq.study.model;

/**
 * 类实例化时，父类会先实例化，
 * 在实例化的时候调用子类方法，此时子类还没实例化
 */
public class XiaoMi extends Phone {
    /**
     * 普通属性的赋值是在实例化构造函数的时候赋值的
     */
    private int v = 2;

    public XiaoMi(int v) {
        getName();
        this.v = v;
        getName();
    }

    @Override
    public void getName() {
        System.out.println(v);
    }

    /**
     * 优先初始化父类，在初始化父类的时候，子类不会被初始化，
     * 因此属性v只是在链接阶段赋予了默认值0
     * 只有在调用子类构造函数的时候才会赋予设置的值2
     *
     * @param args
     */
    public static void main(String[] args) {
        Phone p = new XiaoMi(5);
    }

}
