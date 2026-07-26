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
    public boolean isBalanced(TreeNode root) {
        int[] flag = new int[1];
        dfs(root, flag);
        return (flag[0] == 0);
    }

    public int dfs(TreeNode root, int[] flag){
        if(root == null){
            return 0;
        }

        int left = dfs(root.left, flag);
        int right = dfs(root.right, flag);

        if(Math.abs(left - right) > 1){
            flag[0] = 1;
        }

        return Math.max(left, right) + 1;
    }
}
