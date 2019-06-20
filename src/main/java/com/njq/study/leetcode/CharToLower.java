package com.njq.study.leetcode;

/**
 * @author: nijiaqi
 * @date: 2019/6/6
 */
public class CharToLower {


    public static void main(String[] args) {
        toLowerCase("HIllow");
    }

    /**
     * 709. 转换成小写字母
     *
     * @param str
     * @return
     */
    private static String toLowerCase(String str) {
        if (str == null) {
            return "";
        }
        char[] inputs = str.toCharArray();
        char currentChar;
        for (int i = 0; i < inputs.length; i++) {
            currentChar = inputs[i];
            if (currentChar >= 'A' && currentChar <= 'Z') {
                char r = (char) ('a' + currentChar - 'A');
                inputs[i] = r;
            }
        }
        return new String(inputs);
    }
}
