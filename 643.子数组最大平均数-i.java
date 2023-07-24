/*
 * @lc app=leetcode.cn id=643 lang=java
 *
 * [643] 子数组最大平均数 I
 */

// @lc code=start
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int maxSum = 0, cursor = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i < k) {
                maxSum += nums[i];
                cursor += nums[i];
                continue;
            }

            cursor = cursor - nums[i - k] + nums[i];
            maxSum = Math.max(maxSum, cursor);
        }

        return maxSum / (k * 1.0);
    }
}
// @lc code=end

