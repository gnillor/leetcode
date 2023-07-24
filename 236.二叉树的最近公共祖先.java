/*
 * @lc app=leetcode.cn id=236 lang=java
 *
 * [236] 二叉树的最近公共祖先
 */

// @lc code=start
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Map<TreeNode, TreeNode> parentNodeMap = new HashMap<>();
        dfs(root, parentNodeMap);

        Set<TreeNode> visitedNodeSet = new HashSet<>();
        visitedNodeSet.add(p);
        while (parentNodeMap.containsKey(p)) {
            visitedNodeSet.add(parentNodeMap.get(p));
            p = parentNodeMap.get(p);
        }

        while (parentNodeMap.containsKey(q)) {
            if (visitedNodeSet.contains(q)) {
                return q;
            }

            q = parentNodeMap.get(q);
        }

        return root;
    }

    private void dfs(TreeNode node, Map<TreeNode, TreeNode> parentNodeMap) {
        if (node == null) {
            return;
        }

        if (node.left != null) {
            parentNodeMap.put(node.left, node);
            dfs(node.left, parentNodeMap);
        }

        if (node.right != null) {
            parentNodeMap.put(node.right, node);
            dfs(node.right, parentNodeMap);
        }
    }
}
// @lc code=end

