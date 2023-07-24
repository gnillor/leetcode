/*
 * @lc app=leetcode.cn id=1448 lang=java
 *
 * [1448] 统计二叉树中好节点的数目
 */

// @lc code=start

import java.util.List;

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
    private Integer good = 0;

    public int goodNodes(TreeNode root) {
        cal(root, Integer.MIN_VALUE);
        return good;
    }

    public void cal(TreeNode node, int maxVal) {
        if (node.val >= maxVal) {
            good++;
        }

        maxVal = Math.max(maxVal, node.val);
        if (node.left != null) {
            cal(node.left, maxVal);
        }

        if (node.right != null) {
            cal(node.right, maxVal);
        }
    }
}
// @lc code=end

