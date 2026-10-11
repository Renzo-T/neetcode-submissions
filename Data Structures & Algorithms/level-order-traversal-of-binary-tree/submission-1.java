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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> levelOrderTraversal = new ArrayList<>();
        
        levelOrderHelper(root, 0, levelOrderTraversal);

        return levelOrderTraversal;
    }

    private void levelOrderHelper(TreeNode root, int level, 
            List<List<Integer>> levelOrderTraversal) {
        if (root == null) {
            return;
        }
        if (levelOrderTraversal.size() == level) {
            levelOrderTraversal.add(new ArrayList<>());
        }
        levelOrderTraversal.get(level).add(root.val);

        levelOrderHelper(root.left, level + 1, levelOrderTraversal);
        levelOrderHelper(root.right, level + 1, levelOrderTraversal);
    }
}
