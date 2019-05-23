package com.njq.study.base;

import java.util.Random;

/**
 * 编译器针对final的优化
 */
public class FinalMajora {
    public static final String str1 = "aaa";

    public static final String str2 = new Random().nextInt(11) + "";

    public final String str3 = "oldValue";

    public final String str4;

    public static final String str5;

    static {
        System.out.println("执行类初始化");
        str5 = "11";
    }

    public FinalMajora(String str4) {
        this.str4 = str4;
    }


}
