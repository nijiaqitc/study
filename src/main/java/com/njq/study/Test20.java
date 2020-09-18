package com.njq.study;

import com.njq.study.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test20 {

    public static void main(String[] args) {

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
