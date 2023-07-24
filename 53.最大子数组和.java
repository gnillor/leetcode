/*
 * @lc app=leetcode.cn id=53 lang=java
 *
 * [53] 最大子数组和
 */

// @lc code=start
class Solution {
    public int maxSubArray(int[] nums) {
        int preMaxSum = 0, maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int curr = Math.max(preMaxSum + nums[i], nums[i]);
            if (curr > maxSum) {
                maxSum = curr;
            }
            preMaxSum = curr;
        }

        return maxSum;
    }
}
// @lc code=end

