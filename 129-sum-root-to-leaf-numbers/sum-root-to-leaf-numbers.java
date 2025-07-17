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
    public void helper(TreeNode root,int num,int[] sum) {
        if(root == null) return;
        if(root.left == null && root.right == null) {
            num = num*10+root.val;
            sum[0] += num;
        }
        helper(root.left,num*10+root.val,sum);
        helper(root.right,num*10+root.val,sum);
    }
    public int sumNumbers(TreeNode root) {
        int[] sum = new int[1];
        helper(root,0,sum);
        return sum[0];
    }
}