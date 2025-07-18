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
    public void helper(TreeNode root,int lvl,int[] maxLvl,int[] res) {
        if(root == null) return;
        if(root.left == null && root.right == null) {
            if(lvl > maxLvl[0]) {
                res[0] = root.val;
                maxLvl[0] = lvl;
            }
            return;
        }
        helper(root.left,lvl+1,maxLvl,res);
        helper(root.right,lvl+1,maxLvl,res);
    }
    public int findBottomLeftValue(TreeNode root) {
        int[] res = new int[1];
        int[] maxLvl = new int[1];
        maxLvl[0] = -1;
        helper(root,0,maxLvl,res);
        return res[0];
    }
}