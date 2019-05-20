package com.njq.study.base;

public class SameMethod {

    private interface TestE {
        String getV();
    }

    public class TestF implements TestE {
        @Override
        public String getV() {
            return "1111";
        }
    }

    public static void main(String[] args) {

//		System.out.println(new SameMethod().new TestF().getv);

        TestC c = new SameMethod().new TestD();
        c.getName();

    }

    public interface TestA {
        void getName();
    }


    public class TestB implements TestA {
        @Override
        public void getName() {
            System.out.println("A");
        }
    }


    public class TestC {
        /**
         * 被重写的方法返回的是父类
         *
         * @return
         */
        public TestA getName() {
            System.out.println("B");
            return null;
        }

        public final TestA getValue() {
            return null;
        }


    }


    public class TestD extends TestC {
        /**
         * 重写方法返回的可以是子类
         */
        @Override
        public TestB getName() {
            System.out.println("D");
            return null;
        }

        public final TestA getValue(String abc) {
            return null;
        }
    }

}
