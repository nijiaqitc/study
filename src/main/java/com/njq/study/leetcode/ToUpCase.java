package com.njq.study.leetcode;

public class ToUpCase {

    public static void main(String[] args) {
//        toLowerCase();
        toUpCase();
    }

    private static String str = " abcid ";

    private static void toUpCase() {
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] > 96 && chars[i] < 123) {
                System.out.println((char) (chars[i] - 32));
            }
        }
    }

    private static void toLowerCase(){
        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] > 64 && chars[i] < 91) {
                System.out.println((char) (chars[i] - 32));
            }
        }
    }




}
