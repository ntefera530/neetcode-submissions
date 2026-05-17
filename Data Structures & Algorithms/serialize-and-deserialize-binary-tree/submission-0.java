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
        List<String> res = new ArrayList<>();
        dfsEncode(root,res);
        System.out.print(String.join(",", res));
        return String.join(",", res);
    }

    public void dfsEncode(TreeNode root, List<String> res){
        if(root == null){
            res.add("N");
            return;
        }

        res.add(String.valueOf(root.val));
        dfsEncode(root.left, res);
        dfsEncode(root.right, res);
    }


    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals = data.split(",");

        //used as a global counter in recurion;
        int[] index = new int[]{0};
        return dfsDecode(vals,index);
    }

    public TreeNode dfsDecode(String[] vals, int[] index){
        if(vals[index[0]].equals("N")){
            index[0]++;
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(vals[index[0]]));
        index[0]++;
        node.left = dfsDecode(vals, index);
        node.right = dfsDecode(vals, index);

        return node;
    }

}
