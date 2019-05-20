package com.njq.study.base;

public class CustomInit {

    /**
     * 初始化顺序调试
     *
     * @param args
     */
    public static void main(String[] args) {
        /**
         * 证明：初始化子类之前会默认先调用父类默认构造，对父类进行初始化，
         * 初始化的顺序为先初始化成员变量，再初始化构造函数的内容
         * 父类初始化完毕后，再初始化子类，也是先初始化子类的成员变量，再初始化构造函数内容
         */
        new CustomInit().new Jeep();

        /**
         * 证明：如果手动编写父类带参构造函数，则子类必须手动super调用父类的构造，否则会报错
         * 它证明了系统会自动调用父类默认构造函数且super必须在第一行，否则会报错
         *
         *
         * 这种机制主要是为了确保子类在初始化的时候能保证父类的所有内容已经被初始化完成了，
         * 这样才能保证子类调用父类的任何属性都没问题
         */
        new CustomInit().new Man("名字");
    }

    private class Mouse {
        public Mouse() {
            System.out.println("mouse");
        }
    }

    private class Person {
        private Mouse mouse = new Mouse();

        public Person(String sex) {
            System.out.println(sex);
        }
    }

    private class Man extends Person {
        private Mouse mouse = new Mouse();

        public Man(String name) {
//			System.out.println(111); 在super之前会报错
            super("男");
            System.out.println(name);
        }

    }


    private class Car {
        public Mouse mouse = new Mouse();

        public Car() {
            System.out.println("111");
        }
    }

    private class Jeep extends Car {
        private Mouse mouse = new Mouse();

        public Jeep() {
            System.out.println("222");
        }
    }


}
