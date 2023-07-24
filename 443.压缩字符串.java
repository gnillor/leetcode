/*
 * @lc app=leetcode.cn id=443 lang=java
 *
 * [443] 压缩字符串
 */

// @lc code=start

class Solution {
    public int compress(char[] chars) {
        int write = 0, left = 0;
        for (int i = 0; i < chars.length; i++) {
            if (i == chars.length - 1 || chars[i + 1] != chars[left]) {
                int count = i - left + 1;
                chars[write++] = chars[left];
                if (count > 1) {
                    String countStr = "" + count;
                    for (int j = 0; j < countStr.length(); j++) {
                        chars[write++] = countStr.charAt(j);
                    }
                }
                left = i + 1;
            }
        }
        return write;
    }
}
// @lc code=end

