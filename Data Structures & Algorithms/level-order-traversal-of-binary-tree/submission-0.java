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
        List<List<Integer>> levelOrder = new ArrayList<>();
        levelOrderHelper(root, 0, levelOrder);

        return levelOrder;
    }

    private void levelOrderHelper(TreeNode root, int depth, List<List<Integer>> levelOrder) {
        if (root == null) return;
        if (depth == levelOrder.size()) {
            levelOrder.add(new ArrayList<>());
        }
        levelOrder.get(depth).add(root.val);

        levelOrderHelper(root.left, depth + 1, levelOrder);
        levelOrderHelper(root.right, depth + 1, levelOrder);
    }
}
