package com.njq.study.leetcode;

/**
 * @author: nijiaqi
 * @date: 2019/6/5
 */
public class RemoveOutK {

    public static void main(String[] args) {
        System.out.println(removeOuterParentheses("()()"));
    }

    /**
     * 1021. 删除最外层的括号
     * 实现思路：利用数组+switch，然后用int值进行统计
     *
     * @param S
     * @return
     */
    private static String removeOuterParentheses(String S) {
        char[] chars = S.toCharArray();
        int stack = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < chars.length; i++) {
            switch (chars[i]) {
                case '(':
                    stack++;
                    if (stack > 1) {
                        sb.append(chars[i]);
                    }
                    break;
                case ')':
                    if (stack > 1) {
                        sb.append(chars[i]);
                    }
                    stack--;
                    break;
            }
        }
        return sb.toString();
    }
}
