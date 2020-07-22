package com.njq.study.sorttest;

public class QuickSortTest {
    public static void main(String[] args) {
        int[] num = {18, 18, 45, 78, 64, 52, 11, 64, 55, 99, 11, 18};
        sort(num, 0, num.length - 1);
        SortPrint.out(num);
    }

    public static void sort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = array[left];
        int l = left;
        int r = right;
        while (l < r) {
            while (l < r && array[r] >= mid) {
                r--;
            }
            while (l < r && array[l] <= mid) {
                l++;
            }
            if (l != r) {
                int temp = array[r];
                array[r] = array[l];
                array[l] = temp;
            }
        }
        array[left] = array[l];
        array[l] = mid;
        sort(array, left, l - 1);
        sort(array, l + 1, right);
    }


}
