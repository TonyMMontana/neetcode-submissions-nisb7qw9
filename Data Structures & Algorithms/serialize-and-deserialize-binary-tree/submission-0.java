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

public class Codec {
    int i;
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        return dfs(root);
    }

    private String dfs(TreeNode node) {
        if(node == null) {
           return "N,";
        }
        String left = dfs(node.left);
        String right = dfs(node.right);
        return node.val + "," + left + right;
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] dataArr = data.split(",");
        i = 0;
        return buildTree(dataArr);
    }

    private TreeNode buildTree(String[] data) {
        String val = data[i];
        i++;
        //base
        if(val.equals("N")) {
            return null;
        }
        //new node
        TreeNode root = new TreeNode(Integer.parseInt(val));
        root.left = buildTree(data);
        root.right = buildTree(data);
        return root;
    }


}
