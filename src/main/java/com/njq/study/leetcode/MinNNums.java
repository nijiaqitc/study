package com.njq.study.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class MinNNums {

    public static void main(String[] args) {
        MinNNums min = new MinNNums();
//        int[] arrays = min.getmind(new int[]{99, 98, 97, 96, 95, 94}, 4);
//        for (int i = 0; i < arrays.length; i++) {
//            System.out.println(arrays[i]);
//        }
        System.out.println(min.completeMaxNuma(3, 7));
        ;
    }

    private int[] getmin(int[] arrays, int n) {
        Arrays.sort(arrays);
        return Arrays.copyOfRange(arrays, 0, n);
    }

    private int[] getmina(int[] arrays, int n) {
        int[] newArray = new int[n];
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int min = Integer.MAX_VALUE;
            int temp = 0;
            for (int j = 0; j < arrays.length; j++) {
                if (arrays[j] < min && map.get(arrays[j] + " " + j) == null) {
                    min = arrays[j];
                    temp = j;
                }
            }
            map.put(arrays[temp] + " " + temp, temp);
            newArray[i] = min;
        }
        return newArray;
    }

    private int[] getminb(int[] arrays, int n) {
        int[] newarray = Arrays.copyOfRange(arrays, 0, n);
        for (int i = n; i < arrays.length; i++) {
            int max = 0;
            for (int j = 0; j < newarray.length; j++) {
                if (newarray[j] > arrays[i] && newarray[j] > max) {
                    max = newarray[j];
                    for (int k = j; k < n - 1; k++) {
                        newarray[k] = newarray[k + 1];
                    }
                    newarray[n - 1] = arrays[i];
                }
            }
        }

        return newarray;
    }

    public int[] smallestK(int[] arr, int k) {
        if (arr == null || arr.length == 0)
            return new int[k];
        int[] result = new int[k];
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i : arr) {
            queue.offer(i);
        }

        for (int i = 0; i < k; i++) {
            result[i] = queue.poll();
        }

        return result;

    }

    private int[] getminc(int[] arr, int k) {
        int[] newarray = new int[arr.length];
        for (int j = 0; j < arr.length; j++) {
            int min = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] < min && newarray[i] == 0) {
                    min = arr[i];
                    minIndex = i;
                }
            }
            newarray[minIndex] = j + 1;
        }

        int[] minarray = new int[k];
        int index = 0;
        for (int j = 0; j < newarray.length; j++) {
            if (newarray[j] <= k) {
                minarray[index++] = arr[j];
            }
        }
        for (int i = 0; i < newarray.length; i++) {
            System.out.print(newarray[i] + " ");
        }
        System.out.println("--");
        return minarray;
    }


    private int[] getmind(int[] arr, int k) {
        int[] newarray = new int[arr.length];
        for (int j = 0; j < arr.length; j++) {
            int min = Integer.MAX_VALUE;
            int minIndex = -1;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] < min && newarray[i] == 0) {
                    min = arr[i];
                    minIndex = i;
                }
            }
            newarray[minIndex] = j + 1;
            if (j > k) {
                break;
            }
        }

        int[] minarray = new int[k];
        int index = 0;
        for (int j = 0; j < newarray.length; j++) {
            if (newarray[j] != 0 && newarray[j] <= k) {
                minarray[index++] = arr[j];
            }
        }
        for (int i = 0; i < newarray.length; i++) {
            System.out.print(newarray[i] + " ");
        }
        System.out.println("--");
        return minarray;
    }

    private int completeMaxNum(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 0;
        dp[0][1] = 1;
        dp[1][0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (i == 0) {
                    if (j > 1) {
                        dp[i][j] = dp[0][j - 1];
                    }
                } else if (j == 0) {
                    if (i > 1) {
                        dp[i][j] = dp[i - 1][0];
                    }
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        System.out.println(dp);
        return dp[m - 1][n - 1];
    }

    private int completeMaxNuma(int m, int n) {
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                array[j] += array[j - 1];
            }
        }
        System.out.println(array[n - 1]);
        return array[n - 1];
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int[] ints : obstacleGrid) {
            for (int j = 0; j < n; j++) {
                if (ints[j] == 1) {
                    dp[j] = 0;
                } else if (j > 0) {
                    dp[j] += dp[j - 1];
                }
            }
        }
        return dp[n - 1];
    }


    public int complecteMaxArea(int[] array) {

        return 0;
    }
}
