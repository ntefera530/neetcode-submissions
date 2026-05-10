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
    boolean found = false;  
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        dfs(root,subRoot);
        return found;
    }

    public void dfs(TreeNode root, TreeNode subRoot){
        if(root == null){
            return;
        }

        if(subRoot != null && root.val == subRoot.val){
            found |= found(root, subRoot);
        }

        dfs(root.left, subRoot);
        dfs(root.right, subRoot);
    }

    public boolean found(TreeNode p, TreeNode q){
        if(p == null && q == null){
            return true;
        }

        if(p == null || q == null){
            return false;
        }

        if(p.val != q.val){
            return false;
        }

        return found(p.left,q.left) && found(p.right, q.right);
    }
}
