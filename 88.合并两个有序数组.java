/*
 * @lc app=leetcode.cn id=88 lang=java
 *
 * [88] 合并两个有序数组
 */

// @lc code=start
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int left = m - 1, right = n - 1;
        for (int i = nums1.length - 1; i >= 0; i--) {
            if (left < 0) {
                nums1[i] = nums2[right--];
            } else if (right < 0) {
                nums1[i] = nums1[left--];
            } else if (nums1[left] >= nums2[right]) {
                nums1[i] = nums1[left--];
            } else {
                nums1[i] = nums2[right--];
            }
        }
    }
}
// @lc code=end

