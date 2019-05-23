package com.njq.study.base;

import java.util.Arrays;
import java.util.Collection;

/**
 * 数组存储涉及多态类型的信息
 */
public class CollectionConvert {

    public interface A {
        String getName();
    }

    public class B implements A {

        @Override
        public String getName() {
            return "B";
        }

        protected void getValue() {
        }
    }

    public class C extends B {
        @Override
        public String getName() {
            return "C";
        }

        /**
         * 重写不能降低包的权限
         * 会报错
         */
//		@Override
//		void getValue() {
//			
//		}

        /**
         * 重写可以扩大包的权限
         */
        @Override
        public void getValue() {

        }

    }


    public static void main(String[] args) {
        CollectionConvert covert = new CollectionConvert();

        //创建内部类数组，数组中可以存储父类的子类
        B[] bx = new B[]{covert.new B(), covert.new C()};
        for (B x : bx) {
            System.out.println(x.getName());
        }

        Collection<B> col = Arrays.asList(covert.new B(), covert.new B(), covert.new B());
        for (B b : col) {
            System.out.println(b.getName());
        }
        //创建内部类数组，数组中可以存储父类的子类
        Collection<A> cola = Arrays.asList(covert.new C(), covert.new C(), covert.new B());
        for (A a : cola) {
            System.out.println(a.getName());
        }
    }

}
