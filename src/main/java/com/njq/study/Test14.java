package com.njq.study;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Test14 {

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    private TreeNode getTree() {
        TreeNode node = new TreeNode(4);
        node.right = new TreeNode(10);
        node.left = new TreeNode(3);
        node.left.left = new TreeNode(1);
//        node.left.right = new TreeNode(5);
        node.left.left.left = new TreeNode(-1);
        node.left.left.left.left = new TreeNode(-2);
        return node;
    }

    public static void main(String[] args) {
        Test14 test14 = new Test14();
//        List<List<Integer>> list = test14.getBSL(test14.getTree());
//        list.forEach(n -> {
//            n.forEach(m -> {
//                System.out.print(m + " ");
//            });
//            System.out.println();
//        });


//        TreeNode treeNode = test14.reviseNode(test14.getTree());
//        while (treeNode.left != null) {
//            System.out.println(treeNode.val);
//            treeNode = treeNode.left;
//        }
//        System.out.println(treeNode.val);

        List<String> list = new ArrayList<>();
        list.add("11");
        list.subList(0,5);
        System.out.println(list);
    }


    private List<List<Integer>> getBSL(TreeNode treeNode) {
        if (treeNode == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> resultList = new ArrayList<>();
        LinkedList<TreeNode> list = new LinkedList();
        list.add(treeNode);
        while (list.size() > 0) {
            List<Integer> cenList = new ArrayList<>();
            int size = list.size();
            for (int i = 0; i < size; i++) {
                TreeNode temp = list.poll();
                if (temp != null) {
                    cenList.add(temp.val);
                    if (treeNode.left != null) {
                        list.add(temp.left);
                    }
                    if (treeNode.right != null) {
                        list.add(temp.right);
                    }
                }
            }
            resultList.add(cenList);
        }
        return resultList;
    }


    private TreeNode searchNode(TreeNode node, Integer val) {
        while (node != null && node.val != val) {
            node = node.val > val ? node.left : node.right;
        }
        return node;
    }

    private TreeNode reviseNode(TreeNode treeNode) {
        if (treeNode == null || treeNode.left == null) {
            return treeNode;
        }
        //treeNode1是尾节点
        TreeNode treeNode1 = reviseNode(treeNode.left);
        treeNode.left.left = treeNode;
        treeNode.left = null;
        return treeNode1;
    }


    private int getMax(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        return Math.max(getMax(treeNode.left), getMax(treeNode.right)) + 1;
    }

    private boolean checkIsBalance(TreeNode treeNode) {
        if (treeNode == null) {
            return true;
        }
        return Math.abs(getMax(treeNode.left) - getMax(treeNode.right)) < 1 && checkIsBalance(treeNode.left) && checkIsBalance(treeNode.right);
    }


    private boolean checkIsBST(TreeNode treeNode, Integer min, Integer max) {
        if (treeNode == null) {
            return true;
        }
        if (min != null && min > treeNode.val) {
            return false;
        }
        if (max != null && max < treeNode.val) {
            return false;
        }
        if (!this.checkIsBST(treeNode.left, min, treeNode.val)) {
            return false;
        }
        if (!this.checkIsBST(treeNode.right, treeNode.val, max)) {
            return false;
        }
        return true;
    }

}
