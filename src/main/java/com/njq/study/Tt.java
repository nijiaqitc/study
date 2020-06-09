package com.njq.study;

import java.util.SortedSet;
import java.util.TreeSet;

/**
 * @author: nijiaqi
 * @date: 2020/1/21
 */
public class Tt {

    public static void main(String[] args) {
        TreeSet test = new TreeSet();
        System.out.println(SortedSet.class.isAssignableFrom(TreeSet.class));
    }
    public static int balancedStringSplit(String s) {
        int num = 0;
        int n = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i)=='R')
                n++;
            if (s.charAt(i) == 'L')
                n--;
            if (n == 0)
                num++;
        }
        return num;
    }

}
