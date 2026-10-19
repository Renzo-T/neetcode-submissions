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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        bfs(root, res);

        return res;
    }

    private void bfs(TreeNode root, List<Integer> res) {
        // left -> self -> right
        if (root == null) {
            return;
        }
        bfs(root.left, res);
        res.add(root.val);
        bfs(root.right, res);
    }
}