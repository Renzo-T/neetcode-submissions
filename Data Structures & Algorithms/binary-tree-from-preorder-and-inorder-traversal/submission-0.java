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
    int preorderIdx, inorderIdx = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder, inorder, Integer.MAX_VALUE);
    }

    private TreeNode buildTreeHelper(int[] preorder, int[] inorder, int limit) {
        if (preorderIdx >= preorder.length) return null;
        if (inorder[inorderIdx] == limit) {
            inorderIdx++;
            return null;
        }

        TreeNode root = new TreeNode(preorder[preorderIdx++]);
        root.left = buildTreeHelper(preorder, inorder, root.val);
        root.right = buildTreeHelper(preorder, inorder, limit);

        return root;
    }
}
