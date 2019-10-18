package com.njq.study;

import java.util.Arrays;

/**
 * @author: nijiaqi
 * @date: 2019/10/15
 */
public class Sot {
    public static void main(String[] args) {
        int a[] = {100, 93, 97, 92, 96, 99, 92, 89, 93, 97, 90, 94, 92, 95};
        countSort(a);
    }

    public static void countSort(int[] arrays) {
        int min=arrays[0],max=arrays[0];
        int[] b=new int[arrays.length];
        for(int i=0;i<arrays.length;i++){
            if(arrays[i]<min){
                min=arrays[i];
            }
            if(arrays[i]>max){
                max=arrays[i];
            }
        }
        int[] c=new int[max-min+1];
        for(int i=0;i<arrays.length;i++){
            c[arrays[i]-min]+=1;
        }
        for(int i=1;i<c.length;i++){
            c[i] +=c[i-1];
        }
        for(int i=arrays.length-1;i>=0;i--){
            b[--c[arrays[i]-min]]=arrays[i];
        }
        Arrays.stream(b).forEach(n->{
            System.out.print(n+" ");
        });
    }
}
