package com.njq.study.model;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode next;
    public TreeNode pre;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    /**
     *                      8
     *             /            \
     *          4               12
     *      /     \             /  \
     *    2       6            10    14
     *  /  \    /   \       /   \   /  \
     * 1    3  5    7      9   11   13 15
     * @return
     */
    public TreeNode initThree() {
        TreeNode treeNode = new TreeNode(8);
        treeNode.left = new TreeNode(4);
        treeNode.left.left = new TreeNode(2);
        treeNode.left.right = new TreeNode(6);
        treeNode.left.right.left = new TreeNode(5);
        treeNode.left.right.right = new TreeNode(7);
        treeNode.left.left.left = new TreeNode(1);
        treeNode.left.left.right = new TreeNode(3);

        treeNode.right = new TreeNode(12);
        treeNode.right.left = new TreeNode(10);
        treeNode.right.right = new TreeNode(14);
        treeNode.right.right.left = new TreeNode(13);
        treeNode.right.right.right = new TreeNode(15);
        treeNode.right.left.left = new TreeNode(9);
        treeNode.right.left.right = new TreeNode(11);
        return treeNode;
    }


}
