package com.njq.study.sorttest;

public class ShellSortTest {
    public static void main(String[] args) {
        int[] num = {3, 45, 78, 64, 52, 11, 64, 55, 99, 11, 18};
        sort(num);
        SortPrint.out(num);
    }

    public static void sort(int[] arrays) {
        int mid = arrays.length;
        while (true) {
            mid = mid / 2;
            for (int i = 0; i < mid; i++) {
                for (int j = i + mid; j < arrays.length; j += mid) {
                    int val = arrays[j];
                    int k;
                    for (k = j; k > mid && arrays[k - mid] > arrays[k]; k -= mid) {
                        arrays[k] = arrays[k-mid];
                    }
                    arrays[k] = val;
                }
            }
            if(mid == 1){
                break;
            }
        }
    }

}
