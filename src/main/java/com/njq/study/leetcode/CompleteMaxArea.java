package com.njq.study.leetcode;

/**
 * @author: nijiaqi
 * @date: 2019/6/20
 */
public class CompleteMaxArea {
    public static void main(String[] args) {
        int[] nums = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(CompleteMaxArea.maxArea(nums));
    }
    /**
     * 11. 盛最多水的容器
     * 思路是左边数值应该尽量高,右边尽量取高一点
     */
    public static int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int max = 0;
        while (right > left) {
            int area = Math.min(height[left], height[right]) * (right - left);
            if (area > max) {
                max = area;
            }
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return max;
    }
}
