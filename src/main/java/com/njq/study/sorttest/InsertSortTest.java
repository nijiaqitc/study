package com.njq.study.sorttest;

public class InsertSortTest {
    public static void main(String[] args) {
        int[] num = {3, 45, 78, 64, 52, 11, 64, 55, 99, 11, 18};
        sort(num);
        SortPrint.out(num);
    }

    public static void sort(int[] array){
        for(int i=1;i<array.length;i++){
            int val=array[i];
            int j;
            for(j=i;j>0&&array[j-1]>val;j--){
                array[j]=array[j-1];
            }
            array[j]=val;
        }

    }
}
