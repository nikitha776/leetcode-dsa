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
    public int maxLevelSum(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int maxSum = Integer.MIN_VALUE;
        int maxIdx = -1;
        int lvl = 0;
        while(!q.isEmpty()) {
            lvl++;
            int n = q.size();
            int sum = 0;
            for(int i = 0;i < n;i++) {
                TreeNode curr = q.poll();
                sum += curr.val;
                if(curr.left != null) q.add(curr.left);
                if(curr.right != null) q.add(curr.right);
            }
            if(sum > maxSum) {
                maxSum = sum;
                maxIdx = lvl; 
            }
        }
        return maxIdx;
    }
}