/*
 * @lc app=leetcode.cn id=1679 lang=java
 *
 * [1679] K 和数对的最大数目
 */

// @lc code=start

import java.util.Map;

class Solution {
    public int maxOperations(int[] nums, int k) {
        int ret = 0;

        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (numMap.containsKey(k - nums[i]) && numMap.get(k - nums[i]) > 0) {
                ret++;
                numMap.put(k - nums[i], numMap.get(k - nums[i]) - 1);
            } else {
                numMap.put(nums[i], numMap.getOrDefault(nums[i], 0) + 1);
            }
        }

        return ret;
    }
}
// @lc code=end

