package com.njq.study.base;

/**
 * 多态调用重载方法的方式，它是根据静态类型来查找方法
 */
public class StaticBand {

    private String staticBand = "staticBand";

    public void modiVaule() {
        this.staticBand = "modiValue";
    }

    public class A {
        public void getName() {
            System.out.println("A");
        }
    }

    public class B extends A {
        //动态绑定的
        @Override
        public void getName() {
            //调用外围的变量
            System.out.println(StaticBand.this.staticBand);
            System.out.println("B");
        }
    }

    public class C extends A {
        //动态绑定的
        @Override
        public void getName() {
            System.out.println("C");
        }
    }

    //静态绑定的 A方法
    public void setValue(A a) {
        System.out.println("进入A");
        a.getName();
    }

    //静态绑定的 B方法
    public void setValue(B b) {
        System.out.println("进入B");
        b.getName();
    }

    //静态绑定的 C方法
    public void setValue(C c) {
        System.out.println("进入C");
        c.getName();
    }

    public static void main(String[] args) {
        StaticBand bd = new StaticBand();
        //修改属性变量值
        bd.modiVaule();
        A a = bd.new B();
        A b = bd.new C();
        /**
         * 由于重载是静态绑定的，所以只会调用A方法
         * 一旦把A方法删除 直接编译报错，说明是在编译时绑定的
         * 而内部打印的值不一样所以传入的对象内部是动态绑定的
         * 因为重写override是动态绑定的。
         * 实现接口也算重写
         */
        bd.setValue(a);
        bd.setValue(b);


    }

}
