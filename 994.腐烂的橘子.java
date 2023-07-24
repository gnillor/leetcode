/*
 * @lc app=leetcode.cn id=994 lang=java
 *
 * [994] 腐烂的橘子
 */

// @lc code=start
class Solution {
    public int orangesRotting(int[][] grid) {
        int ret = 0;
        int fleshCount = 0;
        int[] dx = {0, -1, 0, 1};
        int[] dy = {-1, 0, 1, 0};

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    fleshCount++;
                }

                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        while (fleshCount > 0 && !queue.isEmpty()) {
            ret++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] idxs = queue.poll();
                int row = idxs[0];
                int col = idxs[1];

                for (int j = 0; j < 4; j++) {
                    int x = row + dx[j];
                    int y = col + dy[j];
                    if (x >= 0 && x < grid.length && y >= 0 && y < grid[row].length && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        fleshCount--;
                        queue.offer(new int[]{x, y});
                    }
                }
            }
        }

        if (fleshCount > 0) {
            return -1;
        }

        return ret;
    }
}
// @lc code=end
