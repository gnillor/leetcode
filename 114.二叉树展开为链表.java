/*
 * @lc app=leetcode.cn id=114 lang=java
 *
 * [114] 二叉树展开为链表
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
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root);
    }

    private TreeNode dfs(TreeNode node) {
        if (node.left == null && node.right == null) {
            return node;
        }

        TreeNode lastLeft = node.left;
        if (lastLeft != null) {
            lastLeft = dfs(node.left);
        }

        TreeNode lastRight = node.right;
        if (lastRight != null) {
            lastRight = dfs(node.right);
        }

        if (lastLeft != null) {
            lastLeft.right = node.right;
        }
        node.right = node.left != null ? node.left : node.right;
        node.left = null;

        return lastRight == null ? lastLeft : lastRight;
    }
}
// @lc code=end

