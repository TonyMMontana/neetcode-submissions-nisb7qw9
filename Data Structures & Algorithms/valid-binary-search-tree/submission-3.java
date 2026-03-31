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
    public boolean isValidBST(TreeNode root) {
        return dfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean dfs(TreeNode node, int leftBorder, int rightBorder) {
        if(node == null) {
            return true;
        }
        
        boolean left =  dfs(node.left, leftBorder, node.val);
        boolean right = dfs(node.right, node.val, rightBorder);

        if(node.val <= leftBorder || node.val >= rightBorder) {
            return false;
        }
        if(node.val >= rightBorder || node.val <= leftBorder) {
            return false;
        }
        
        return left && right;
    }
}
