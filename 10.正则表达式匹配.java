/*
 * @lc app=leetcode.cn id=10 lang=java
 *
 * [10] 正则表达式匹配
 */

// @lc code=start
class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] match = new boolean[s.length() + 1][p.length() + 1];
        match[0][0] = true;

        for (int i = 0; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j - 1) == '*') {
                    if (matches(s, p, i, j - 1)) {
                        match[i][j] = match[i - 1][j] || match[i][j - 2];
                    } else {
                        match[i][j] = match[i][j - 2];
                    }
                } else {
                    if (matches(s, p, i, j)) {
                        match[i][j] = match[i - 1][j - 1];
                    }
                }
            }
        }

        return match[s.length()][p.length()];
    }

    private boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }

        if (p.charAt(j - 1) == '.') {
            return true;
        }

        return s.charAt(i - 1) == p.charAt(j - 1);
    }
}
// @lc code=end
