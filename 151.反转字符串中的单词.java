/*
 * @lc app=leetcode.cn id=151 lang=java
 *
 * [151] 反转字符串中的单词
 */

// @lc code=start

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public String reverseWords(String s) {
        s.trim();
        Deque<String> list = new ArrayDeque<>();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ' && builder.length() > 0) {
                list.offerFirst(builder.toString());
                builder.setLength(0);
                continue;
            }

            if (s.charAt(i) == ' ') {
                continue;
            }

            builder.append(s.charAt(i));
        }

        if (builder.length() > 0) {
            list.offerFirst(builder.toString());
        }

        return String.join(" ", list);
    }
}
// @lc code=end

