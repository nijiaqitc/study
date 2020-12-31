package com.njq.study;

import java.util.*;
import java.util.stream.Collectors;

public class Test28 {
    public static void main(String[] args) {
//        System.out.println(lengthOfLongestSubstring("pwwkew"));
//        System.out.println((int)"11");
//        System.out.println(reverse(-12));
        List<Integer> li = new ArrayList<>();
        li.add(1);
        li.add(0);
        li.add(3);
        li.stream().sorted(Comparator.comparing(n -> {
            if (n > 0) {
                return 1;
            } else {
                return -1;
            }
        })).collect(Collectors.toList());
        System.out.println(li.stream().sorted(Comparator.comparing(n -> {
//            if (n > 0) {
//                return 1;
//            } else {
//                return -1;
//            }
            return n <= 0;
        })).collect(Collectors.toList()));
    }

    public static int lengthOfLongestSubstring(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<Character>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }

    public static int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }


}

