/*
 * @lc app=leetcode.cn id=1004 lang=java
 *
 * [1004] 最大连续1的个数 III
 */

// @lc code=start
class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                k--;
            }

            while (k < 0) {
                if (nums[left++] == 0) {
                    k++;
                }
            }

            maxLen = Math.max(maxLen, i - left + 1);
        }

        return maxLen;
    }
}
// @lc code=end

