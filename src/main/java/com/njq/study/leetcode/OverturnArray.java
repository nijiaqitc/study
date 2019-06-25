package com.njq.study.leetcode;

/**
 * @author: nijiaqi
 * @date: 2019/6/21
 */
public class OverturnArray {

    /**
     * 832. 翻转图像
     * 数组水平翻转和直接取反
     *
     * @param A
     * @return
     */
    public int[][] flipAndInvertImage(int[][] A) {
        int temp = 0;
        int length = A.length;
        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length / 2; j++) {
                temp = A[i][j];
                A[i][j] = A[i][length - 1 - j];
                A[i][length - 1 - j] = temp;
            }
            for (int j = 0; j < length; j++) {
                A[i][j] ^= 1;
            }
        }
        return A;
    }
}
