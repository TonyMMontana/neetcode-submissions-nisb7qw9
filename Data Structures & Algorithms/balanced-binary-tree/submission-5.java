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
    public boolean isBalanced(TreeNode root) {
        boolean[] res = new boolean[1];
        res[0] = true;
        dfs(root, res);
        return res[0];
    }

    private int dfs(TreeNode node, boolean[] res) {
        if(node == null) {
            return 0;
        }
        int leftHeight = dfs(node.left, res);
        int rightHeight = dfs(node.right, res);
        res[0] = res[0] ? Math.max(leftHeight, rightHeight) - Math.min(leftHeight, rightHeight) <= 1 : false;
        return Math.max(leftHeight, rightHeight) + 1;
    }
}
