/*
 * @lc app=leetcode.cn id=1207 lang=java
 *
 * [1207] 独一无二的出现次数
 */

// @lc code=start

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> itemMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            itemMap.put(arr[i], itemMap.getOrDefault(arr[i], 0) + 1);
        }

        Set<Integer> itemCountSet = new HashSet<>();
        for (Integer itemCount : itemMap.values()) {
            if (itemCountSet.contains(itemCount)) {
                return false;
            } else {
                itemCountSet.add(itemCount);
            }
        }
        return true;
    }
}
// @lc code=end

