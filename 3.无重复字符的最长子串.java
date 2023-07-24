import java.util.HashMap;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=3 lang=java
 *
 * [3] 无重复字符的最长子串
 */

// @lc code=start
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int maxLen = 0, left = 0, right = 0;
        Set<Character> letterSet = new HashSet<>();

        while (right < s.length()) {
            if (!letterSet.contains(s.charAt(right))) {
                letterSet.add(s.charAt(right++));
                maxLen = Math.max(maxLen, letterSet.size());
            } else {
                letterSet.remove(s.charAt(left++));
            }
        }

        return maxLen;
    }
}
// @lc code=end

