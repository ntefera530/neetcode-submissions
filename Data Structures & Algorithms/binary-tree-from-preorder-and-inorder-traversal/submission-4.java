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
    HashMap<Integer, Integer> indexes = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        setup(inorder);
        return dfs(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode dfs(int[] preorder, int[] inorder, int startP, int endP, int startI, int endI){
        if(startP > endP || startI > endI){
            return null;
        }

        int val = preorder[startP];
        //the start of the current preorder index;

        TreeNode node = new TreeNode(val);

        //find val in Inorder array 
        // int index = 0;
        // for(int i = 0; i < inorder.length; i++){
        //     if(inorder[i] == val){
        //         index = i;
        //     }
        // }
        int index = indexes.get(val);

        int length_inorder_left = index - startI;
        //int length_inorder_right = endI - index;

        node.left = dfs(
                        preorder, 
                        inorder, 
                        startP + 1, 
                        startP + length_inorder_left,
                        startI,
                        index - 1);

        node.right = dfs(
                        preorder, 
                        inorder, 
                        startP + length_inorder_left + 1, 
                        endP,
                        index + 1,
                        endI);

        return node;
    }

    public void setup(int[] inorder){
        for(int i = 0; i < inorder.length; i++){
            indexes.put(inorder[i], i);
        }
    }
}
