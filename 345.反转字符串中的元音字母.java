/*
 * @lc app=leetcode.cn id=345 lang=java
 *
 * [345] 反转字符串中的元音字母
 */

// @lc code=start

import java.util.HashSet;
import java.util.LinkedList;

import javax.swing.plaf.basic.BasicScrollPaneUI.ViewportChangeHandler;

class Solution {
    public String reverseVowels(String s) {
        HashSet<Character> vowelSet = new HashSet<>();
        vowelSet.add('a');
        vowelSet.add('A');
        vowelSet.add('e');
        vowelSet.add('E');
        vowelSet.add('i');
        vowelSet.add('I');
        vowelSet.add('o');
        vowelSet.add('O');
        vowelSet.add('u');
        vowelSet.add('U');
        char[] chars = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            while (i < j && !vowelSet.contains(s.charAt(i))) {
                i++;
            }

            while (i < j && !vowelSet.contains(s.charAt(j))) {
                j--;
            }

            char temp = s.charAt(i);
            chars[i] = chars[j];
            chars[j] = temp;
            i++;
            j--;
        }

        return new String(chars);
    }
}
// @lc code=end

