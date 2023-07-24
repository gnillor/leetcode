/*
 * @lc app=leetcode.cn id=1657 lang=java
 *
 * [1657] 确定两个字符串是否接近
 */

// @lc code=start

import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

class Solution {
    public boolean closeStrings(String word1, String word2) {
        int[] word1Arr = new int[26];
        int[] word2Arr = new int[26];

        for (int i = 0; i < word1.length(); i++) {
            word1Arr[word1.charAt(i) - 'a']++;
        }

        for (int i = 0; i < word2.length(); i++) {
            word2Arr[word2.charAt(i) - 'a']++;
        }

        for (int i = 0; i < word1Arr.length; i++) {
            if (word1Arr[i] == word2Arr[i]) {
                continue;
            }

            if (word1Arr[i] == 0 || word2Arr[i] == 0) {
                return false;
            }
        }

        Arrays.sort(word1Arr);
        Arrays.sort(word2Arr);
        for (int i = 0; i < word1Arr.length; i++) {
            if (word1Arr[i] != word2Arr[i]) {
                return false;
            }
        }

        return true;
    }
}
// @lc code=end

