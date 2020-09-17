package com.njq.study.leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 438
 */
public class SlideWindow {
    public static void main(String[] args) {
        SlideWindow sw = new SlideWindow();
        List list = sw.findAnagrams("babacba", "ab");
        list.stream().peek(n -> {
            System.out.println(n);
        }).collect(Collectors.toList());
    }


    public List<Integer> findAnagrams(String s, String p) {
        char[] parent = s.toCharArray();
        char[] child = p.toCharArray();

        // 接收最后返回的结果
        List<Integer> ans = new ArrayList<>();

        // 定义一个 needs 数组来看 arrP 中包含元素的个数
        int[] needs = new int[26];
        // 定义一个 window 数组来看滑动窗口中是否有 arrP 中的元素，并记录出现的个数
        int[] window = new int[26];

        // 先将 arrP 中的元素保存到 needs 数组中
        for (int i = 0; i < child.length; i++) {
            needs[child[i] - 'a'] += 1;
        }

        // 定义滑动窗口的两端
        int left = 0;
        int right = 0;

        // 右窗口开始不断向右移动
        while (right < parent.length) {
            int curR = parent[right] - 'a';
            right++;
            // 将右窗口当前访问到的元素 curR 个数加 1
            window[curR] += 1;

            // 当 window 数组中 curR 比 needs 数组中对应元素的个数要多的时候就该移动左窗口指针
            while (window[curR] > needs[curR]) {
                int curL = parent[left] - 'a';
                left++;
                // 将左窗口当前访问到的元素 curL 个数减 1
                window[curL] -= 1;
            }

            // 这里将所有符合要求的左窗口索引放入到了接收结果的 List 中
            if (right - left == child.length) {
                ans.add(left);
            }
        }
        return ans;
    }
}