package com.njq.study;

public class Test19 {

    public static void main(String[] args) {
        int i, level;
        int data[] = {6, 3, 5, 9, 7, 8, 4, 2}; /*原始数组*/
        int btree[] = new int[16];
        for (i = 0; i < 16; i++) btree[i] = 0;
        System.out.print("原始数组内容: \n");
        for (i = 0; i < 8; i++) {
            System.out.print("[" + data[i] + "] ");
        }
        System.out.println();
        for (i = 0; i < 8; i++) {                    /*把原始数组中的值逐一对比*/
            System.out.println("i==>" + i);
            for (level = 1; btree[level] != 0; )   /*比较树根及数组内的值*/ {
                if (data[i] > btree[level])    /*如果数组内的值大于树根，则往右子树比较*/
                    level = level * 2 + 1;
                else                        /*如果数组内的值小于或等于树根，则往左子树比较*/
                    level = level * 2;
            }                               /*如果子树节点的值不为0，则再与数组内的值比较一次*/
            btree[level] = data[i];           /*把数组值放入二叉树*/
            System.out.println("data[" + i + "]==>" + data[i] + "，进入" + " btree[" + level + "]==>" + btree[level]);
        }
        System.out.print("二叉树内容：\n");
        for (i = 1; i < 16; i++) {
            System.out.print("[" + btree[i] + "] ");
        }
        System.out.print("\n");
    }


    //    --------------用数组打印前序遍历--------------------
    int[] data;

    public void setData(int[] data) {
        this.data = data;
    }

    public void frontShow() {
        frontShow(0);
    }


    //前序遍历
    public void frontShow(int index) {
        if (data == null || data.length == 0)
            return;

        //先遍历当前节点的内容
        System.out.println(data[index]);
        //处理左子树，左子节点必须存在
        if (2 * index + 1 < data.length) {
            frontShow(2 * index + 1);
        }
        //处理右子树，右子节点必须存在
        if (2 * index + 2 < data.length) {
            frontShow(2 * index + 2);
        }
    }
}

