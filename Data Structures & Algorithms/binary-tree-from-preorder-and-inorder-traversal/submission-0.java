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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return dfs(preorder, inorder); 
    }

    public TreeNode dfs(int[] preorder, int[] inorder){
        if(preorder.length == 0 && inorder.length == 0){
            return null;
        }

        int val = preorder[0];
        int split = 0;

        for(int i = 0; i < inorder.length; i++){
            if(inorder[i] == val){
                split = i;
            }
        }

        TreeNode node = new TreeNode(val);

        int[] leftIn = Arrays.copyOfRange(inorder, 0, split);
        int[] rightIn = Arrays.copyOfRange(inorder, split + 1, inorder.length);  


        int[] leftPre = Arrays.copyOfRange(preorder, 1, 1 + leftIn.length);
        int[] rightPre = Arrays.copyOfRange(preorder, 1 + leftIn.length, preorder.length);     

        node.left = dfs(leftPre,leftIn);

        node.right = dfs(rightPre, rightIn);

        return node;
    }
}
