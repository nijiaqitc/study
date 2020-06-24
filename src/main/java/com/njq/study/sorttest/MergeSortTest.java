package com.njq.study.sorttest;

public class MergeSortTest {

    public static void main(String[] args) {
        int[] num = {3, 45, 78, 64, 52, 11, 64, 55, 99, 11, 18};
        int[] num1 = sort(num, 0, num.length - 1);
        SortPrint.out(num1);
    }

    public static int[] sort(int[] array, int left, int right) {
        if (left >= right) {
            return new int[]{array[left]};
        }
        int mid = (left + right) / 2;
        int[] lefta = sort(array, left, mid);
        int[] righta = sort(array, mid + 1, right);
        int[] newa = new int[lefta.length + righta.length];
        int i = 0, j = 0, k = 0;
        while (i < lefta.length && j < righta.length) {
            newa[k++] = lefta[i] < righta[j] ? lefta[i++] : righta[j++];
        }
        while (i < lefta.length) {
            newa[k++] = lefta[i++];
        }
        while (j < righta.length) {
            newa[k++] = righta[j++];
        }
        return newa;
    }


}
