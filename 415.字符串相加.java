/*
 * @lc app=leetcode.cn id=415 lang=java
 *
 * [415] 字符串相加
 */

// @lc code=start
class Solution {
    public String addStrings(String num1, String num2) {
        StringBuilder builder = new StringBuilder();

        int left = num1.length() - 1, right = num2.length() - 1;
        int carry = 0;
        while (left >= 0 || right >= 0 || carry > 0) {
            int lVal = (left >= 0) ? num1.charAt(left) - '0' : 0;
            int rVal = (right >= 0) ? num2.charAt(right) - '0' : 0;

            int sum = lVal + rVal + carry;
            if (sum >= 10) {
                builder.append(sum - 10);
                carry = 1;
            } else {
                builder.append(sum);
                carry = 0;
            }

            left--;
            right--;
        }

        return builder.reverse().toString();
    }
}
// @lc code=end

