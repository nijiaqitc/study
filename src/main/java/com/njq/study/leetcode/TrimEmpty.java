package com.njq.study.leetcode;

import java.util.Arrays;

public class TrimEmpty {

    public static void main(String[] args) {
        trim();
    }

    private static String str = "   abc   ";
    private static void trim(){
        char[] chars = str.toCharArray();
        int st = 0;
        int len = chars.length;
        while (chars[len-1]==' '){
            len--;
        }
        while(chars[st]==' '){
            st++;
        }
        System.out.println(Arrays.copyOfRange(chars,st,len));
    }
}
