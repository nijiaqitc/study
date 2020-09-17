package com.njq.study.leetcode;

import java.util.ArrayDeque;

public class Solution {
    ArrayDeque<Integer> deq = new ArrayDeque<Integer>();
    int[] nums;

    public void clean_deque(int i, int k) {
        // remove indexes of elements not from sliding window
        if (!deq.isEmpty() && deq.getFirst() == i - k)
            deq.removeFirst();

        // remove from deq indexes of all elements
        // which are smaller than current element nums[i]
        while (!deq.isEmpty() && nums[i] > nums[deq.getLast()])
            deq.removeLast();
    }

    public int[] maxSlidingWindow(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0)
            return new int[0];
        if (k == 1)
            return nums;

        // init deque and output
        this.nums = nums;
        int max_idx = 0;
        for (int i = 0; i < k; i++) {
            clean_deque(i, k);
            deq.addLast(i);
            // compute max in nums[:k]
            if (nums[i] > nums[max_idx])
                max_idx = i;
        }
        int[] output = new int[n - k + 1];
        output[0] = nums[max_idx];

        // build output
        for (int i = k; i < n; i++) {
            clean_deque(i, k);
            deq.addLast(i);
            output[i - k + 1] = nums[deq.getFirst()];
        }
        return output;
    }

    public static void main(String[] args) {
        int aa[] = new int[]{1, 3, -1, -3, 5, 3, 6, 7};
        Solution so = new Solution();
//        int[] abc = so.maxSlidingWindow(aa, 3);

//        int[] abc = so.maxSlidingWindowa(aa, 3);
//
//        for (int i = 0; i < abc.length; i++) {
//            System.out.println(abc[i]);
//        }


//        int[] charIndex = new int[256];
//        System.out.println((int)'c');
//        charIndex[99] = 34;
//        System.out.println(charIndex['c']);
        System.out.println(so.lengthOfLongestSubstring("pwwkew"));

    }

    public int[] maxSlidingWindowa(int[] nums, int k) {
        int n = nums.length;
        if (n * k == 0) return new int[0];
        if (k == 1) return nums;

        int[] left = new int[n];
        left[0] = nums[0];
        int[] right = new int[n];
        right[n - 1] = nums[n - 1];
        for (int i = 1; i < n; i++) {
            // from left to right
            if (i % k == 0) {
                left[i] = nums[i];
                // block_start
            } else {
                left[i] = Math.max(left[i - 1], nums[i]);
            }
            // from right to left
            int j = n - i - 1;
            if ((j + 1) % k == 0) {
                right[j] = nums[j];  // block_end
            } else {
                right[j] = Math.max(right[j + 1], nums[j]);
            }
        }

        for (int i = 0; i < left.length; i++) {
            System.out.print(left[i] + " ");
        }
        System.out.println();
        for (int i = 0; i < right.length; i++) {
            System.out.print(right[i] + " ");
        }
        System.out.println();
        System.out.println("------------");

        int[] output = new int[n - k + 1];
        for (int i = 0; i < n - k + 1; i++)
            output[i] = Math.max(left[i + k - 1], right[i]);

        return output;
    }

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int result = 0;
        int[] charIndex = new int[256];
        for (int left = 0, right = 0; right < n; right++) {
            char c = s.charAt(right);
            left = Math.max(charIndex[c], left);
            result = Math.max(result, right - left + 1);
            charIndex[c] = right + 1;
        }
        return result;
    }
}
