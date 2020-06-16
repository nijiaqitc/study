package com.njq.study.sorttest;

public class CountSortTest {

    public static void main(String[] args) {
        int a[] = {100, 93, 97, 92, 96, 99, 92, 89, 93, 97, 90, 94, 92, 95};
        SortPrint.out(sort(a));
    }

    public static int[] sort(int[] a) {
        int max = a[0], min = a[0];
        for (int a1 : a) {
            if (a1 > max) {
                max = a1;
            }
            if (a1 < min) {
                min = a1;
            }
        }
        int[] newarray = new int[max - min + 1];
        for (int i = 0; i < a.length; i++) {
            ++newarray[a[i] - min];
        }
        for (int i = 1; i < newarray.length; i++) {
            newarray[i] = newarray[i] + newarray[i - 1];
        }
        int b[] = new int[a.length];
        for (int i=0;i<a.length;i++){
            b[--newarray[a[i]-min]]=a[i];
        }
        return b;
    }
}
