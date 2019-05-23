package com.njq.study.base;

/**
 * 内部类可以获取外部类的属性
 */
public class InnerTesta {
    private int val = 1;

    public class InnerTestb {
        public void invoke() {
            InnerTesta.this.invokeFun();
        }
    }

    private void invokeFun() {
        System.out.println("外部私有方法执行" + val);
    }

    public InnerTestb getObj() {
        return new InnerTestb();
    }
}
