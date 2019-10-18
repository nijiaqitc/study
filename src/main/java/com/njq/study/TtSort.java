package com.njq.study;

import java.util.Arrays;

/**
 * @author: nijiaqi
 * @date: 2019/10/17
 */
public class TtSort {
    public static void main(String[] args) {
        int a[] = {100, 93, 97, 92, 96, 99, 92, 89, 93, 97, 90, 94, 92, 95, 92, 92, 92, 92, 92, 92, 92, 92};
        Arrays.stream(radixSort(a,3)).forEach(n->{
            System.out.print(n+" ");
        });
    }


    public static int[] radixSort(int[] arrays,int d) {
        int n=1,m=1,k=0;
        int[][]  temp = new int[10][arrays.length];
        int[] order = new int[10];
        while (n<=d){
            for(int i=0;i<arrays.length;i++){
                int lsd = (arrays[i]/m)%10;
                temp[lsd][order[lsd]++]=arrays[i];
            }
            for(int i=0;i<10;i++){
                if(order[i]!=0){
                    for(int j=0;j<order[i];j++){
                        arrays[k++]=temp[i][j];
                    }
                    order[i]=0;
                }
            }
            n+=1;
            m*=10;
            k=0;


        }


        return arrays;
    }
}
