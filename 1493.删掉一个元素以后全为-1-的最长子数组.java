/*
 * @lc app=leetcode.cn id=1493 lang=java
 *
 * [1493] 删掉一个元素以后全为 1 的最长子数组
 */

// @lc code=start
class Solution {
    public int longestSubarray(int[] nums) {
        int left = 0, maxLen = 0;
        int k = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                k--;
            }

            while (k < 0) {
                if (nums[left++] == 0) {
                    k++;
                }
            }

            maxLen = Math.max(maxLen, i - left);
        }

        return maxLen;
    }
}
// @lc code=end

