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
        findKthSmallest(root, k, res);
        return res[0];
    }

    private int findKthSmallest(TreeNode root, int k, int[] res) {
        if (root == null || k < 1) {
            return 0;
        }
        int count = findKthSmallest(root.left, k, res);
        if (++count == k) {
            res[0] = root.val;
        }
        count += findKthSmallest(root.right, k-count, res);

        return count;
    }
}
