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
    public void inorder(TreeNode root, int k, int[] counter, int[] res) {
        if(root == null) return;
        inorder(root.left,k,counter,res);
        counter[0]++;
        if(counter[0] == k) res[0] = root.val;
        inorder(root.right,k,counter,res);
    }
    public int kthSmallest(TreeNode root, int k) {
        int[] counter = new int[1];
        int[] res = new int[1];
        inorder(root,k,counter,res);
        return res[0];
    }
}