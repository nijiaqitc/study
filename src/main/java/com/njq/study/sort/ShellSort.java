package com.njq.study.sort;

/**
 * @author: nijiaqi
 * @date: 2019/11/1
 */
public class ShellSort {
    public static void shellSort(int[] arrays) {
        int mid = arrays.length;
        while (true) {
            mid = mid / 2;
            for (int i = 0; i < mid; i++) {
                for (int j = i + mid; j < arrays.length; j += mid) {
                    int key = arrays[j];
                    int k;
                    for (k = j; k > mid && arrays[k - mid] > key; k -= mid) {
//                        System.out.println(k);
                        arrays[k] = arrays[k - mid];
//                        System.out.println("-------"+k+mid +(k-mid));
                    }
                    arrays[k] = key;
                }
            }
            if (mid == 1) {
                break;
            }
        }
    }
}
