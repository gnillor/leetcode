/*
 * @lc app=leetcode.cn id=1372 lang=java
 *
 * [1372] 二叉树中的最长交错路径
 */

// @lc code=start

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int maxLength = 0;

    public int longestZigZag(TreeNode root) {
        dfs(root, 0, 0);
        return maxLength;
    }

    private void dfs(TreeNode node, int preLeftLength, int preRightLength) {
        if (node == null) {
            return;
        }

        this.maxLength = Math.max(maxLength, Math.max(preLeftLength, preRightLength));
        dfs(node.left, 0, preLeftLength + 1);
        dfs(node.right, preRightLength + 1, 0);
    }
}
// @lc code=end

