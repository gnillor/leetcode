/*
 * @lc app=leetcode.cn id=334 lang=java
 *
 * [334] 递增的三元子序列
 */

// @lc code=start
class Solution {
    public boolean increasingTriplet(int[] nums) {
        int min = nums[0];
        int middle = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < min) {
                min = nums[i];
            }

            if (nums[i] > min && nums[i] < middle) {
                middle = nums[i];
            }

            if (nums[i] > middle) {
                return true;
            }
        }

        return false;
    }
}
// @lc code=end
