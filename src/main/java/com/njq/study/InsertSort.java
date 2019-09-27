package com.njq.study;

import java.util.Arrays;

/**
 * @author: nijiaqi
 * @date: 2019/9/27
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] num = {3, 45, 78, 64, 52, 11, 64, 55, 99, 11, 18};
        sort2(num);
    }


    public static void sort(int[] arrays) {
        for (int i = 1; i < arrays.length; i++) {
            int val = arrays[i];
            int j;
            for (j = i; j > 0 && arrays[j - 1] > val; j--) {
                arrays[j] = arrays[j - 1];
            }
            arrays[j] = val;
        }

        Arrays.stream(arrays).forEach(n -> {
            System.out.print(n + " ");
        });
    }

    public static void sort2(int[] arrays) {
        for (int i = 1; i < arrays.length; i++) {
            int val = arrays[i];
            int j;
            for (j = i; j > 0 && arrays[j - 1] > val; j--) {
                arrays[j] = arrays[j - 1];
            }
            arrays[j] = val;
        }

        Arrays.stream(arrays).forEach(n -> {
            System.out.print(n + " ");
        });

    }

    public static void sort1(int[] arrays) {
        for (int i = 1; i < arrays.length; i++) {
            int val = arrays[i];
            int index = i - 1;
            while (index > 0 && arrays[index] > val) {
                arrays[index + 1] = arrays[index];
                index--;
            }
            arrays[index + 1] = val;
        }

        Arrays.stream(arrays).forEach(n -> {
            System.out.print(n + " ");
        });
    }


}
