import java.util.*;

/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int findNum = target - nums[i];
            if (numMap.containsKey(findNum)) {
                return new int[] {numMap.get(findNum), i};
            } else {
                numMap.put(nums[i], i);
            }
        }

        return null;
    }
}
// @lc code=end

