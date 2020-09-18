package com.njq.study;

import java.util.*;

public class Test13 {


    //    public static void main(String[] args) {
//        Test13 a13 = new Test13();
////        int[] arrays = a13.topKFrequenta(new int[]{7, 8, 9, 1, 2, 3, 1, 2, 1, 1, 4, 4, 4, 4}, 3);
////        for (int i = 0; i < arrays.length; i++) {
////            System.out.println(arrays[i]);
////        }
//
//        a13.topK(new int[]{7, 8, 9, 1, 2, 3, 1, 2, 1, 1, 4, 4, 4, 4}, 3);
//    }

    //----------------------347前K个高频元素---------------------------------------
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> occurrences = new HashMap<Integer, Integer>();
        for (int num : nums) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }

        // int[] 的第一个元素代表数组的值，第二个元素代表了该值出现的次数
        PriorityQueue<int[]> queue = new PriorityQueue<int[]>(new Comparator<int[]>() {
            public int compare(int[] m, int[] n) {
                return m[1] - n[1];
            }
        });
        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            if (queue.size() == k) {
                if (queue.peek()[1] < count) {
                    queue.poll();
                    queue.offer(new int[]{num, count});
                }
            } else {
                queue.offer(new int[]{num, count});
            }
        }
        int[] ret = new int[k];
        for (int i = 0; i < k; ++i) {
            ret[i] = queue.poll()[0];
        }
        return ret;
    }


    public int[] topKFrequenta(int[] nums, int k) {
        Map<Integer, Integer> occurrences = new HashMap<Integer, Integer>();
        for (int num : nums) {
            occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
        }

        List<int[]> values = new ArrayList<int[]>();
        for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
            int num = entry.getKey(), count = entry.getValue();
            values.add(new int[]{num, count});
        }
        int[] ret = new int[k];
        qsort(values, 0, values.size() - 1, ret, 0, k);
        return ret;
    }

    public void qsort(List<int[]> values, int start, int end, int[] ret, int retIndex, int k) {
        int picked = (int) (Math.random() * (end - start + 1)) + start;
        Collections.swap(values, picked, start);

        int pivot = values.get(start)[1];
        int index = start;
        for (int i = start + 1; i <= end; i++) {
            if (values.get(i)[1] >= pivot) {
                Collections.swap(values, index + 1, i);
                index++;
            }
        }
        Collections.swap(values, start, index);

        if (k <= index - start) {
            qsort(values, start, index - 1, ret, retIndex, k);
        } else {
            for (int i = start; i <= index; i++) {
                ret[retIndex++] = values.get(i)[0];
            }
            if (k > index - start + 1) {
                qsort(values, index + 1, end, ret, retIndex, k - (index - start + 1));
            }
        }
    }

    //--------------------------------102按层打印出树节点-------------------------------------------
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<List<Integer>>();
        }
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        //将根节点放入队列中，然后不断遍历队列
        queue.add(root);
        while (queue.size() > 0) {
            //获取当前队列的长度，这个长度相当于 当前这一层的节点个数
            int size = queue.size();
            ArrayList<Integer> tmp = new ArrayList<Integer>();
            //将队列中的元素都拿出来(也就是获取这一层的节点)，放到临时list中
            //如果节点的左/右子树不为空，也放入队列中
            for (int i = 0; i < size; ++i) {
                TreeNode t = queue.remove();
                tmp.add(t.val);
                if (t.left != null) {
                    queue.add(t.left);
                }
                if (t.right != null) {
                    queue.add(t.right);
                }
            }
            //将临时list加入最终返回结果中
            res.add(tmp);
        }
        return res;
    }


    public void topK(int[] nums, int k) {


    }

    private class Aaa {
        private int a;
        private int b;

        public Aaa(int a, int b) {
            this.a = a;
            this.b = b;
        }

        public int getA() {
            return a;
        }

        public void setA(int a) {
            this.a = a;
        }

        public int getB() {
            return b;
        }

        public void setB(int b) {
            this.b = b;
        }
    }

    /**
     * 4
     * /
     * 3
     * /
     * 1
     * /
     * -1
     * /
     * -2
     *
     * @param args
     */
    public static void main(String[] args) {
        Test13 t13 = new Test13();
        TreeNode node = new TreeNode(4);
        node.right = new TreeNode(10);
        node.left = new TreeNode(3);
        node.left.left = new TreeNode(1);
//        node.left.right = new TreeNode(5);
        node.left.left.left = new TreeNode(-1);
        node.left.left.left.left = new TreeNode(-2);
//        System.out.println(t13.isValidBST(node));

//        t13.test(node);
        System.out.println(t13.completeMax(node));

//        DecimalFormat df = new DecimalFormat("#.##");
//        System.out.println(df.format(new BigDecimal(2.20)));
    }

    private TreeNode test(TreeNode treeNode) {
        if (treeNode == null) {
            return null;
        }
        test(treeNode.left);
        System.out.println(treeNode.val);
        test(treeNode.right);
        return treeNode;
    }

    private int completeMax(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        return Math.max(completeMax(treeNode.left), completeMax(treeNode.right)) + 1;
    }

    //---------------------------98校验是否是二叉搜索树----------------------------------
    public boolean isValidBST(TreeNode root) {
        return helper(root, null, null);
    }


    public boolean helper(TreeNode node, Integer lower, Integer upper) {
        if (node == null)
            return true;

        int val = node.val;
        if (lower != null && val <= lower)
            return false;
        if (upper != null && val >= upper)
            return false;

        if (!helper(node.right, val, upper))
            return false;

        if (!helper(node.left, lower, val))
            return false;

        return true;
    }

    //-------------------------------------------------------------
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    //------------------------104获取二叉树的最大深度-------------------------------------
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
        }
    }

    //-----------------------------110校验是否是平衡-----------------------------------------------
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
        }
    }

    public int height(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            return Math.max(height(root.left), height(root.right)) + 1;
        }
    }





    public boolean isBalanceda(TreeNode root) {
        return heighta(root) >= 0;
    }

    public int heighta(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        } else {
            return Math.max(leftHeight, rightHeight) + 1;
        }
    }
    //------------------------------700搜索节点----------------------------------------------
    public TreeNode searchBST(TreeNode root, int val) {
        while (root != null && val != root.val)
            root = val < root.val ? root.left : root.right;
        return root;
    }

    public TreeNode searchNode(TreeNode treeNode, Integer searchValue) {
        if (treeNode == null) {
            return null;
        }
        if (treeNode.val == searchValue) {
            return treeNode;
        } else if (treeNode.val < searchValue) {
            return this.searchNode(treeNode.right, searchValue);
        } else {
            return this.searchNode(treeNode.left, searchValue);
        }
    }
//------------------------------450删除节点----------------------------------------------

    public void deleteNode(TreeNode treeNode, Integer delValue) {
        if (treeNode == null) {
            return;
        }
        if (treeNode.val == delValue) {
//            treeNode.right
        } else if (treeNode.val < delValue) {
            this.deleteNode(treeNode.right, delValue);
        } else {
            this.deleteNode(treeNode.left, delValue);
        }
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;

        // delete from the right subtree
        if (key > root.val)
            root.right = deleteNode(root.right, key);
            // delete from the left subtree
        else if (key < root.val)
            root.left = deleteNode(root.left, key);
            // delete the current node
        else {
            // the node is a leaf
            if (root.left == null && root.right == null) root = null;
                // the node is not a leaf and has a right child
            else if (root.right != null) {
                root.val = successor(root);
                root.right = deleteNode(root.right, root.val);
            }
            // the node is not a leaf, has no right child, and has a left child
            else {
                root.val = predecessor(root);
                root.left = deleteNode(root.left, root.val);
            }
        }
        return root;
    }


    /*
  One step right and then always left
  */
    public int successor(TreeNode root) {
        root = root.right;
        while (root.left != null)
            root = root.left;
        return root.val;
    }

    /*
    One step left and then always right
    */
    public int predecessor(TreeNode root) {
        root = root.left;
        while (root.right != null) root = root.right;
        return root.val;
    }


    //节点中序遍历  是有序的
    public LinkedList<Integer> inorder(TreeNode root, LinkedList<Integer> arr) {
        if (root == null) return arr;
        inorder(root.left, arr);
        arr.add(root.val);
        inorder(root.right, arr);
        return arr;
    }


    //---------------------------222完全二叉树{（计算节点个数）-------------------------------------------------
    // Return tree depth in O(d) time.
    public int computeDepth(TreeNode node) {
        int d = 0;
        while (node.left != null) {
            node = node.left;
            ++d;
        }
        return d;
    }

    // Last level nodes are enumerated from 0 to 2**d - 1 (left -> right).
    // Return True if last level node idx exists.
    // Binary search with O(d) complexity.
    public boolean exists(int idx, int d, TreeNode node) {
        int left = 0, right = (int) Math.pow(2, d) - 1;
        int pivot;
        for (int i = 0; i < d; ++i) {
            pivot = left + (right - left) / 2;
            if (idx <= pivot) {
                node = node.left;
                right = pivot;
            } else {
                node = node.right;
                left = pivot + 1;
            }
        }
        return node != null;
    }

    public int countNodes(TreeNode root) {
        // if the tree is empty
        if (root == null) return 0;

        int d = computeDepth(root);
        // if the tree contains 1 node
        if (d == 0) return 1;

        // Last level nodes are enumerated from 0 to 2**d - 1 (left -> right).
        // Perform binary search to check how many nodes exist.
        int left = 1, right = (int) Math.pow(2, d) - 1;
        int pivot;
        while (left <= right) {
            pivot = left + (right - left) / 2;
            if (exists(pivot, d, root))
                left = pivot + 1;
            else
                right = pivot - 1;
        }

        // The tree contains 2**d - 1 nodes on the first (d - 1) levels
        // and left nodes on the last level.
        return (int) Math.pow(2, d) - 1 + left;
    }

    //-----------------------814二叉树剪枝-----------------------------------------
    public TreeNode pruneTree(TreeNode root) {
        return containsOne(root) ? root : null;
    }

    public boolean containsOne(TreeNode node) {
        if (node == null)
            return false;
        boolean a1 = containsOne(node.left);
        boolean a2 = containsOne(node.right);
        if (!a1)
            node.left = null;
        if (!a2)
            node.right = null;
        return node.val == 1 || a1 || a2;
    }

//-----------------------------------------------------------------------------------


}
