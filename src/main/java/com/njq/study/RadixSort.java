package com.njq.study;

import java.util.Arrays;

/**
 * @author: nijiaqi
 * @date: 2019/9/27
 */
public class RadixSort {

    public static void main(String[] args) {
        int[] num = {3, 45, 78, 64, 52, 11, 64, 55, 99, 11, 18};
        radixSort(num, 1);
        Arrays.stream(num).forEach(n -> {
            System.out.println(n);
        });
    }

    public static void radixSort(int[] arrays, int d) {
        int k = 0;
        int m = 1;
        int n = 1;
        int[][] temp = new int[10][arrays.length];
        int[] order = new int[10];
        while (m <= d) {
            for (int i = 0; i < arrays.length; i++) {
                int lsd = (arrays[i] / n) % 10;
                temp[lsd][order[lsd]] = arrays[i];
                order[lsd]++;
            }
            for (int i = 0; i < 10; i++) {
                if (order[i] != 0) {
                    for (int j = 0; j < order[i]; j++) {
                        arrays[k] = temp[i][j];
                        k++;
                    }
                }
                order[i] = 0;
            }
            n *= 10;
            k = 0;
            m++;
        }
    }
}
