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
    public void helper(TreeNode root,int targetSum,List<List<Integer>> res,List<Integer> list) {
        if(root == null) return;
        list.add(root.val);
        if(root.left == null && root.right == null) {
            if(targetSum == root.val) {
                res.add(new ArrayList<>(list));
                // return;
            }
            // return;
        }
        
        helper(root.left,targetSum-root.val,res,list);
        helper(root.right,targetSum-root.val,res,list);
        list.remove(list.size()-1);
    }
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(root,targetSum,ans,new ArrayList<>());
        return ans;
    }
}