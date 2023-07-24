/*
 * @lc app=leetcode.cn id=1431 lang=java
 *
 * [1431] 拥有最多糖果的孩子
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int maxCandies = 0;
        for (int candy : candies) {
            maxCandies = Math.max(candy, maxCandies);
        }

        List<Boolean> ret = new ArrayList<>();
        for (int candy : candies) {
            if (candy + extraCandies >= maxCandies) {
                ret.add(true);
            } else {
                ret.add(false);
            }
        }

        return ret;
    }
}
// @lc code=end
