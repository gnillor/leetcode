/*
 * @lc app=leetcode.cn id=22 lang=java
 *
 * [22] 括号生成
 */

// @lc code=start

import java.util.ArrayList;
import java.util.List;

class Solution {
    List<String> ret = new ArrayList<>();
    String left = "(";
    String right = ")";
    private int max = 0;

    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return ret;
        }
        this.max = 2 * n;

        StringBuilder builder = new StringBuilder();
        backtrack(builder, 0, 0);
        return ret;
    }

    private void backtrack(StringBuilder builder, int leftCount, int rightCount) {
        if ((leftCount + rightCount) == max) {
            ret.add(builder.toString());
            return;
        }

        if (leftCount < max / 2) {
            builder.append(left);
            backtrack(builder, leftCount + 1, rightCount);
            builder.deleteCharAt(builder.length() - 1);
        }

        if (rightCount < leftCount) {
            builder.append(right);
            backtrack(builder, leftCount, rightCount + 1);
            builder.deleteCharAt(builder.length() - 1);
        }
    }
}
// @lc code=end
