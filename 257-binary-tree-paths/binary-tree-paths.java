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
    public void helper(TreeNode root,List<String> res,String s) {
        if(root == null) return;
        if(root.left == null && root.right == null) {
            s = s + root.val;
            res.add(s);
            return;
        }
        helper(root.left,res,s+root.val+"->");
        helper(root.right,res,s+root.val+"->");
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        helper(root,res,"");
        return res;
    }
}