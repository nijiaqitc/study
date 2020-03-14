package com.njq.study;

import java.util.Arrays;

public class ShellSort {

    public static void main(String[] args) {
        int[] arrays1 = {2,1,3,4,5,6,7,5,4,3,2,4,5,6,2};
        shellSort(arrays1);
        Arrays.stream(arrays1).forEach(n->{
            System.out.print(n+" ");
        });
    }


    public static void shellSort(int[] arrays){
        int gap = arrays.length;
        while(true){
            gap=gap/2;
            for(int i=0;i<gap;i++){
                for(int j=i+gap;j<arrays.length;j+=gap){
                    int val = arrays[j];
                    int k ;
                    for(k=j;k>=gap&&arrays[k-gap]>val;k-=gap){
                        arrays[k]=arrays[k-gap];
                    }
                    arrays[k]=val;
                }
            }
            if(gap==1){
                break;
            }

        }

    }
}
