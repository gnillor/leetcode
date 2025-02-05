/*
 * @lc app=leetcode.cn id=17 lang=java
 *
 * [17] 电话号码的字母组合
 */

// @lc code=start
class Solution {
    private List<String> combineList = new ArrayList();
    private StringBuilder combineBuilder = new StringBuilder();
    private String[] phoneLetters = new String[] { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0) {
            return combineList;
        }

        backtrack(digits, 0);
        return combineList;
    }

    private void backtrack(String digits, int idx) {
        if (combineBuilder.length() == digits.length()) {
            combineList.add(combineBuilder.toString());
            return;
        }

        String letter = phoneLetters[digits.charAt(idx) - '0'];
        for (int i = 0; i < letter.length(); i++) {
            combineBuilder.append(letter.charAt(i));
            backtrack(digits, idx + 1);
            combineBuilder.deleteCharAt(idx);
        }
    }
}
// @lc code=end
