/*
 * @lc app=leetcode.cn id=1466 lang=java
 *
 * [1466] 重新规划路线
 */

// @lc code=start

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution {
    private int count;

    public int minReorder(int n, int[][] connections) {
        List<List<Integer>> graph = buildGraph(n, connections);
        boolean[] visited = new boolean[n];
        dfs(0, visited, graph);

        return count;
    }

    private void dfs(int i, boolean[] visited, List<List<Integer>> graph) {
        visited[i] = true;
        List<Integer> cities = graph.get(i);
        for (Integer city : cities) {
            if (!visited[Math.abs(city)]) {
                if (city > 0) {
                    count++;
                }
                dfs(Math.abs(city), visited, graph);
            }
        }
    }

    private List<List<Integer>> buildGraph(int n, int[][] conns) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            List<Integer> cities = new ArrayList<>();
            graph.add(cities);
        }
        for (int i = 0; i < conns.length; i++) {
            int from = conns[i][0];
            int to = conns[i][1];
            graph.get(from).add(to);
            graph.get(to).add(-from);
        }

        return graph;
    }
}
// @lc code=end

