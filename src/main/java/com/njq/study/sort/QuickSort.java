package com.njq.study.sort;

import java.util.Arrays;

/**
 * @author: nijiaqi
 * @date: 2019/9/27
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] num = {56,45,78,64,52,11,64,55,99,11,18};
//        sort(num,0 ,num.length-1);
        quickSort(num,0,num.length-1);
        System.out.println(arrayToString(num));
    }

    public static void quickSort(int[] arrays,int left,int right){
        if(left >=right){
            return;
        }
        int key = arrays[left];
        int l = left;
        int r = right;
        while(l<r){
            while (arrays[r]>=key&&r>l){
                r--;
            }
            while(arrays[l]<=key&&l<r){
                l++;
            }
            if(l<r){
                int temp = arrays[l];
                arrays[l]=arrays[r];
                arrays[r] = temp;
            }
        }
        if(left != l){
            arrays[left] = arrays[l];
            arrays[l] = key;
            quickSort(arrays,left,l-1);
        }
        quickSort(arrays,l+1 , right);
    }


    private static String arrayToString(int[] arr) {
        String str = "";
        for(int a : arr) {
            str += a + "\t";
        }
        return str;
    }


    public static  void sort(int[] arr, int left, int right) {
        if (left >= right){
            return;
        }
        int p = partition(arr, left, right);
        sort(arr, left, p - 1);
        sort(arr, p + 1, right);
    }

    public static int st(int[] arrays,int left  , int right){
        int key = arrays[left];
        int j = left;
        for (int i = left + 1; i <= right; i++) {
            if (key>arrays[i]) {
                j++;
                swap(arrays, j, i);
            }
        }
        swap(arrays, left, j);
        return j;
    }
    public static void swap(int[] arr, int i, int j) {
        if (i != j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }










    private static int partition(int[] arr, int left, int right) {
        int base = arr[left];//基准值，每次都把这个基准值抛出去，看成[left+1.....right]左闭右闭区间的排序

        int i = left; //对于上一行提到的[left+1.....right]区间，i表示 [left+1......i)左闭右开区间的值都小于等于base。

        int j = right;//对于上二行提到的[left+1.....right]区间，j表示 (j......right]左开右闭区间的值都大于等于base。

        while (i < j) {
            //从右到左扫描，扫描出第一个比base小的元素，然后j停在那里。
            while (j > i && arr[j]>=base){
                j--;
            }

            arr[i] = arr[j];

            //从左到右扫描，扫描出第一个比base大的元素，然后i停在那里。
            while (i < j && arr[i]<=base){
                i++;
            }

            arr[j] = arr[i];

        }

        arr[j] = base;
        return j;//返回一躺排序后，基准值的下角标
    }
}
