/*
 * @lc app=leetcode.cn id=872 lang=java
 *
 * [872] 叶子相似的树
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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leafList1 = new ArrayList<>();
        List<Integer> leafList2 = new ArrayList<>();

        parseLeafNodes(root1, leafList1);
        parseLeafNodes(root2, leafList2);

        return leafList1.equals(leafList2);
    }

    private void parseLeafNodes(TreeNode root, List<Integer> leafList) {
        if (root == null) {
            return;
        }

        if (root.left != null || root.right != null) {
            parseLeafNodes(root.left, leafList);
            parseLeafNodes(root.right, leafList);
            return;
        }

        leafList.add(root.val);
    }
}
// @lc code=end

