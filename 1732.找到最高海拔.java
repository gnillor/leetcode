/*
 * @lc app=leetcode.cn id=1732 lang=java
 *
 * [1732] 找到最高海拔
 */

// @lc code=start
class Solution {
    public int largestAltitude(int[] gain) {
        int cursor = 0, largest = 0;
        for (int i = 0; i < gain.length; i++) {
            cursor += gain[i];
            largest = Math.max(largest, cursor);
        }

        return largest;
    }
}
// @lc code=end

