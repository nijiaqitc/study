package com.njq.study.sorttest;

public class CountSortTest {

    public static void main(String[] args) {
        int a[] = {100, 93, 97, 92, 96, 99, 92, 89, 93, 97, 90, 94, 92, 95};
        SortPrint.out(sort(a));
    }

    public static int[] sort(int[] array) {
        int min = array[0], max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
            }
            if (array[i] > max) {
                max = array[i];
            }
        }
        int[] a = new int[max - min + 1];
        for (int i = 0; i < array.length; i++) {
            ++a[array[i]-min];
        }
        for (int i = 1; i < a.length; i++) {
            a[i] = a[i] + a[i - 1];
        }
        int[] b = new int[array.length];
        for (int i = 0; i < b.length; i++) {
            b[--a[array[i] - min]] = array[i];
        }
        return b;
    }
}
