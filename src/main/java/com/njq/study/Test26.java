package com.njq.study;

import com.njq.study.model.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Test26 {

    public static void main(String[] args) {
//        TreeNode node = new TreeNode(1);
//        node.left = new TreeNode(2);
//        node.right = new TreeNode(3);
//        node.left.left = new TreeNode(4);
//        node.left.right = new TreeNode(5);
//        node.right.right = new TreeNode(7);
//        Test26 t26 = new Test26();
//        t26.connect(node);
//        t26.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8);
//        t26.searchRange(new int[]{2, 2}, 2);

//        int[] a = new int[5];
////        Arrays.fill(a,1);
//        for (int i = 0; i < a.length; i++) {
//            System.out.print(a[i] + " ");
//        }
//        int b;
//        System.out.println(b);

        int[] array = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        Test26 test26 = new Test26();
        System.out.println(test26.search(array, 5));

//        new FutureTask<>()


    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if ((root.val <= p.val && root.val >= q.val) || (root.val <= q.val && root.val >= p.val)) {
            return root;
        } else if (root.val > p.val && root.val > q.val) {
            return this.lowestCommonAncestor(root.left, p, q);
        } else {
            return this.lowestCommonAncestor(root.right, p, q);
        }
    }


    public TreeNode connect(TreeNode root) {
        if (root == null) {
            return null;
        }
        root.next = null;
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        TreeNode preNode = null;
        while (list.size() > 0) {
            int length = list.size();
            for (int i = 0; i < length; i++) {
                TreeNode tempNode = list.poll();
                if (i == 0) {
                    preNode = tempNode;
                } else {
                    preNode.next = tempNode;
                    preNode = tempNode;
                }

                if (tempNode.left != null) {
                    list.add(tempNode.left);
                }
                if (tempNode.right != null) {
                    list.add(tempNode.right);
                }
            }
        }

        return root;
    }

    List<Integer> list = new ArrayList<>();

    public List<Integer> postorderTraversal(TreeNode root) {
        this.cen(root);
        return list;
    }

    private void cen(TreeNode root) {
        if (root == null) {
            return;
        }
        this.cen(root.left);
        this.cen(root.right);
        list.add(root.val);
    }


    public int[] searchRange(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }
        int mid = this.search(nums, 0, nums.length - 1, target);
        if (mid == -1) {
            return new int[]{-1, -1};
        }

        int left = mid, right = mid;
        while (left > 0) {
            if (nums[--left] != target) {
                ++left;
                break;
            }
        }
        while (right < (nums.length - 1)) {
            if (nums[++right] != target) {
                --right;
                break;
            }
        }
        return new int[]{left, right};
    }

    private int search(int[] nums, int left, int right, int target) {
        if (left > right) {
            return -1;
        }
        int mid = (left + right) / 2;
        if (nums[mid] > target) {
            return this.search(nums, left, mid - 1, target);
        } else if (nums[mid] < target) {
            return this.search(nums, mid + 1, right, target);
        } else {
            return mid;
        }
    }


    public TreeNode insertIntoBST(TreeNode root, int val) {
        int[] aa = new int[4];
        return null;
    }

    public int search(int[] array, int val) {
        if (array == null) {
            return -1;
        }
        int left = 0;
        int right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (val < array[mid]) {
                right = mid - 1;
            } else if (val > array[mid]) {
                left = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }





}
