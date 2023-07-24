/*
 * @lc app=leetcode.cn id=20 lang=java
 *
 * [20] 有效的括号
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> charMap = new HashMap<>(3);
        charMap.put(')', '(');
        charMap.put(']', '[');
        charMap.put('}', '{');

        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            if (charMap.containsKey(letter)) {
                if (stack.size() == 0 || stack.pop() != charMap.get(letter)) {
                    return false;
                }
            } else {
                stack.push(letter);
            }
        }

        return stack.size() == 0;
    }
}
// @lc code=end

