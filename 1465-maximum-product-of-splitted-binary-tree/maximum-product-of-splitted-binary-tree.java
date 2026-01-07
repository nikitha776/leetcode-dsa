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
    public long helper(TreeNode root,long[] max,long totalSum) {
        if(root == null) return 0;
        long sum = helper(root.left,max,totalSum) + helper(root.right,max,totalSum) + root.val;
        long x = (totalSum - sum)*sum;
        max[0] = Math.max(max[0],x);
        return sum;
    }
    public long sum(TreeNode root) {
        if(root == null) return 0;
        long leftSum = sum(root.left);
        long rightSum = sum(root.right);
        return leftSum + rightSum + root.val;
    }
    public int maxProduct(TreeNode root) {
        long totalSum = sum(root);
        long[] max = new long[1];
        helper(root,max,totalSum);
        return (int)(max[0] % 1_000_000_007);
    }
}