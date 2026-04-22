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
    public int goodNodes(TreeNode root) { 
      int[] goodNodes = new int[1];
      dfs(root,Integer.MIN_VALUE,goodNodes);
      return goodNodes[0];
    }

    void dfs(TreeNode root,int max , int[] goodNodes){
        if(root==null)return;
        if(root.val>=max){
            max = root.val;
            goodNodes[0]++;
        }
        dfs(root.left,max,goodNodes);
        dfs(root.right,max,goodNodes);
    }
}
