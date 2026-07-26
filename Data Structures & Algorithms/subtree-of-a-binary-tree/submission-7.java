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
    int[] flag = new int[1];

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        dfs(root,subRoot);
        return flag[0] == 1;
    }

    public void dfs(TreeNode root, TreeNode sub){
        if(root == null){
            return;
        }

        if(root.val == sub.val){
            if(same(root,sub)){
                flag[0] = 1;
            }
        }

        dfs(root.left, sub);
        dfs(root.right, sub);
    }

    public boolean same(TreeNode root, TreeNode sub){
        if(sub == null && root == null){
            return true;
        }

        if(root == null || sub == null){
            return false;
        }

        if(root.val != sub.val){
            return false;
        }

        return same(root.left, sub.left) && same(root.right, sub.right);
    }
}
