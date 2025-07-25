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
    public int helper(TreeNode root,int[] tilt) {
        if(root == null) return 0;
        int leftSum = helper(root.left,tilt);
        int rightSum = helper(root.right,tilt);
        int diff = Math.abs(leftSum - rightSum);
        tilt[0] += diff;
        return root.val + leftSum + rightSum;
    }
    public int findTilt(TreeNode root) {
        int[] tilt = new int[1];
        helper(root,tilt);
        return tilt[0];
    }
}