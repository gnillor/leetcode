/*
 * @lc app=leetcode.cn id=1071 lang=java
 *
 * [1071] 字符串的最大公因子
 */

// @lc code=start
class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }

        String minStr = (str1.length() > str2.length()) ? str2 : str1;
        String maxStr = (str1.length() <= str2.length()) ? str2 : str1;
        for (int i = minStr.length(); i > 0; i--) {
            String childStr = minStr.substring(0, i);
            if (isChildStr(childStr, minStr) && isChildStr(childStr, maxStr)) {
                return childStr;
            }
        }

        return "";
    }

    private boolean isChildStr(String childStr, String str) {
        if (str.length() % childStr.length() != 0) {
            return false;
        }

        int childStrIdx = 0;
        for (int i = 0; i < str.length(); i++) {
            if (childStr.charAt(childStrIdx) != str.charAt(i)) {
                return false;
            }

            childStrIdx++;
            if (childStrIdx == childStr.length()) {
                childStrIdx = 0;
            }
        }

        return true;
    }
}
// @lc code=end

