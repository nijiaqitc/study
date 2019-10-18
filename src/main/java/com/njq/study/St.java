package com.njq.study;

import java.util.Arrays;

/**
 * @author: nijiaqi
 * @date: 2019/10/15
 */
public class St {
    public static void main(String[] args) {
        int a[] = {100, 93, 97, 92, 96, 99, 92, 89, 93, 97, 90, 94, 92, 95};
        basket(a);
        Arrays.stream(a).forEach(n->{
            System.out.print(n+" ");
        });
        System.out.println(Integer.MIN_VALUE);
    }
    public static void basket(int data[])//data为待排序数组
    {
        int n = data.length;
        int bask[][] = new int[10][n];
        int index[] = new int[10];
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = max > (Integer.toString(data[i]).length()) ? max : (Integer.toString(data[i]).length());
        }
        String str;
        for (int i = max - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                str = "";
                if (Integer.toString(data[j]).length() < max) {
                    for (int k = 0; k < max - Integer.toString(data[j]).length(); k++){
                        str += "0";
                    }
                }
                str += Integer.toString(data[j]);
                System.out.println("---------"+str+" "+str.charAt(i)+" "+(str.charAt(i) - '0'));
                bask[str.charAt(i) - '0'][index[str.charAt(i) - '0']++] = data[j];
            }
            int pos = 0;
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < index[j]; k++) {
                    data[pos++] = bask[j][k];
                }
                index[j] = 0;
            }
//            for (int x = 0; x < 10; x++){
//                index[x] = 0;
//            }
        }
    }
}
