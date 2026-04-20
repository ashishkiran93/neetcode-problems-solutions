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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> sol = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        dfs(root,0, q, sol);
        return sol;
    }

    void dfs(TreeNode root,int level, Queue<TreeNode> q,List<Integer> sol ){
        if(root==null)return;
        if(q.size()==level){
            q.offer(root);
            sol.add(root.val);
        }
        dfs(root.right,level+1,q,sol);
        dfs(root.left,level+1,q,sol);
    }
}
