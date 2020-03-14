package com.njq.study;

import java.util.Arrays;

public class Taa {
    public static void main(String[] args) {
        char[] bb = new char[]{'a','b','a','b','a','b','b'};
        int[] ab = getNexts(bb,7);
        Arrays.stream(ab).forEach(n->{
            System.out.println(n);
        });
    }

    private static int[] getNexts(char[] b, int m) {
        int[] next = new int[m];
        next[0] = -1;
        int k = -1;
        for (int i = 1; i < m; ++i) {
            while (k != -1 && b[k + 1] != b[i]) {
                k = next[k];
            }
            if (b[k + 1] == b[i]) {
                ++k;
            }
            next[i] = k;
        }
        return next;
    }
}
