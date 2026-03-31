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
    int[] res = new int[1];

    public int goodNodes(TreeNode root) {
        dfs(root, root.val);
        return res[0];
    }

    private void dfs(TreeNode node, int biggest) {
        if(node == null) {
            return;
        }
        if(biggest <= node.val) {
            res[0]++;
        }
        biggest = Math.max(biggest, node.val);
        dfs(node.left, biggest);
        dfs(node.right, biggest);
    }
}
