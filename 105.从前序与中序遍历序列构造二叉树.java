/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
 */

// @lc code=start
class Solution {
    private Map<Integer, Integer> inOrderIdxMap = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inOrderIdxMap.put(inorder[i], i);
        }

        return innerBuildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    private TreeNode innerBuildTree(int[] preorder, int[] inorder, int preLeft, int preRight, int inLeft, int inRight) {
        if (preLeft > preRight) {
            return null;
        }

        int val = preorder[preLeft];
        TreeNode root = new TreeNode(val);

        int inOrderIdx = inOrderIdxMap.get(val);
        int leftChildrenSize = inOrderIdx - inLeft;

        root.left = innerBuildTree(preorder, inorder, preLeft + 1, preLeft + leftChildrenSize, inLeft, inOrderIdx - 1);
        root.right = innerBuildTree(preorder, inorder, preLeft + leftChildrenSize + 1, preRight, inOrderIdx + 1, inRight);

        return root;
    }
}
// @lc code=end

