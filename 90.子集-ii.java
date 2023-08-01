/*
 * @lc app=leetcode.cn id=90 lang=java
 *
 * [90] 子集 II
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class Solution {
    Map<Integer, Integer> numMap = new HashMap();
    List<Integer> distinctNumList = null;
    List<List<Integer>> ret = new ArrayList();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            numMap.put(nums[i], numMap.getOrDefault(nums[i], 0) + 1);
        }
        distinctNumList = new ArrayList<>(numMap.keySet());

        backtrack(new ArrayList<Integer>(), 0);
        return ret;
    }

    private void backtrack(List<Integer> prevList, int idx) {
        int count = numMap.get(distinctNumList.get(idx));
        for (int i = 0; i <= count; i++) {
            addElements(prevList, distinctNumList.get(idx), i);
            if (idx == distinctNumList.size() - 1) {
                ret.add(new ArrayList<>(prevList));
            } else {
                backtrack(prevList, idx + 1);
            }
            rmElements(prevList, distinctNumList.get(idx), i);
        }
    }

    private void addElements(List<Integer> list, int num, int count) {
        for (int i = 0; i < count; i++) {
            list.add(num);
        }
    }

    private void rmElements(List<Integer> list, int num, int count) {
        for (int i = 0; i < count; i++) {
            list.remove(list.size() - 1);
        }
    }
}
// @lc code=end
