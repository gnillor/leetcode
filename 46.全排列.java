/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start

import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    List<List<Integer>> ret = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    Set<Integer> numSet = new HashSet<>();

    public List<List<Integer>> permute(int[] nums) {
        backtrack(nums);
        return ret;
    }

    private void backtrack(int[] nums) {
        if (numSet.size() == nums.length) {
            ret.add(new ArrayList(list));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (numSet.contains(nums[i])) {
                continue;
            }

            numSet.add(nums[i]);
            list.add(nums[i]);
            backtrack(nums);
            numSet.remove(nums[i]);
            list.remove(list.size() - 1);
        }
    }
}
// @lc code=end

