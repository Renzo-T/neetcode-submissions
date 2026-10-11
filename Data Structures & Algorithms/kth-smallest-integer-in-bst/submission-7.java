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
        if (root == null || k < 1) {
            return 0;
        }
        int count = kthSmallestHelper(root.left, k, res);
        if (++count == k) {
            res[0] = root.val;
        }
        count += kthSmallestHelper(root.right, k - count, res);

        return count;
    }
}
