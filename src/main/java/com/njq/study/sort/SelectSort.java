package com.njq.study.sort;

import java.util.Arrays;

/**
 * @author: nijiaqi
 * @date: 2019/9/27
 */
public class SelectSort {
    public static void main(String[] args) {
        int[] num = {3, 45, 78, 64, 52, 11, 64, 55, 99, 11, 18};
        sort(num);
    }


    public static void sort(int[] arrays){
        for(int i=0;i<arrays.length-1;i++){
            int val_index = i;
            for(int j=i+1;j<arrays.length;j++){
                if(arrays[j]<arrays[val_index]){
                    val_index = j;
                }
            }
            int temp = arrays[i];
            arrays[i]=arrays[val_index];
            arrays[val_index] = temp;
        }
        Arrays.stream(arrays).forEach(n -> {
            System.out.print(n + " ");
        });
    }
}
