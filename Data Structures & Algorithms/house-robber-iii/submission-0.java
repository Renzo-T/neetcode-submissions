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
    public int rob(TreeNode root) {
        int[] results = robOrRobNot(root);
        return Math.max(results[0], results[1]);
    }

    private int[] robOrRobNot(TreeNode root) {
        if (root == null) {
            return new int[]{0,0};
        }
        int[] left = robOrRobNot(root.left);
        int[] right = robOrRobNot(root.right);

        int rob = root.val + left[1] + right[1];
        int robNot = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return new int[]{rob, robNot};
    }
}