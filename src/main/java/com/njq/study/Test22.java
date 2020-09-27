package com.njq.study;

import com.njq.study.model.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Test22 {

    public static void main(String[] args) {
        Test22 t22 = new Test22();
//        t22.generate(3);

//        t22.getRow(5);


//        System.out.println(MessageFormat.format("aa{0}bb", 1, 2));
//        int[] array = new int[]{8, 4, 12, 0, 5};
//        t22.convert(array);
        t22.c(new TreeNode().initThree());
        //8 4 2 1 3 6 5 7  12 10 9 11 14 13 15
        //1 2 3 4 5 6 7 8  9 10 11 12 13 14 15
    }

    public List<List<Integer>> generate(int numRows) {
        if (numRows == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> first = new ArrayList<>();
        first.add(1);
        result.add(first);
        for (int i = 1; i < numRows; i++) {
            List<Integer> preList = result.get(result.size() - 1);
            List<Integer> row = new ArrayList<>();
            row.add(1);
            for (int j = 1; j < preList.size(); j++) {
                row.add(preList.get(j) + preList.get(j - 1));
            }
            row.add(1);
            result.add(row);
        }
        return result;
    }


    public List<Integer> getRow(int rowIndex) {
        int[][] row = new int[rowIndex][rowIndex];
        for (int i = 0; i < rowIndex; i++) {
            for (int j = 0; j <= i; j++) {
                if (j - 1 >= 0) {
                    row[i][j] = row[i - 1][j] + row[i - 1][j - 1];
                } else {
                    row[i][j] = 1;
                }
            }
        }

        for (int i = 0; i < row.length; i++) {
            System.out.print("[");
            for (int j = 0; j < row[i].length; j++) {
                System.out.print(row[i][j] + " ");
            }
            System.out.println("]");
        }


//        rowIndex++;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < rowIndex; i++) {
            if (i == 0) {
                list.add(1);
            } else {
                long num = (long) list.get(i - 1) * (long) (rowIndex - i) / i;
                list.add((int) num);
            }
        }
        //第X行第y个位置值的公式为  list.get(y-1)*(x-y)/y
        //比如第5行第3个位置， 第3个位置y=2 ，list.get(1)=4,   4*(5-2)/2=6
        //比如第5行第4个位置  6*(5-3)/3=4
        System.out.println(list);


        return null;
    }


    public int fib(int N) {
        if (N < 2) {
            return 1;
        }
        int a = 1;
        int b = 1;
        int temp = 0;
        for (int i = 2; i < N; i++) {
            temp = a;
            a = b;
            b = b + temp;
        }
        return b;
    }


    public TreeNode convert(int[] array) {
        TreeNode node = new TreeNode(array[0]);
        this.c(node, 1, array);

        return node;
    }


    public void c(TreeNode node, int index, int[] array) {
        if ((index + 1) >= array.length) {
            return;
        }
        if (array[index] != 0) {
            node.left = new TreeNode(array[index]);
            this.c(node.left, 2 * index + 1, array);
        }
        if (array[index + 1] != 0) {
            node.right = new TreeNode(array[index + 1]);
            this.c(node.right, 2 * index + 2, array);
        }
    }


    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        TreeNode merged = new TreeNode(t1.val + t2.val);
        merged.left = mergeTrees(t1.left, t2.left);
        merged.right = mergeTrees(t1.right, t2.right);
        return merged;

    }

    public void c(TreeNode node){
        if(node == null){
            return;
        }

        this.c(node.left);
        System.out.print(node.val+" ");
        this.c(node.right);

    }






    int base, count, maxCount;
    List<Integer> answer = new ArrayList<Integer>();

    public int[] findMode(TreeNode root) {
        TreeNode cur = root, pre = null;
        while (cur != null) {
            if (cur.left == null) {
                update(cur.val);
                cur = cur.right;
                continue;
            }
            pre = cur.left;
            while (pre.right != null && pre.right != cur) {
                pre = pre.right;
            }
            if (pre.right == null) {
                pre.right = cur;
                cur = cur.left;
            } else {
                pre.right = null;
                update(cur.val);
                cur = cur.right;
            }
        }
        int[] mode = new int[answer.size()];
        for (int i = 0; i < answer.size(); ++i) {
            mode[i] = answer.get(i);
        }
        return mode;
    }

    public void update(int x) {
        if (x == base) {
            ++count;
        } else {
            count = 1;
            base = x;
        }
        if (count == maxCount) {
            answer.add(base);
        }
        if (count > maxCount) {
            maxCount = count;
            answer.clear();
            answer.add(base);
        }
    }

}
