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
    }

    private String getvaaa(){
        return "123";
    }


}
