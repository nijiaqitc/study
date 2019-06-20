package com.njq.study.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: nijiaqi
 * @date: 2019/6/4
 */
public class GetSameNumCharacter {

    /**
     * 1002. 查找常用字符
     * 打印出字符串中相同次数的字符，
     * 如e在每个字符串中出现1次，那么打印1个e，
     * l在每个字符串中出现2次，那么打印2个l
     *
     * @param args
     */
    public static void main(String[] args) {
        commonChars(new String[]{"bella", "label", "roller"});
    }

    /**
     * 实现思路：先创建好存放所有小写字母的数组集合，
     * 然后统计第一个字符串的字符及数量，分别放在对应数组位置
     * 然后再建立新的数组，用于存放别的字符串中字符的数量
     * 接着比较第一个数组和其他数组比较字符以第一个数组为准，数量取小的
     * 最后打印出字符集合
     *
     * @param A
     * @return
     */
    public static List<String> commonChars(String[] A) {
        int[] arr = new int[26];
        List<String> list = new ArrayList<>();

        for (char c : A[0].toCharArray()) {
            arr[c - 'a']++;
        }
        for (int i = 1; i < A.length; i++) {
            int[] curr = new int[26];
            for (char c : A[i].toCharArray()) {
                curr[c - 'a']++;
            }
            for (int j = 0; j < 26; j++) {
                if (curr[j] < arr[j]) {
                    arr[j] = curr[j];
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i]; j++) {
                list.add(Character.toString((char) ('a' + i)));
            }

        }
        return list;
    }
}
