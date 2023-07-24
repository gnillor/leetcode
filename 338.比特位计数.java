/*
 * @lc app=leetcode.cn id=338 lang=java
 *
 * [338] 比特位计数
 */

// @lc code=start
class Solution {
    public int[] countBits(int n) {
        int[] ret = new int[n + 1];
        ret[0] = 0;
        for (int i = 1; i <= n; i++) {
            if (i % 2 == 1) {
                ret[i] = ret[i - 1] + 1;
            } else {
                ret[i] = ret[i / 2];
            }
        }
        return ret;
    }
}
// @lc code=end

