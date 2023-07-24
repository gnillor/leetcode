/*
 * @lc app=leetcode.cn id=746 lang=java
 *
 * [746] 使用最小花费爬楼梯
 */

// @lc code=start
class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int length = cost.length;
        int prev = 0, curr = 0;
        for (int i = 2; i <= length; i++) {
            int next = Math.min(cost[i - 1] + curr, cost[i - 2] + prev);
            prev = curr;
            curr = next;
        }

        return curr;
    }
}
// @lc code=end

