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
    public boolean helper(TreeNode root,long lb,long ub) {
        if(root == null) return true;
        if(root.val <= lb || root.val >= ub) return false;
        return helper(root.left,lb,root.val) && helper(root.right,root.val,ub);
    }
    public boolean isValidBST(TreeNode root) {
        return helper(root,-(1l << 31)-1,1l<<31);
    }
}