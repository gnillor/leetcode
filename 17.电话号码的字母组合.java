/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 */

// @lc code=start
class Solution {
    private List<String> letterList = new ArrayList();
    private StringBuilder letterBuilder = new StringBuilder();
    private String[] phoneLetters = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return letterList;
        }

        backtrack(digits, 0);
        return letterList;
    }

    private void backtrack(String digits, int idx) {
        if (idx == digits.length()) {
            letterList.add(letterBuilder.toString());
            return;
        }

        String letters = phoneLetters[digits.charAt(idx) - '0'];
        for (int i = 0; i < letters.length(); i++) {
            letterBuilder.append(letters.charAt(i));
            backtrack(digits, idx + 1);
            letterBuilder.deleteCharAt(idx);
        }
    }
}
// @lc code=end

