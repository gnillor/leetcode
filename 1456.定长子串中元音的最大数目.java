/*
 * @lc app=leetcode.cn id=1456 lang=java
 *
 * [1456] 定长子串中元音的最大数目
 */

// @lc code=start

import java.util.Set;

class Solution {
    public int maxVowels(String s, int k) {
        int maxVowels = 0, cursor = 0;
        int[] vowels = new int[128];
        vowels['a'] = 1;
        vowels['e'] = 1;
        vowels['i'] = 1;
        vowels['o'] = 1;
        vowels['u'] = 1;
        for (int i = 0; i < s.length(); i++) {
            if (i < k) {
                maxVowels += vowels[s.charAt(i)];
                cursor += vowels[s.charAt(i)];
                continue;
            }

            cursor = cursor - vowels[s.charAt(i - k)] + vowels[s.charAt(i)];
            maxVowels = Math.max(maxVowels, cursor);
        }

        return maxVowels;
    }
}
// @lc code=end

