package com.njq.study.base;

/**
 * 类初始化和类实例化顺序颠倒的例子
 */
public class StaticTest {
    /**
     * 第二步，自顶向下开始查找static，
     * 然后开始初始化st值，因为它的值是实例化，
     * 所以先暂停类初始化，进入实例化
     */
    static StaticTest st = new StaticTest();

    /**
     * 第六步，类实例化完成后接着执行类初始化，打印1
     */
    static {
        System.out.println("1");
    }

    /**
     * 第三步，实例化先执行代码块或实例变量，执行顺序按代码编写顺序决定
     * 所以先打印 2
     */ {
        System.out.println("2");
        //类加载的时候c已经被加载进去了的，所以不会报错
        c = 122;
    }

    /**
     * 第四步，同第三步，进行赋值
     */
    int c = 121;

    /**
     * 第五步，执行构造函数
     * 打印 3
     * a=110,b=0（b的值还未进入类初始化阶段，因此只是类型的默认值）
     * 121
     */
    StaticTest() {
        System.out.println("3");
        System.out.println("a=" + a + ",b=" + b);
        System.out.println(c);
    }

    public static void staticFunction() {
        System.out.println("4");
    }

    int a = 110;
    static int b = 112;


    /**
     * 第一步，由main来触发类的初始化
     *
     * @param args
     */
    public static void main(String[] args) {
        /**
         * 第七步，都执行完成后执行main方法体
         * 打印4
         */
        staticFunction();
    }
}