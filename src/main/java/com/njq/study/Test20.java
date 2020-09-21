package com.njq.study;

import com.njq.study.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test20 {

    public static void main(String[] args) {
//        DateTime firstDay = new DateTime("2020-01-01");
//        for(int i=0;i<365;i=i+7){
//            System.out.println(firstDay.plusDays(i).dayOfWeek().withMaximumValue().minusDays(1).toString("yyyy-MM-dd"));
//            System.out.println(firstDay.plusDays(i).dayOfWeek().withMaximumValue().toString("yyyy-MM-dd"));
//        }

//        System.out.println(new DateTime("2020-01-01").toString("yyyy-MM-dd"));

//        Test20 t2 = new Test20();
//        int[] array = new int[]{1, 1, 2, 2, 4, 5, 5, 6};
//        int[] a = t2.singleNumber(array);
//        for (int i = 0; i < a.length; i++) {
//            System.out.println(a[i]);
//        }


        System.out.println(~2);
    }

    public int[] singleNumber(int[] nums) {
        int bitmask = 0;
        for (int num : nums)
            bitmask ^= num;
        int diff = bitmask & (-bitmask);
        int x = 0;
        for (int num : nums)
            if ((num & diff) != 0)
                x ^= num;

        return new int[]{x, bitmask ^ x};
    }


    public int getMax(TreeNode treeNode) {

        List<List<Integer>> list = new ArrayList<>();
        LinkedList<TreeNode> temp = new LinkedList<>();
        temp.push(treeNode);
        while (temp.size() > 0) {
            List<Integer> t = new ArrayList<>();
            int length = temp.size();
            for (int i = 0; i < length; i++) {
                TreeNode node = temp.removeFirst();
                t.add(node.val);
                if (node.left != null) {
                    temp.addLast(node.left);
                }
                if (node.right != null) {
                    temp.addLast(node.right);
                }
            }
            list.add(t);
        }
        return list.size();
    }

}
