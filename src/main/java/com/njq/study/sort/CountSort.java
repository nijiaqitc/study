package com.njq.study.sort;

import java.util.Arrays;

/**
 * @author: nijiaqi
 * @date: 2019/10/15
 */
public class CountSort {

    public static void main(String[] args) {
        //排序的数组
        int a[] = {100, 93, 97, 92, 96, 99, 92, 89, 93, 97, 90, 94, 92, 95};
        int b[] = countSort(a);
        for (int i : b) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static int[] countSort(int[] a) {
        int b[] = new int[a.length];
        int max = a[0], min = a[0];
        for (int i : a) {
            if (i > max) {
                max = i;
            }
            if (i < min) {
                min = i;
            }
        }//这里k的大小是要排序的数组中，元素大小的极值差+1
        int k = max - min + 1;
        int c[] = new int[k];
        for (int i = 0; i < a.length; ++i) {
            c[a[i] - min] += 1;//优化过的地方，减小了数组c的大小
        }
        Arrays.stream(c).forEach(n -> {
            System.out.print(n + " ");
        });
        System.out.println();
        //计算每个元素该放在数组的哪个位置，比如最大的一个元素肯定放在，组数最后一位，下标是前面所有出现次数之和
        for (int i = 1; i < c.length; ++i) {
            c[i] = c[i] + c[i - 1];
        }
        Arrays.stream(c).forEach(n -> {
            System.out.print(n + " ");
        });
        System.out.println();
        for (int i = a.length - 1; i >= 0; --i) {
            //c[a[i] - min]是计算出具体放在数组哪个位置，然后这个相同位置的下标减1，即再出现这个相同的数，就放在刚刚位置的前一个位置
            b[--c[a[i] - min]] = a[i];
        }
        return b;
    }
}