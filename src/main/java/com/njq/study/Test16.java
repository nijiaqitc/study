package com.njq.study;

import com.njq.study.model.TreeNode;
import org.springframework.util.CollectionUtils;

import java.util.*;

public class Test16 {
    public static void main(String[] args) {

        TreeNode treeNode = new TreeNode();
        Test16 t = new Test16();
//        System.out.println(t.ttt(treeNode.initThree()));
//        TreeNode t1 = treeNode.initThree();
//        t.obvise(t1);
//        t.abc(t1);
//        TreeNode link = t.link(treeNode.initThree());
//        while (link.next != null) {
//            System.out.println(link.val);
//            link = link.next;
//        }

//        Date now = new Date();
//        System.out.println(now.getTime());
//        System.out.println(System.currentTimeMillis());

        List<List<Integer>> list = t.cen(treeNode.initThree());
        list.forEach(n -> {
            n.forEach(m -> {
                System.out.print(m + " ");
            });
        });

    }

    private List<List<Integer>> cen(TreeNode treeNode) {
        List<List<Integer>> result = new ArrayList<>();
        LinkedList<TreeNode> temp = new LinkedList<>();
        temp.add(treeNode);
        while (!CollectionUtils.isEmpty(temp)) {
            List<Integer> cenList = new ArrayList<>();
            int size = temp.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = temp.pop();
                if (node.left != null) {
                    temp.add(node.left);
                }
                if (node.right != null) {
                    temp.add(node.right);
                }
                cenList.add(node.val);
            }
            result.add(cenList);
        }
        return result;
    }


    private boolean check(TreeNode treeNode, Integer min, Integer max) {
        if (treeNode == null) {
            return true;
        }
        if (min != null && treeNode.val <= min) {
            return false;
        }

        if (max != null && treeNode.val >= max) {
            return false;
        }
        if (!this.check(treeNode.left, min, treeNode.val)) {
            return false;
        }
        if (!this.check(treeNode.right, treeNode.val, max)) {
            return false;
        }
        return true;
    }


    private void obvise(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        TreeNode temp = treeNode.left;
        treeNode.left = treeNode.right;
        treeNode.right = temp;

        this.obvise(treeNode.left);
        this.obvise(treeNode.right);


    }

    private int ttt(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        int leftHeight = this.ttt(treeNode.left);
        int rightHeight = this.ttt(treeNode.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }


    private void abc(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        this.abc(treeNode.left);
        System.out.print(treeNode.val + " ");
        this.abc(treeNode.right);
    }


    private TreeNode link(TreeNode treeNode) {
        if (treeNode == null) {
            return null;
        }
        TreeNode leftNode = this.link(treeNode.left);
        if (leftNode != null) {
            leftNode.next = treeNode;
            treeNode.pre = leftNode;
        }
        TreeNode rightNode = this.link(treeNode.right);
        if (rightNode != null) {
            treeNode.next = rightNode;
            rightNode.pre = treeNode;
        }
        return treeNode;
    }










}
