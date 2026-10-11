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
    public int kthSmallest(TreeNode root, int k) {
        int[] res = new int[1];
        kthSmallestHelper(root, k, res);

        return res[0];
    }
// nth value of the root is parent + root.left
    private int kthSmallestHelper(TreeNode root, int k, int[] res) {
        if (root == null) {
            return 0;
        }
        int leftCt = kthSmallestHelper(root.left, k, res);
        if (leftCt + 1 == k) {
            res[0] = root.val;
        }
        int rightCt = kthSmallestHelper(root.right, k - leftCt - 1, res);

        return leftCt + rightCt + 1;
    }
}
