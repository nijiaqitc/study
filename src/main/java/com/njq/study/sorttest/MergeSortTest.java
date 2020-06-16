package com.njq.study.sorttest;

public class MergeSortTest {

    public static void main(String[] args) {
        int[] num = {3, 45, 78, 64, 52, 11, 64, 55, 99, 11, 18};
        int[] num1 = sort(num, 0, num.length - 1);
        SortPrint.out(num1);
    }

    public static int[] sort(int[] arrays, int left, int right) {
        if (left >= right) {
            return new int[]{arrays[left]};
        }
        int mid = (left + right) / 2;
        int[] leftarray = sort(arrays, left, mid);
        int[] rightarray = sort(arrays, mid + 1, right);
        int[] newarray = new int[leftarray.length + rightarray.length];
        int i = 0, j = 0, k = 0;
        while (i < leftarray.length && j < rightarray.length) {
            newarray[k++] = leftarray[i] < rightarray[j] ? leftarray[i++] : rightarray[j++];
        }
        while (i < leftarray.length) {
            newarray[k++] = leftarray[i++];
        }
        while (j < rightarray.length) {
            newarray[k++] = rightarray[j++];
        }
        return newarray;
    }


}
