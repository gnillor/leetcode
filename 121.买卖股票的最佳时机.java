/*
 * @lc app=leetcode.cn id=121 lang=java
 *
 * [121] 买卖股票的最佳时机
 */

// @lc code=start
class Solution {
    public int maxProfit(int[] prices) {
        int preMin = prices[0], ret = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] <= preMin) {
                preMin = prices[i];
            }

            ret = Math.max(ret, prices[i] - preMin);
        }

        return ret;
    }
}
// @lc code=end

