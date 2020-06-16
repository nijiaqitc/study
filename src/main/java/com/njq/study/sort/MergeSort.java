package com.njq.study.sort;

/**
 * @author: nijiaqi
 * @date: 2019/11/1
 */
public class MergeSort {
    public static int[] mergeSort(int[] arrays, int left, int right) {
        if (left >= right) {
            return new int[]{arrays[left]};
        }
        int mid = (right + left) / 2;
        int[] leftArrays = mergeSort(arrays, left, mid);
        int[] rightArrays = mergeSort(arrays, mid + 1, right);
        int[] newArrays = new int[leftArrays.length + rightArrays.length];
        int i = 0, j = 0, k = 0;
        while (i < leftArrays.length && j < rightArrays.length) {
            newArrays[k++] = leftArrays[i] < rightArrays[j] ? leftArrays[i++] : rightArrays[j++];
        }
        while (i < leftArrays.length) {
            newArrays[k++] = leftArrays[i++];
        }
        while (j < rightArrays.length) {
            newArrays[k++] = rightArrays[j++];
        }
        return newArrays;
    }
}
