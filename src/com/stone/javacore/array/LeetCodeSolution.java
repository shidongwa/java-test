package com.stone.javacore.array;

import java.util.*;

/**
 * this demo just wants to find the difference between two ways of initializing arrays
 */
public class LeetCodeSolution {

    public static void main(String[] args) {
        LeetCodeSolution solution = new LeetCodeSolution();
        int n = 3;
        int[][] redEdges = new int[][]{{0,1},{1,2}};
        int[][] blueEdges = new int[][]{};
        int[] ans = solution.shortestAlternatingPaths(n, redEdges, blueEdges);
        System.out.println("ans:" + Arrays.toString(ans));
    }
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        List<Integer>[][] graph = new List[2][n]; // 邻接表按红色和蓝色分别存储
        // what's the difference between the tow initialize way????  Arrays.fill use the one and only one "new ArrayList"
        // object, that is not expected. we expect to fill with different "new ArrayList" object.
        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < n; j++) {
            //Arrays.fill(graph[i], new ArrayList<>());
            graph[i][j] = new ArrayList<>();
            }
        }
        for(int[] edge : redEdges) {
            graph[0][edge[0]].add(edge[1]);
        }
        for(int[] edge : blueEdges) {
            graph[1][edge[0]].add(edge[1]);
        }

/*        for(int i = 0; i < 2; i++) {
            for(int j = 0; j < n; j++) {
                System.out.println("i:" + i + ", j:" + j + ":" + graph[i][j]);
            }
        }*/

        int[][] dist = new int[2][n]; // 当前节点以0:red，1:blue时的最短距离
        for(int i = 0; i < 2; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[0][0] = 0;
        dist[1][0] = 0;

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{0, 0}); // 节点0，红色类型
        queue.offer(new int[]{0, 1}); // 节点0，蓝色类型
        while(!queue.isEmpty()) {
            int[] pair = queue.poll();
            int x = pair[0], t = pair[1];
            for(int y : graph[1-t][x]) {
                if(dist[1-t][y] != Integer.MAX_VALUE) {
                    continue;
                }
                dist[1-t][y] = dist[t][x] + 1;
                queue.offer(new int[]{y, 1-t});
            }
        }

        int[] ans = new int[n];
        for(int i = 0; i < n; i++) {
            ans[i] = Math.min(dist[0][i], dist[1][i]);
            if(ans[i] == Integer.MAX_VALUE) ans[i] = -1;
        }

        return ans;
    }
}
