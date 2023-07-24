/*
 * @lc app=leetcode.cn id=2300 lang=java
 *
 * [2300] 咒语和药水的成功对数
 */

// @lc code=start
class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] ret = new int[spells.length];

        Arrays.sort(potions);

        for (int i = 0; i < spells.length; i++) {
            int left = search(potions, spells[i], success);
            ret[i] = potions.length - left;
        }

        return ret;
    }

    private int search(int[] arr, int spell, long num) {
        int right = arr.length - 1, left = 0;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if ((long) arr[mid] * spell >= num) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}
// @lc code=end

