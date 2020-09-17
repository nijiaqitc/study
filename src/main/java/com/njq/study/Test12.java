package com.njq.study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Test12 {

    public static void main(String[] args) {
        Test12 t = new Test12();
        t.solveNQueens(8);
    }

    int N;              // 记录n
    char[][] board;     // 模拟棋盘
    List<List<String>> schemes = new LinkedList<>();    // 存放合法方案

    public List<List<String>> solveNQueens(int n) {
        N = n;
        board = new char[N][N];
        for (char[] line : board) {     // 初始化
            Arrays.fill(line, '.');
        }
        backtrack(0);   // 从第 1 行开始放皇后
        return schemes;
    }

    public void backtrack(int r) {
        // 结束条件
        if (r == N) {
            // 添加方案
            List<String> scheme = new LinkedList<>();
            for (char[] line : board) {
                scheme.add(String.valueOf(line));
            }
            schemes.add(scheme);
            return;
        }
        // 选择列表
        for (int j = 0; j < N; j++) {
            if (isValid(r, j)) {             // 合法才能选
                board[r][j] = 'Q';          // 选择
                backtrack(r + 1);           // 往下一层搜索
                board[r][j] = '.';          // 撤销选择，以免影响同一行其他位置的摆放
            }
        }
    }

    public boolean isValid(int x, int y) {
        // 同一行
        for (int j = 0; j < y; j++) {
            if (board[x][j] == 'Q') {
                return false;
            }
        }
        // 同一列
        for (int i = 0; i < x; i++) {
            if (board[i][y] == 'Q') {
                return false;
            }
        }
        // 主对角线
        for (int i = x - 1, j = y - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        // 副对角线
        for (int i = x - 1, j = y + 1; i >= 0 && j < N; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }












    public List<List<String>> solveNQueensaa(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] nums = new char[n][n];
        for (int i = 0; i < n; i++) {
            Arrays.fill(nums[i], '.');
        }
        backtrack(nums,0, ans);
        return ans;
    }

    private void backtrack(char[][] nums, int currRow, List<List<String>> ans) {
        int len = nums.length;
        if (len == currRow) {
            List<String> path2 = new ArrayList<>();
            for (int i = 0; i < len; i++) {
                path2.add(String.valueOf(nums[i]));
            }
            ans.add(path2);
            return;
        }

        for (int col = 0; col < len; col++) {
            //判断这个位置是否合适
            boolean isok = true;
            for (int row = 0; row < currRow; row++) {
                //竖的有Q
                if (nums[row][col] == 'Q') {
                    isok = false;
                    break;
                }
                //判断对角线
                if (col + (currRow - row) < len && nums[row][col + (currRow - row)] == 'Q') {
                    isok = false;
                    break;
                }
                if (col - (currRow - row) >= 0 && nums[row][col - (currRow - row)] == 'Q') {
                    isok = false;
                    break;
                }
            }
            if (!isok) {
                continue;
            }
            //满足条件
            nums[currRow][col] = 'Q';
            backtrack(nums, currRow + 1, ans);
            nums[currRow][col] = '.';
        }
    }











    public List<List<String>> solveNQueensbb(int n) {
        List<List<String>> list = new LinkedList<>();

        // 第i个元素 表示第i行上第allPos[i]格上放置皇后
        int[] allPos = new int[n];
        // 表示都未放置
        Arrays.fill(allPos, -1);
        // 当前是第m个皇后
        int m = 0;
        List<int[]> linkedList = new LinkedList<>();
        setIQueen(m, n, allPos, linkedList);

        linkedList.forEach(ints -> {
            List<String> tempList = new ArrayList();
            char[] chars = new char[ints.length];
            for (int t = 0; t < ints.length; t++) {
                Arrays.fill(chars, '.');
                chars[ints[t]] = 'Q';
                tempList.add(new String(chars));
            }
            list.add(tempList);
        });


        return list;
    }

    public void setIQueen(int i, int n, int[] allPos, List<int[]> list) {
        // 尝试放n个皇后，且放成功了
        if (i == n && allPos[i - 1] != -1) {
            list.add(allPos.clone());
            return;
        }
        // 第i个皇后的可能放法
        for(int j = 0; j < n; j++) {
            if (isValid(allPos, i, j)) {
                allPos[i] = j;
                // 放置剩下的元素
                setIQueen(i + 1, n, allPos, list);
                // 第i个位置清空，尝试其他可能
                allPos[i] = -1;
            }
        }
    }

    public boolean isValid(int[] allPos, int i, int j) {
        // 已经放置皇后的位置
        // 判断与当前位置的关系
        int x, y;
        for (x = 0; x < i; x++) {
            y = allPos[x];

            if (y == -1 ) {
                continue;
            }
            y = allPos[x];
            if (y == j) {
                return  false;
            }
            // 对角线
            // 当前位置的对角线 (x, allPos[x]) 不在对角线上
            // y = x + (j - i) 或者 y = -x + (j + i)
            if (y - x == j - i || y + x == j + i){
                return false;
            }
        }

        return true;
    }

}
