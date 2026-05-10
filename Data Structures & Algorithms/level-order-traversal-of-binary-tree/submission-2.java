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
        if(root == null){
            return new ArrayList<>();
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);

        List<List<Integer>> output = new ArrayList<>();

        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> row = new ArrayList<>();

            for(int i = 0; i < size; i++){

                TreeNode cur = q.poll();
                row.add(cur.val);

                if(cur.left != null){
                    q.add(cur.left);
                }
                if(cur.right != null){
                    q.add(cur.right);
                }
            }
            output.add(new ArrayList(row)); 
        }

        return output;
    }
}
