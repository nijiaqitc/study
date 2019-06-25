package com.njq.study.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: nijiaqi
 * @date: 2019/6/25
 */
public class SubarrayBitwiseORs {

    /**
     * 898. 子数组按位或操作
     * 效率有点低，超时
     * 用案例提供的题解方式也超时
     * @param args
     */
    public static void main(String[] args) {
        int[] A = {1, 2, 4};
        SubarrayBitwiseORs.test(A);
    }

    public static int test(int[] A) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            test1(map, A, i);
        }
        return map.keySet().size();
    }

    public static void test1(Map<Integer, Integer> map, int[] A, int key) {
        int v = 0;
        for (int i = key; i < A.length; i++) {
            v |= A[i];
            map.put(v, 1);
        }
    }
}
