package com.njq.study;

import java.util.LinkedList;

public class Graph {
    private int v; // 顶点的个数
    private LinkedList<Integer> adj[]; // 邻接表

    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; ++i) {
            adj[i] = new LinkedList<>();
        }
    }

    public void addEdge(int s, int t) { // s先于t，边s->t
        adj[s].add(t);
    }


    public static void main(String[] args) {
        LinkedList<Long>  aa=  new LinkedList<>();
        aa.add(1L);
//        aa[0]



    }
}