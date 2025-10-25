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
    public boolean helper(TreeNode root,int sum) {
        if(root == null) return false;
        if(root.left == null && root.right == null) return sum == root.val;
        boolean left = helper(root.left,sum-root.val);
        boolean right = helper(root.right,sum-root.val);
        return left || right;
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return helper(root,targetSum);
    }
}