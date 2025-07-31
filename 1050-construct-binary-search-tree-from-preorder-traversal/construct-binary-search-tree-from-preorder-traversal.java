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
    public TreeNode helper(int[] preorder, int[] idx, int ub) {
        if(idx[0] == preorder.length || preorder[idx[0]] > ub) return null;
        TreeNode root = new TreeNode(preorder[idx[0]]);
        idx[0]++;
        root.left = helper(preorder,idx,root.val);
        root.right = helper(preorder,idx,ub);
        return root;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        return helper(preorder,new int[]{0},Integer.MAX_VALUE);
    }
}