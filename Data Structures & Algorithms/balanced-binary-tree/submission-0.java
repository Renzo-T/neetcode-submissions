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
    private class DfsResults {
        boolean balanced;
        int height;
        
        DfsResults(boolean balanced, int height) {
            this.balanced = balanced;
            this.height = height;
        }
    }

    public boolean isBalanced(TreeNode root) {
        return dfs(root).balanced;
    }

    private DfsResults dfs(TreeNode root) {
        if (root == null) {
            return new DfsResults(true, 0);
        }
        if (root.left == null && root.right == null) {
            return new DfsResults(true, 1);
        }
        DfsResults leftResults = dfs(root.left);
        DfsResults rightResults = dfs(root.right);

        boolean isBalanced = leftResults.balanced & rightResults.balanced & Math.abs(leftResults.height - rightResults.height) <= 1;
        return new DfsResults(isBalanced, Math.max(leftResults.height, rightResults.height) + 1);
    }
}
