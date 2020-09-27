package com.njq.study;

import com.njq.study.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Test21 {

    public static void main(String[] args) {

//        [2,0,3,-4,1]
        // -4 0 1 2 3
        Test21 t21 = new Test21();
        TreeNode t = new TreeNode(1);
        t.left = new TreeNode(0);
        t.left.left = new TreeNode(-4);
        t.right = new TreeNode(2);
        t.right.right = new TreeNode(3);
        t21.convertBST(t);
    }

    int sum = 0;

    public TreeNode convertBSTa(TreeNode root) {
        if (root != null) {
            convertBST(root.right);
            sum += root.val;
            root.val = sum;
            convertBST(root.left);
        }
        return root;
    }


    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        List<Integer> valueList = new ArrayList<>();
        getAllNodeValue(root, valueList);
        TreeNode newNode = new TreeNode(getVal(root.val, valueList));
        this.getNewNode(root, newNode, valueList);
        return newNode;
    }

    public void getNewNode(TreeNode oldNode, TreeNode newNode, List<Integer> valueList) {
        if (oldNode.left != null) {
            newNode.left = new TreeNode(getVal(oldNode.left.val, valueList));
            this.getNewNode(oldNode.left, newNode.left, valueList);
        }
        if (oldNode.right != null) {
            newNode.right = new TreeNode(getVal(oldNode.right.val, valueList));
            this.getNewNode(oldNode.right, newNode.right, valueList);
        }
    }

    public void getAllNodeValue(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        this.getAllNodeValue(node.left, list);
        list.add(node.val);
        this.getAllNodeValue(node.right, list);
    }

    public int getVal(int val, List<Integer> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > val) {
                sum += list.get(i);
            }
        }
        return sum + val;
    }

}
