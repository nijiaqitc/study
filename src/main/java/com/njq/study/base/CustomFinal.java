package com.njq.study.base;

/**
 * 多态调用的实现
 */
public class CustomFinal {
    public static void main(String[] args) {
        Car car = new CustomFinal().new Jeep();
        //成员变量无法被多态化
        System.out.println(car.name);
        //父类的方法若定义为私有方法，则子类无法进行多态化
        car.ready();
        //方法为public、protected才能进行多态化
        car.run();
        //方法为final则无法被多态
        car.stop();
        /**
         * final、private、static修饰的方法以及构造函数（构造函数包括类成员属性）都是静态绑定的 无法被初始化，
         * 它是在编译时候就与类绑定生成好了
         *
         * 多态是根据动态绑定实现的，它是在程序运行过程中，根据具体的实例对象才能具体确定是哪个方法。
         * 它通过方法表来实现：每个类被加载到虚拟机时，在方法区保存元数据，
         * 其中，包括一个叫做 方法表（method table）的东西，表中记录了这个类定义的方法的指针，
         * 每个表项指向一个具体的方法代码。如果这个类重写了父类中的某个方法，则对应表项指向新的代码实现处。
         * 当调用普通方法时，首先会找到堆中这个实例指向的类，然后在方法区中找到类信息，找到方法表中的方法，因为它不是静态的，
         * 所以它的引用只是符号引用，确定这个偏移量后返回堆中，找到这个偏移量，找到堆中对象实际的引用然后执行方法（动态绑定）
         */


    }


    private class Car {
        public String name = "111";

        private void ready() {
            System.out.println("car ready");
        }

        protected void run() {
            System.out.println("car run");
        }

        public final void stop() {
            System.out.println("car stop");
        }

    }

    private class Jeep extends Car {
        public String name = "222";

        public void ready() {
            System.out.println("jeep ready");
        }

        @Override
        public void run() {
            System.out.println("jeep run");
        }

//		public void stop() {
//			System.out.println("jeep stop");
//		}
    }

}
