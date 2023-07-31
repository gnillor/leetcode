/*
 * @lc app=leetcode.cn id=39 lang=java
 *
 * [39] 组合总和
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> ret = new ArrayList<>();
    int[] nums = null;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.nums = candidates;
        backtrace(new ArrayList(), 0, target);

        return ret;
    }

    private void backtrace(List<Integer> prevList, int idx, int target) {
        int count = target / nums[idx] + 1;
        for (int i = 0; i < count; i++) {
            int value = nums[idx] * i;
            if (value == target && i > 0) {
                addLastElements(prevList, i, nums[idx]);
                ret.add(new ArrayList<Integer>(prevList));
                removeLastElements(prevList, i);
            }

            if (value < target && idx < nums.length - 1) {
                addLastElements(prevList, i, nums[idx]);
                backtrace(prevList, idx + 1, target - nums[idx] * i);
                removeLastElements(prevList, i);
            }
        }
    }

    private void addLastElements(List<Integer> list, int count, int element) {
        for (int i = 0; i < count; i++) {
            list.add(element);
        }
    }

    private void removeLastElements(List<Integer> list, int count) {
        for (int i = 0; i < count; i++) {
            list.remove(list.size() - 1);
        }
    }
}
// @lc code=end

