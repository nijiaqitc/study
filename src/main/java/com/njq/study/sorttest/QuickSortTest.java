package com.njq.study.sorttest;

public class QuickSortTest {
    public static void main(String[] args) {
        int[] num = {3, 45, 78, 64, 52, 11, 64, 55, 99, 11, 18};
        sort(num, 0, num.length - 1);
        SortPrint.out(num);
    }

    public static void sort(int[] array, int left, int right) {
        if(left >=right){
            return;
        }
        int key = array[left];
        int l = left;
        int r= right;
        while(l<r){
            while(array[r]>=key&&l<r){
                r--;
            }
            while(array[l]<=key&&l<r){
                l++;
            }
            if(l<r){
                int temp = array[l];
                array[l]=array[r];
                array[r]=temp;
            }
        }
        if(l != left){
            array[left]=array[l];
            array[l]=key;
            sort(array,0,l-1);
        }
        sort(array,l+1,r-1);
    }


}
