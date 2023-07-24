/*
 * @lc app=leetcode.cn id=724 lang=java
 *
 * [724] 寻找数组的中心下标
 */

// @lc code=start
class Solution {
    public int pivotIndex(int[] nums) {
        int totalSum = 0;
        for (int i = 0; i < nums.length; i++) {
            totalSum += nums[i];
        }

        int prefixSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (prefixSum * 2 == totalSum - nums[i]) {
                return i;
            } else {
                prefixSum += nums[i];
            }
        }

        return -1;
    }
}
// @lc code=end

