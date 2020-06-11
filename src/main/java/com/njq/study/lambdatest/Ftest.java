package com.njq.study.lambdatest;

/**
 * @author: nijiaqi
 * @date: 2019/12/20
 */
public class Ftest {
    public static void main(String[] args) {
        Lservice lservice = new Lservice();
        Ftest t1 = new Ftest();
        lservice.get(t1::getvaaa);
        lservice.get(t1::getv);

        lservice.get(() -> {
            return "a";
        });
//        System.out.println(t1::getv);

        Rservice rservice = new Rservice();
        rservice.get((n) -> n);

    }

    private String getvaaa() {
        return "123";
    }

    private String getv() {
        return "345";
    }
}
