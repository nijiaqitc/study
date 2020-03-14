package com.njq.study;

import java.time.temporal.Temporal;
import java.util.Arrays;
import java.util.concurrent.TransferQueue;

public class Sort {
    public static void main(String[] args) {
//        int[] arrays = {2,1,3,4,5,6,7,5,4,3,2,4,5,6,2};
//        quickSort(arrays,0,arrays.length-1);
//        Arrays.stream(arrays).forEach(n->{
//            System.out.print(n+" ");
//        });
//        System.out.println();
//        int[] arraysshell = {2,1,3,4,5,6,7,5,4,3,2,4,5,6,2};
//        shellSort(arraysshell);
//        Arrays.stream(arraysshell).forEach(n->{
//            System.out.print(n+" ");
//        });
//        System.out.println();
//        int[] arrays1 = {2,1,3,4,5,6,7,5,4,3,2,4,5,6,2};
//        insertSort(arrays1);
//        Arrays.stream(arrays1).forEach(n->{
//            System.out.print(n+" ");
//        });
//
//        System.out.println();
//        int[] arrays2 = {2,1,3,4,5,6,7,5,4,3,2,4,5,6,2};
//        selectSort(arrays2);
//        Arrays.stream(arrays2).forEach(n->{
//            System.out.print(n+" ");
//        });
//        System.out.println();
//        int[] arrays3 = {2,1,3,4,5,6,7,5,4,3,2,4,5,6,2};
//        int[] afaf = mergeSort(arrays3,0,arrays3.length-1);
//        Arrays.stream(afaf).forEach(n->{
//            System.out.print(n+" ");
//        });
//
//        System.out.println();
//        int[] arrays4 = {2,1,3,4,5,6,7,5,4,3,2,4,5,6,2};
//        radixSort(arrays4,1);
//        Arrays.stream(arrays4).forEach(n->{
//            System.out.print(n+" ");
//        });

//        System.out.println();
//        int[] arrays5 = {2,1,3,4,5,6,7,5,4,3,2,4,5,6,2};
//        int[] abc = countSort(arrays5);
//        Arrays.stream(abc).forEach(n->{
//            System.out.print(n+" ");
//        });

        System.out.println(TestEnum.AAA.getClass().getSuperclass());


    }


    public static void quickSort(int[] arrays,int left,int right){
        if(left >=right){
            return;
        }
        int i=left;
        int j=right;
        int val=arrays[left];
        while(i<j){
            while(i<j&&arrays[j]>=val){
                j--;
            }
            while(i<j&&arrays[i]<=val){
                i++;
            }
            if(i!=j){
                int temp = arrays[i];
                arrays[i]=arrays[j];
                arrays[j]=temp;
            }
        }
        arrays[left]=arrays[i];
        arrays[i]=val;

        quickSort(arrays,left,i-1);
        quickSort(arrays,i+1,right);
    }


    public static void selectSort(int[] arrays){
        for(int i=0;i<arrays.length-1;i++){
            int minIndex=i;
            for(int j=i+1;j<arrays.length;j++){
                if(arrays[j]<arrays[minIndex]){
                    minIndex=j;
                }
            }
            if(i != minIndex){
                int temp =arrays[i];
                arrays[i]=arrays[minIndex];
                arrays[minIndex] = temp;
            }
        }
    }


    public static void  insertSort(int[] arrays){
        for(int i=1;i<arrays.length;i++){
            int val = arrays[i];
            int j;
            for(j=i;j>0&&arrays[j-1]>val;j--){
                arrays[j]=arrays[j-1];
            }
            arrays[j]=val;
        }
    }



    public static void shellSort(int[] arrays){
        int v=arrays.length/2;
        while(true){
            v /=2;
            for(int i=0;i<v;i++){
                for(int j=i+v;j<arrays.length;j+=v){
                    int val =arrays[j];
                    int k;
                    for(k=j;k>=v&&arrays[k-v]>val;k-=v){
                        arrays[k]=arrays[k-v];
                    }
                    arrays[k]=val;
                }
            }
            if(v==1){
                return;
            }

        }
    }

    public static int[] mergeSort(int[] arrays,int left,int right){
        if(left >=right){
            return new int[]{arrays[left]};
        }
        int mid=(left+right)/2;
        int[] leftArr=mergeSort(arrays,left,mid);
        int[] rightArr = mergeSort(arrays,mid+1,right);
        int[] newArr=new int[leftArr.length+rightArr.length];
        int m=0,i=0,j=0;
        while(i<leftArr.length&&j<rightArr.length){
            newArr[m++]=leftArr[i]<rightArr[j]?leftArr[i++]:rightArr[j++];
        }
        while (i<leftArr.length){
            newArr[m++]=leftArr[i++];
        }
        while (j<rightArr.length){
            newArr[m++]=rightArr[j++];
        }
        return newArr;
    }


    public static void radixSort(int[] arrays,int d){
        //新数组的位置值
        int k=0;
        //当前处理第几位
        int m=1;
        //除数值
        int n=1;
        int[][] temp =new int[10][arrays.length];
        int[] order =new int[10];
        while (m<=d){
            for(int i=0;i<arrays.length;i++){
                int lsd = (arrays[i]/n)%10;
                temp[lsd][order[lsd]]=arrays[i];
                order[lsd]++;
            }
            for(int i=0;i<10;i++){
                if(order[i] !=0){
                    for(int j=0;j<order[i];j++){
                        arrays[k] = temp[i][j];
                        k++;
                    }
                }
                order[i]=0;
            }
            n*=10;
            k=0;
            m++;
        }
    }


    public static int[] countSort(int[]a){
        int b[] = new int[a.length];
        int max = a[0],min = a[0];
        for(int i:a){
            if(i>max){
                max=i;
            }
            if(i<min){
                min=i;
            }
        }//这里k的大小是要排序的数组中，元素大小的极值差+1
        int k=max-min+1;
        int c[]=new int[k];
        for(int i=0;i<a.length;++i){
            c[a[i]-min]+=1;//优化过的地方，减小了数组c的大小
        }
        Arrays.stream(c).forEach(a1-> System.out.print(a1+" "));
        System.out.println();
        for(int i=1;i<c.length;++i){
            c[i]=c[i]+c[i-1];
        }
        Arrays.stream(c).forEach(a1-> System.out.print(a1+" "));
        System.out.println();
        for(int i=a.length-1;i>=0;--i){
            b[--c[a[i]-min]]=a[i];//按存取的方式取出c的元素
        }
        return b;
    }


}
