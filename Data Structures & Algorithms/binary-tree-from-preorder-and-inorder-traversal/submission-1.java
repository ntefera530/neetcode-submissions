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
    HashMap<Integer,Integer> inorderIndex;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inorderIndex = new HashMap<>();

        for(int i = 0; i < inorder.length; i++){
            inorderIndex.put(inorder[i], i);
        }

        return dfs(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1); 
    }

    public TreeNode dfs(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd){
        if(preEnd < preStart || inEnd < inStart){
            return null;
        }

        int val = preorder[preStart];
        int split = inorderIndex.get(val);

        TreeNode node = new TreeNode(val);

        int left_inorder_length = split - inStart; 

        node.left = dfs(preorder, 
                        inorder, 
                        preStart + 1, 
                        preStart + left_inorder_length, 
                        inStart, 
                        split -1);

        node.right = dfs(preorder,
                        inorder, 
                        preStart + 1 + left_inorder_length, 
                        preEnd, 
                        split + 1, 
                        inEnd);

        return node;
    }
}

