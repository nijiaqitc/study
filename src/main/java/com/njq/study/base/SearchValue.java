package com.njq.study.base;

/**
 * @author: nijiaqi
 * @date: 2019/5/21
 */
public class SearchValue {

    public static void main(String[] args) {
        String str1 = "abccc";
        String searcht = "bc";
        search(str1, searcht);
    }

    private static void search(String v1, String v2) {
        char[] chars1 = v1.toCharArray();
        char[] chars2 = v2.toCharArray();
        for (int i = 0; i < chars1.length; i++) {
            if (chars1[i] == chars2[0]) {
                int[] as = searcht(chars1, chars2, i);
                if (as != null) {
                    System.out.println(as[0]);
                }
            }
        }
    }

    private static int[] searcht(char[] c1, char[] c2, int index) {
        int orderIndex = 0;
        for (int i = index; i < c1.length; i++) {
            if (c1[i] != c2[orderIndex]) {
                return null;
            }
            orderIndex++;
            if (orderIndex == c2.length) {
                return new int[]{index, orderIndex};
            }
        }
        return null;
    }


}
