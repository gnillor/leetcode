/*
 * @lc app=leetcode.cn id=112 lang=java
 *
 * [112] 路径总和
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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, 0, targetSum);
    }

    private boolean dfs(TreeNode node, int preSum, int targetSum) {
        if (node == null) {
            return false;
        }

        int sum = preSum + node.val;

        if (node.left == null && node.right == null) {
            return sum == targetSum;
        }

        return dfs(node.left, sum, targetSum) || dfs(node.right, sum, targetSum);
    }
}
// @lc code=end

