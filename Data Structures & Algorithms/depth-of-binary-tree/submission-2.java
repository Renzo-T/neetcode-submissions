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
    public int maxDepth(TreeNode root) {
        return depth(root, 1);
    }

    private int depth(TreeNode root, int level) {
        if (root == null) return 0;
        int l = depth(root.left, level + 1);
        int r = depth(root.right, level + 1);
        return Math.max(Math.max(l, r), level);
    }
}
