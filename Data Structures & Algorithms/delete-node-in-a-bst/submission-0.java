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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) {
            return root;
        }

        TreeNode parent = null;
        if(root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if(root.val < key) {
            root.right = deleteNode(root.right, key);
        } else {
            if(root.left == null) {
                root = root.right;
            } else if (root.right == null) {
                root = root.left;
            } else {
                int min = findMin(root.right);
                root.val = min;
                root.right = deleteNode(root.right, min);
            }
        }

        return root;
    }

    private int findMin(TreeNode root) {
        int min = root.val;
        while(root != null) {
            min = Math.min(min, root.val);
            root = root.left;
        }
        return min;
    }
}