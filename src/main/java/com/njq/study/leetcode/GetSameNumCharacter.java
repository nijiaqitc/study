package com.njq.study.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: nijiaqi
 * @date: 2019/6/4
 */
public class GetSameNumCharacter {

    /**
     * 打印出字符串中相同次数的字符，
     * 如e在每个字符串中出现1次，那么打印1个e，
     * l在每个字符串中出现2次，那么打印2个l
     * @param args
     */
    public static void main(String[] args) {
        commonChars(new String[]{"bella","label","roller"});
    }

    public static List<String> commonChars(String[] A) {
        int[] arr = new int[26];
        List<String> list = new ArrayList<>();

        for(char c: A[0].toCharArray()){
            arr[c-'a'] ++;
        }
        for(int i=1; i < A.length; i++){
            int[] curr = new int[26];
            for(char c: A[i].toCharArray()){
                curr[c-'a'] ++;
            }
            for (int j = 0; j < 26; j++) {
                if (curr[j] < arr[j]) {
                    arr[j] = curr[j];
                }
            }
        }
        for(int i=0; i< arr.length; i++){
            for (int j = 0; j < arr[i]; j++) {
                list.add(Character.toString((char) ('a' + i)));
            }

        }
        return list;
    }
}
