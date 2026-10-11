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
    int maxPath = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxSegment(root);

        return maxPath;
    }

    private int maxSegment(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSegment = Math.max(maxSegment(root.left), 0);
        int rightSegment = Math.max(maxSegment(root.right), 0);
        int maxLocalPath = root.val + leftSegment + rightSegment;
        
        maxPath = Math.max(maxPath, maxLocalPath);
        return Math.max(leftSegment, rightSegment) + root.val;
    }
}
