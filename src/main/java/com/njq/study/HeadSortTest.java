package com.njq.study;

import java.util.Arrays;

/**
 * @author: nijiaqi
 * @date: 2019/10/17
 */
public class HeadSortTest {

    public static void main(String[] args) {
        int arrays[] = {93, 100, 97, 92, 96, 99, 92, 89, 93, 97, 90, 94, 92, 95};
        headSort(arrays);
        Arrays.stream(arrays).forEach(n -> {
            System.out.print(n + " ");
        });
    }

    public static void headSort(int[] arrays) {
        for(int i=arrays.length/2-1;i>=0;i--){
            adjustHeap(arrays, i, arrays.length);
        }
        for(int i=arrays.length-1;i>0;i--){
            swap(arrays, 0, i);
            adjustHeap(arrays, 0, i);
        }
    }

    public static void adjustHeap(int[] arrays, int i, int size) {
        int temp = arrays[i];
        for(int k=2*i+1;k<size;k=k*2+1){
            if(k+1<size&&arrays[k]<arrays[k+1]){
                k++;
            }
            if(temp<arrays[k]){
                swap(arrays, i,k);
                i=k;
            }else{
                break;
            }
        }
    }

    public static void swap(int[] arrays, int i, int j) {
        int temp = arrays[i];
        arrays[i] = arrays[j];
        arrays[j] = temp;
    }
}
