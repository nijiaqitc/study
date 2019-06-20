package com.njq.study.leetcode;

import java.util.Arrays;

/**
 * @author: nijiaqi
 * @date: 2019/6/20
 */
public class CompleteCloseNums {
    public static void main(String[] args) {
        int[] nums = {0, 2, 1, -3};
        System.out.println(CompleteCloseNums.threeSumClosest(nums, 1));
    }


    /**
     * 16. 最接近的三数之和
     * 计算出3个值求和后的值，最接近目标的的3个数值的求和值
     * 如上最接近的求和值就是0
     *
     * @param nums
     * @param target
     * @return
     */
    public static int threeSumClosest(int[] nums, int target) {
        // 排序
        Arrays.sort(nums);
        int closestNum = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                int threeSum = nums[l] + nums[r] + nums[i];
                if (Math.abs(threeSum - target) < Math.abs(closestNum - target)) {
                    closestNum = threeSum;
                }
                if (threeSum > target) {
                    r--;
                } else if (threeSum < target) {
                    l++;
                } else {
                    // 如果已经等于target的话, 肯定是最接近的
                    return target;
                }
            }
        }
        return closestNum;
    }
}
