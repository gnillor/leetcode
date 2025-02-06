/*
 * @lc app=leetcode.cn id=11 lang=java
 *
 * [11] 盛最多水的容器
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int maxRet = Integer.MIN_VALUE;
        while (l < r && r > 0) {
            int area = (r - l) * Math.min(height[l], height[r]);
            if (area > maxRet) {
                maxRet = area;
            }

            if (height[l] <= height[r]) {
                l++;
            } else {
                r--;
            }
        }

        return maxRet;
    }
}
// @lc code=end
