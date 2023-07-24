/*
 * @lc app=leetcode.cn id=2390 lang=java
 *
 * [2390] 从字符串中移除星号
 */

// @lc code=start
class Solution {
    public String removeStars(String s) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '*') {
                builder.deleteCharAt(builder.length() - 1);
            } else {
                builder.append(ch);
            }
        }

        return builder.toString();
    }
}
// @lc code=end

