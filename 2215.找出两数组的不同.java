/*
 * @lc app=leetcode.cn id=2215 lang=java
 *
 * [2215] 找出两数组的不同
 */

// @lc code=start

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

class Solution {
    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        HashSet<Integer> nums1Set = new HashSet<>();
        HashSet<Integer> nums2Set = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            nums1Set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            nums2Set.add(nums2[i]);
        }

        List<List<Integer>> ret = new ArrayList<>();
        List<Integer> nums1List = new ArrayList<>();
        for (int item : nums1Set) {
            if (!nums2Set.contains(item)) {
                nums1List.add(item);
            }
        }
        ret.add(nums1List);

        List<Integer> nums2List = new ArrayList<>();
        for (int item : nums2Set) {
            if (!nums1Set.contains(item)) {
                nums2List.add(item);
            }
        }
        ret.add(nums2List);

        return ret;
    }
}
// @lc code=end

