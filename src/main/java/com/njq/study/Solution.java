package com.njq.study;

import java.util.ArrayList;
import java.util.List;

class Solution {
    static final int TARGET = 24;
    static final double EPSILON = 1e-6;
    static final int ADD = 0, MULTIPLY = 1, SUBTRACT = 2, DIVIDE = 3;

//    public static void main(String[] args) {
//        Solution s = new Solution();
//        System.out.println(s.judgePoint24(new int[]{2, 2, 3, 3}));
//    }

    public boolean judgePoint24(int[] nums) {
        List<Double> list = new ArrayList<Double>();
        for (int num : nums) {
            list.add((double) num);
        }
        return solve(list);
    }

    public boolean solve(List<Double> list) {
        if (list.size() == 0) {
            return false;
        }
        if (list.size() == 1) {
            return Math.abs(list.get(0) - TARGET) < EPSILON;
        }
        int size = list.size();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (i != j) {
                    List<Double> list2 = new ArrayList<Double>();
                    for (int k = 0; k < size; k++) {
                        if (k != i && k != j) {
                            list2.add(list.get(k));
                        }
                    }
                    for (int k = 0; k < 4; k++) {
                        if (k < 2 && i > j) {
                            continue;
                        }
                        if (k == ADD) {
                            list2.add(list.get(i) + list.get(j));
                        } else if (k == MULTIPLY) {
                            list2.add(list.get(i) * list.get(j));
                        } else if (k == SUBTRACT) {
                            list2.add(list.get(i) - list.get(j));
                        } else if (k == DIVIDE) {
                            if (Math.abs(list.get(j)) < EPSILON) {
                                continue;
                            } else {
                                list2.add(list.get(i) / list.get(j));
                            }
                        }
                        if (solve(list2)) {
                            return true;
                        }
                        list2.remove(list2.size() - 1);
                    }
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.PredictTheWinnera(new int[]{1, 5, 6, 7}));
    }

    public boolean PredictTheWinner(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        int left = 0, right = nums.length - 1;
        int sumA = 0, sumB = 0;
        boolean flag = true;
        while (left <= right) {
            if (flag) {
                if (nums[left] >= nums[right]) {
                    sumA += nums[left];
                    left++;
                } else {
                    sumA += nums[right];
                    right--;
                }
                flag = false;
            } else {
                if (nums[left] >= nums[right]) {
                    sumB += nums[left];
                    left++;
                } else {
                    sumB += nums[right];
                    right--;
                }
                flag = true;
            }
        }
        System.out.println(sumA + " " + sumB);
        return sumA >= sumB;
    }


    public boolean PredictTheWinnera(int[] nums) {
        return total(nums, 0, nums.length - 1, 1) >= 0;
    }

    public int total(int[] nums, int start, int end, int turn) {
        if (start == end) {
            return nums[start] * turn;
        }
        int scoreStart = nums[start] * turn + total(nums, start + 1, end, -turn);
        int scoreEnd = nums[end] * turn + total(nums, start, end - 1, -turn);
        return Math.max(scoreStart * turn, scoreEnd * turn) * turn;
    }


    public boolean PredictTheWinner1(int[] nums) {
        int length = nums.length;
        int[] dp = new int[length];
        for (int i = 0; i < length; i++) {
            dp[i] = nums[i];
        }
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                dp[j] = Math.max(nums[i] - dp[j], nums[j] - dp[j - 1]);
            }
        }
        return dp[length - 1] >= 0;
    }


    public boolean PredictTheWinner2(int[] nums) {
        int length = nums.length;
        int[][] dp = new int[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = nums[i];
        }
        for (int i = length - 2; i >= 0; i--) {
            for (int j = i + 1; j < length; j++) {
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
            }
        }
        return dp[0][length - 1] >= 0;
    }


    public int maxArea(int[] nums) {
        int left = 0, right = nums.length - 1;
        int max = 0;
        while (left < right) {
//            max = nums[left] < nums[right] ? Math.max(max, nums[left++] * (right - left)) : Math.max(max, nums[right--] * (right - left));

            int sum = Math.min(nums[left], nums[right]) * (right - left);
            if (sum > max) {
                max = sum;
            }
            if (nums[left] > nums[right]) {
                right--;
            } else {
                left++;
            }

        }
        return max;
    }

}
