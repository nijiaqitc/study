package com.njq.study.leetcode;

import com.njq.study.TestMain;

/**
 * @author: nijiaqi
 * @date: 2019/6/25
 */
public class CompleteArea {


    public static void main(String[] args) {
        System.out.println(CompleteArea.computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
    }

    /**
     *  计算图形面积  223. 矩形面积
     * A-C  E-G
     * c < e
     * a > g
     * B-D  F-H
     * b > h
     * d < f
     *
     *
     * 计算两个图形的总面积，然后减去重叠部分
     * 重叠部分， 两个大坐标值取小的，两个小坐标值取大的
     */
    public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int total = (C - A) * (D - B) + (G - E) * (H - F);
        /**
         * 此情况下不存在重叠部分
         */
        if (E >= C || A >= G || B >= H || F >= D) {
            return total;
        }
        int little = (Math.min(C, G) - Math.max(E, A)) * (Math.min(D, H) - Math.max(B, F));
        return total - little;
    }
}
