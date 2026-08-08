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

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> order = new ArrayList<>();
        s_helper(root, order);   
        return String.join(",", order);
    }

    public void s_helper(TreeNode root, List<String> order){
        if(root == null){
            order.add("#");
            return;
        }

        order.add(Integer.toString(root.val));
        s_helper(root.left, order);
        s_helper(root.right, order);
        
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] tokens = data.split(",");
        int[] global_index = new int[]{0};
        return d_helper(tokens, global_index);
    }

    public TreeNode d_helper(String[] tokens, int[] global_index){
        if(tokens[global_index[0]].equals("#")){
            global_index[0]++;
            return null;
        }

        int val = Integer.parseInt(tokens[global_index[0]]);
        TreeNode node = new TreeNode(val);
        global_index[0]++;

        node.left = d_helper(tokens, global_index);
        node.right = d_helper(tokens, global_index);

        return node;
    }
}
