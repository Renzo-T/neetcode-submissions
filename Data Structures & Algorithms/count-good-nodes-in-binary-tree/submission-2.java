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
    public int goodNodes(TreeNode root) {
        return bfs(root, -101);
    }

    private int bfs(TreeNode root, int max) {
        if (root == null) {
            return 0;
        }
        int left = bfs(root.left, Math.max(max, root.val));
        int right = bfs(root.right, Math.max(max, root.val));

        return (root.val >= max ? 1 : 0) + left + right;
    }
}
