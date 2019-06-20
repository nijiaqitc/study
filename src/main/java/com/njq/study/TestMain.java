package com.njq.study;

/**
 * @author: nijiaqi
 * @date: 2019/6/20
 */
public class TestMain {

    public static void main(String[] args) {
        int[] nums = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(TestMain.maxArea(nums));
    }


    public static int maxArea(int[] height) {
        int maxValue = 0;
        int lowValue = 0;
        int tempValue = 0;
        for (int i = 0; i < height.length; i++) {
            for (int j = i + 1; j < height.length; j++) {
                lowValue = height[j] < height[i] ? height[j] : height[i];
                tempValue = (j - i) * lowValue;
                maxValue = maxValue < tempValue ? tempValue : maxValue;
            }
        }
        return maxValue;
    }


}
