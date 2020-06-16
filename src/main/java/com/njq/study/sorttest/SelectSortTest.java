package com.njq.study.sorttest;

public class SelectSortTest {

    public static void main(String[] args) {
        int[] num = {3, 45, 78, 64, 52, 11, 64, 55, 99, 11, 18};
        sort(num);
        SortPrint.out(num);
    }

    public static void sort(int[] array) {
        for (int i = 0; i < array.length + 1; i++) {
            int temp = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[temp] > array[j]) {
                    temp = j;
                }
            }
            if (i < temp) {
                int tempVal = array[temp];
                array[temp] = array[i];
                array[i] = tempVal;
            }
        }
    }
}
