package com.njq.study.leetcode;

import com.njq.study.TestMain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: nijiaqi
 * @date: 2019/6/25
 */
public class CompleteAllResult {

    public static void main(String[] args) {
        int[] A = {1, 2, 4};
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 1; i <= A.length; i++) {
            list.addAll(CompleteAllResult.repeatedNTimes(A, i));
        }
        System.out.println(list);
        Map<Integer, Integer> map = new HashMap<>();
        for (List<Integer> ll : list) {
            int v = 0;
            for (int i = 0; i < ll.size(); i++) {
                v |= ll.get(i);
            }
            if (map.get(v) == null) {
                map.put(v, 1);
                System.out.println(v);
            }
        }
        System.out.println(map.keySet().size());
    }
    public static List<List<Integer>> repeatedNTimes(int[] A, int num) {
        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < A.length; i++) {
            List<Integer> subList = new ArrayList<>();
            subList.add(A[i]);
            if (num > 1) {
                List<List<Integer>> ssList = repeatedNTimes(Arrays.copyOfRange(A, i + 1, A.length), num - 1);
                for (int j = 0; j < ssList.size(); j++) {
                    List<Integer> sub2 = new ArrayList<>();
                    sub2.addAll(subList);
                    sub2.addAll(ssList.get(j));
                    list.add(sub2);
                }
            } else {
                list.add(subList);
            }
        }
        return list;
    }
}
