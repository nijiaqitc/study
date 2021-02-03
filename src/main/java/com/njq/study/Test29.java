package com.njq.study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test29 {

    public static void main(String[] args) {
//        int[] array = new int[]{-2,1,-3,4,-1,2,1,-5,4};
////        System.out.println(maxSubArray(array));

//        System.out.println(lengthOfLastWord("Hello World"));


        ArrayList<String> listA= new ArrayList<String>();
        listA.add("Tom");
        listA.add("TomB");
        ArrayList<String> listB= new ArrayList<String>();
        listB.add("Tom");
        listB.add("TomA");
        listA.retainAll(listB);
        if(listA.size()>0){
            System.out.println("这两个集合有相同的交集");
        }else{
            System.out.println("这两个集合没有相同的交集");
        }
    }

    public static int maxSubArray(int[] nums) {
        int pre = 0, maxAns = nums[0];
        for (int x : nums) {
            pre = Math.max(pre + x, x);
            System.out.println(pre);
            maxAns = Math.max(maxAns, pre);
        }
        return maxAns;
    }

    public static int lengthOfLastWord(String s) {
        int end = s.length() - 1;
        while(end >= 0 && s.charAt(end) == ' ') end--;
        if(end < 0) return 0;
        int start = end;
        while(start >= 0 && s.charAt(start) != ' ') start--;
        return end - start;
    }
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return intersect(nums2, nums1);
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums1) {
            int count = map.getOrDefault(num, 0) + 1;
            map.put(num, count);
        }
        int[] intersection = new int[nums1.length];
        int index = 0;
        for (int num : nums2) {
            int count = map.getOrDefault(num, 0);
            if (count > 0) {
                intersection[index++] = num;
                count--;
                if (count > 0) {
                    map.put(num, count);
                } else {
                    map.remove(num);
                }
            }
        }
        return Arrays.copyOfRange(intersection, 0, index);
    }


}
