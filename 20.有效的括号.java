/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */

// @lc code=start

import java.util.Map;

class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> signalMap = new HashMap<>();
        signalMap.put(')', '(');
        signalMap.put('}', '{');
        signalMap.put(']', '[');

        for (int i = 0; i < s.length(); i++) {
            if (signalMap.containsKey(s.charAt(i))) {
                if (stack.isEmpty() || stack.pop() != signalMap.get(s.charAt(i))) {
                    return false;
                }

            } else {
                stack.push(s.charAt(i));
            }
        }

        return stack.isEmpty();
    }
}
// @lc code=end
