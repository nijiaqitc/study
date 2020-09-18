package com.njq.study;

import java.util.*;

public class Test17 {
    public static void main(String[] args) {
        Set<Integer> visited = new HashSet<>();
        System.out.println(visited.add(1));
        System.out.println(visited.add(1));


//        int[][] edges = new int[4][2];
//        edges[0][0] = 0;
//        edges[0][1] = 1;
//        edges[1][0] = 0;
//        edges[1][1] = 2;
//        edges[2][0] = 0;
//        edges[2][1] = 3;
//        edges[3][0] = 1;
//        edges[3][1] = 4;
//        Test17 t7 = new Test17();
//        System.out.println(t7.validTree(5, edges));
    }


    public boolean validTree(int n, int[][] edges) {
        if (n - 1 != edges.length) {
            return false;
        }

        Map<Integer, Set<Integer>> graph = new HashMap<>();

        buildGraph(graph, edges, n);

        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> visited = new HashSet<>();

        queue.offer(0);

        while (!queue.isEmpty()) {
            int cur = queue.poll();

            if (!visited.add(cur)) {
                return false;
            }

            for (int nei : graph.get(cur)) {
                queue.offer(nei);

                graph.get(nei).remove(cur);
            }
        }

        return visited.size() == n;
    }

    private void buildGraph(Map<Integer, Set<Integer>> graph, int[][] edges, int n) {
        for (int i = 0; i < n; ++i) {
            graph.put(i, new HashSet<Integer>());
        }

        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
    }


}
