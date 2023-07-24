/*
 * @lc app=leetcode.cn id=547 lang=java
 *
 * [547] 省份数量
 */

// @lc code=start

import java.util.Set;

class Solution {
    public int findCircleNum(int[][] isConnected) {
        int ret = 0;
        boolean[] visited = new boolean[isConnected.length];
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                dfs(isConnected, i, visited);
                ret++;
            }
        }
        return ret;
    }

    private void dfs(int[][] isConnected, int i, boolean[] visited) {
        for (int j = 0; j < isConnected.length; j++) {
            if (!visited[j] && isConnected[i][j] == 1) {
                visited[j] = true;
                dfs(isConnected, j, visited);
            }
        }
    }
}
// @lc code=end
