/*
 * @lc app=leetcode.cn id=2352 lang=java
 *
 * [2352] 相等行列对
 */

// @lc code=start

import java.util.Arrays;
import java.util.Map;

class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        Map<String, Integer> rowCountMap = new HashMap<>();
        for (int[] row : grid) {
            String rowStr = Arrays.toString(row);
            rowCountMap.put(rowStr, rowCountMap.getOrDefault(rowStr, 0) + 1);
        }

        int ret = 0;
        for (int i = 0; i < n; i++) {
            int[] arr = new int[n];
            for (int j = 0; j < n; j++) {
                arr[j] = grid[j][i];
            }
            String column = Arrays.toString(arr);
            ret += rowCountMap.getOrDefault(column, 0);
        }
        return ret;
    }
}
// @lc code=end

