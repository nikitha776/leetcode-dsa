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
    public int helper(TreeNode root,int[] dia) {
        if(root == null) return 0;
        int left = helper(root.left,dia);
        int right = helper(root.right,dia);
        int d = left+right;
        dia[0] = Math.max(dia[0],d);
        return Math.max(left,right)+1;
    }
    public int diameterOfBinaryTree(TreeNode root) {
        int[] d = new int[1];
        helper(root,d);
        return d[0];
    }
}