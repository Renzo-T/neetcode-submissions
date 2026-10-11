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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> rightSide = new ArrayList<>();
        rightSideViewHelper(root, 0, rightSide);

        return rightSide;
    }

    private void rightSideViewHelper(TreeNode root, int depth, List<Integer> rightSide) {
        if (root == null) return;
        if (depth == rightSide.size()) {
            rightSide.add(root.val);
        }

        rightSideViewHelper(root.right, depth + 1, rightSide);
        rightSideViewHelper(root.left, depth + 1, rightSide);
    }
}
