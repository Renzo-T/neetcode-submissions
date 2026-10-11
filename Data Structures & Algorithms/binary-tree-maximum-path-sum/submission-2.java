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
        int leftSegment = maxSegment(root.left);
        int rightSegment = maxSegment(root.right);
        int maxLocalPath = root.val;
        if (leftSegment > 0) {
            maxLocalPath += leftSegment;
        }
        if (rightSegment > 0) {
            maxLocalPath += rightSegment;
        }
        maxPath = Math.max(maxPath, maxLocalPath);
        return Math.max(Math.max(leftSegment, rightSegment), 0) + root.val;
    }
}
