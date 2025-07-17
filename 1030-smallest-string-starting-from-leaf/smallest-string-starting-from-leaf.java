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
    public void helper(TreeNode root,String str,String[] min) {
        if(root == null) return;
        if(root.left == null && root.right == null) {
            str = (char)(root.val + 'a') + str;
            if(str.compareTo(min[0]) < 0) {
                min[0] = str;
            }
        }
        helper(root.left,(char)(root.val + 'a')+str,min);
        helper(root.right,(char)(root.val + 'a')+str,min);
    }
    public String smallestFromLeaf(TreeNode root) {
        String[] min = new String[1];
        min[0] = "~";
        helper(root,"",min);
        return min[0];
    }
}