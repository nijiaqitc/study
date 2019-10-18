package com.njq.study;

import java.util.Arrays;

/**
 * @author: nijiaqi
 * @date: 2019/9/29
 */
public class Mysort {


    public static void main(String[] args) {
        int[] num = {3, 45, 78, 64, 52, 11, 64, 55, 99, 11, 18};
        quickSort(num,0 ,num.length-1 );
        Arrays.stream(num).forEach(n->{
            System.out.print(n+" ");
        });
        System.out.println();
        int[] num1 = {3, 45, 78, 64, 52, 11, 64, 55, 99, 11, 18};
        selectSort(num1);
        Arrays.stream(num1).forEach(n->{
            System.out.print(n+" ");
        });
        System.out.println();
        int[] num2 = {3, 45, 78, 64, 52, 11, 64, 55, 99, 11, 18};
        insertSort(num2);
        Arrays.stream(num2).forEach(n->{
            System.out.print(n+" ");
        });
        System.out.println();

        int[] num3 = {3, 45, 78, 64, 52, 11, 64, 55, 99, 11, 18};
        Arrays.stream(mergeSort(num3,0,num3.length-1)).forEach(n->{
            System.out.print(n+" ");
        });
        System.out.println();

        int[] num4 = {3, 45, 78, 64, 52, 11, 64, 55, 99, 11, 18};
        shellSort(num4);
        Arrays.stream(num4).forEach(n->{
            System.out.print(n+" ");
        });
        System.out.println();
    }

    public static void quickSort(int[] arrays,int left , int right){
        if(left >= right){
            return;
        }
        int i = left;
        int j = right;
        int key = arrays[left];
        while(i<j){
            while(i<j&&arrays[j]>=key){
                j--;
            }
            while(i<j&&arrays[i]<=key){
                i++;
            }
            if(i!=j){
                int temp = arrays[i];
                arrays[i]=arrays[j];
                arrays[j]=temp;
            }
        }
        arrays[left]=arrays[i];
        arrays[i]=key;
        quickSort(arrays, left, i-1);
        quickSort(arrays, i+1, right);
    }


    public static  void selectSort(int[] arrays){
        for(int i=0;i<arrays.length-1;i++){
            int minIndex = i;
            for(int j=i+1;j<arrays.length;j++){
                if(arrays[j]<arrays[minIndex]){
                    minIndex = j;
                }
            }
            int temp = arrays[i];
            arrays[i]=arrays[minIndex];
            arrays[minIndex]=temp;
        }
    }

    public static void insertSort(int[] arrays){
        for(int i=1;i<arrays.length;i++){
            int j;
            int key = arrays[i];
            for(j=i;j>0&&arrays[j-1]>key;j--){
                arrays[j]=arrays[j-1];
            }
            arrays[j]=key;
        }
    }

    public static int[] mergeSort(int[] arrays,int left,int right){
        if(left >=right){
            return new int[]{arrays[left]};
        }
        int mid = (right+left)/2;
        int[] leftArrays = mergeSort(arrays, left, mid);
        int[] rightArrays= mergeSort(arrays, mid+1, right);
        int[] newArrays = new int[leftArrays.length+rightArrays.length];
        int i=0,j=0,k=0;
        while(i<leftArrays.length&&j<rightArrays.length){
           newArrays[k++]=leftArrays[i]<rightArrays[j]?leftArrays[i++]:rightArrays[j++];
        }
        while (i<leftArrays.length){
            newArrays[k++] = leftArrays[i++];
        }
        while (j<rightArrays.length){
            newArrays[k++] = rightArrays[j++];
        }
        return newArrays;
    }


    public static void shellSort(int[] arrays){
        int mid = arrays.length;
        while(true){
            mid = mid/2;
            for(int i=0;i<mid;i++){
                for(int j=i+mid;j<arrays.length;j+=mid){
                    int key = arrays[j];
                    int k;
                    for(k = j;k>mid&&arrays[k-mid]>key;k-=mid){
//                        System.out.println(k);
                        arrays[k]=arrays[k-mid];
//                        System.out.println("-------"+k+mid +(k-mid));
                    }
                    arrays[k]=key;
                }
            }
            if(mid == 1){
                break;
            }
        }
    }
}
