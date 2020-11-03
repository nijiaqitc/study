package com.njq.study;

public class Test27 {


    public static void main(String[] args) {
        Boolean aa = Boolean.FALSE;
        aa = null;
        if (aa instanceof Boolean) {
            System.out.println(true);
        } else {
            System.out.println(false);
        }
    }
}
