package com.njq.study.base;

import java.lang.reflect.Field;

/**
 * final关键字 编译器自动优化
 */
public class FinalMajor {

    public static void main(String[] args) throws Exception {
        /**
         * str1在编写时已经有确定的值，
         * 编译器对它进行优化在加载它的时候通过静态绑定已经直接对它进行赋值了
         * 所以获取这个变量时，从常量池中获取这个类的这个字段，发现已经有值了，所以直接返回这个值，进而不会对这个类进行初始化
         * 不会执行静态代码块----执行类初始化
         */
        System.out.println(FinalMajora.str1);
        /**
         * str2在编写值没有明确的值，
         * 类加载时不会在常量池中对这个变量赋值，
         * 当访问获取这个变量，发现没有值，那么就进行类的初始化，
         * 然后获取初始化的值
         * 它会触发类初始化----执行类初始化
         */
        System.out.println(FinalMajora.str2);
        System.out.println("------------");
        /**
         * str3虽然不是static的但已经确定好值了，所以也会在类加载的时候在常量池中确定好值
         * 在实例化后会有一个指向常量的引用在常量中
         * 当进行反射修改，它是直接搜在堆中这个类信息，然后修改堆中str3的值的信息
         * 当直接调用这个对象的这个变量，首先它会找到这个堆中对象的class，然后在常量池中找到这个class信息，
         * 找到str3的信息，发现已经赋值了，所以直接拿这个值返回即可（所以还是原始的值oldValue）
         * 当用反射获取这个值时，它是直接在堆中找到这个变量的区域，找到它的值，但因为已经被改了，
         * 所以是newValue
         * 所以用两种方式获取的值不一样
         */
        Field field1 = FinalMajora.class.getField("str3");
        field1.setAccessible(true);
        FinalMajora major1 = new FinalMajora("setValue");
        field1.set(major1, "newValue");
        System.out.println(field1.get(major1));
        System.out.println(major1.str3);
        System.out.println("-------");

        /**
         * 定义final变量如果不赋值，则必须在构造函数中赋值
         * 如果是static final 变量 则必须在static{}静态块中赋值
         *
         *
         * str4不是static的，由于它不确定具体是什么值，所以类加载的时候不会在常量池中设置它的值，
         * 当类实例化后，通过构造函数为这个变量赋值setValue值，直接用这个对象调用这个变量，先根据对象找到这个class，然后在方法区中的常量池中找到这个class信息，找到这个str4变量
         * 发现没有赋值，然后返回它的偏移量，然后在堆中根据这个偏移量找到这个变量的值
         * 因为它已经被反射修改了 所以是setValue1
         * 因此反射和用对象调用这个值，都是相同的
         */
        Field field2 = FinalMajora.class.getField("str4");
        field2.setAccessible(true);
        field2.set(major1, "setValue1");
        System.out.println(field2.get(major1));
        System.out.println(major1.str4);

        /**
         * 总结下：类加载的时候会把类的信息存储在常量池中，如果final变量已经确定好值了，这个值也会存储在常量池中
         * 当用对象调用这个变量时，首先会在堆中确定这个堆所归属的class，然后在常量池中找到这个类信息确定这个变量，
         * 然后找到它的偏移量（类在编译时早已经确定好了每个变量占用多少空间，变量的偏移量也都是确定好的），
         * 然后在返回堆中根据这个偏移量找到这个变量的值，如果常量池中已经有确定的值了，所以就直接返回了，不在搜索堆中的值
         * 这个就是编译器的优化
         */
    }
}
