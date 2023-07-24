/*
 * @lc app=leetcode.cn id=437 lang=java
 *
 * [437] 路径总和 III
 */

// @lc code=start

import java.util.Map;

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
    long preSum = 0L;
    int count = 0;
    int targetSum = 0;

    public int pathSum(TreeNode root, int targetSum) {
        this.targetSum = targetSum;

        Map<Long, Integer> preSumMap = new HashMap<>();
        preSumMap.put(0L, 1);
        dfs(root, preSumMap);
        return count;
    }

    private void dfs(TreeNode node, Map<Long, Integer> preSumMap) {
        if (node == null) {
            return;
        }

        preSum += node.val;
        count += preSumMap.getOrDefault(preSum - targetSum, 0);

        preSumMap.put(preSum, preSumMap.getOrDefault(preSum, 0) + 1);
        dfs(node.left, preSumMap);
        dfs(node.right, preSumMap);
        preSumMap.put(preSum, preSumMap.get(preSum) - 1);
        preSum -= node.val;
    }
}
// @lc code=end

