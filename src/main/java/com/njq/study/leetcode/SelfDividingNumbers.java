package com.njq.study.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: nijiaqi
 * @date: 2019/6/28
 */
public class SelfDividingNumbers {

    public static void main(String[] args) {
        SelfDividingNumbers.selfDividingNumbers(1, 22);
    }

    public static List<Integer> selfDividingNumbers(int left, int right) {
        List<Integer> list = new ArrayList<>();
        int v1 = 0, v2 = 0, v3;
        for (int i = left; i <= right; i++) {
            v1 = 0;
            v2 = 0;
            v3 = i;
            boolean flag = true;
            do {
                v1 = v3 % 10;
                v3 = v3 / 10;
                if (v1 == 0) {
                    break;
                }
                v2 = i % v1;
                if (v2 != 0) {
                    break;
                }
                if (v3 <= 0) {
                    flag = false;
                }
            } while (flag);
            if (!flag) {
                list.add(i);
            }
        }
        return list;
    }
}
