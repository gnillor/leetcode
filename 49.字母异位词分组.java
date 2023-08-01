/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] 字母异位词分组
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class Solution {
    Map<String, List<String>> charsMap = new HashMap();

    public List<List<String>> groupAnagrams(String[] strs) {
        for (int i = 0; i < strs.length; i++) {
            char[] chars = new char[26];
            for (int j = 0; j < strs[i].length(); j++) {
                chars[strs[i].charAt(j) - 'a']++;
            }
            String sortedStr = String.valueOf(chars);

            if (charsMap.containsKey(sortedStr)) {
                charsMap.get(sortedStr).add(strs[i]);
            } else {
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                charsMap.put(sortedStr, list);
            }
        }

        return new ArrayList<List<String>>(charsMap.values());
    }
}
// @lc code=end

