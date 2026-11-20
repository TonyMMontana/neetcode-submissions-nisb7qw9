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
        if(root == null) {
            return Collections.emptyList();
        }
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        while(!q.isEmpty()) {
            int lvl = q.size();
            
            List<Integer> arr = new ArrayList<>();
            for(int i = 0; i < lvl; i++) {
                TreeNode node = q.poll();
          
                arr.add(node.val);
                if(node.left != null) q.add(node.left);
                if(node.right != null) q.add(node.right);
                
            }
            res.add(arr);
        }
        return res;
    }
}
