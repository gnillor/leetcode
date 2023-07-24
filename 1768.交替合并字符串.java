/*
 * @lc app=leetcode.cn id=1768 lang=java
 *
 * [1768] 交替合并字符串
 */

// @lc code=start
class Solution {
    public String mergeAlternately(String word1, String word2) {
        if (word1 == null && word2 == null) {
            return null;
        }

        int word1Idx = 0;
        int word2Idx = 0;
        int len1 = word1.length();
        int len2 = word2.length();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < len1 + len2; i++) {
            if (word1Idx < len1) {
                builder.append(word1.charAt(word1Idx));
                word1Idx++;
            }

            if (word2Idx < len2) {
                builder.append(word2.charAt(word2Idx));
                word2Idx++;
            }
        }

        return builder.toString();
    }
}
// @lc code=end

