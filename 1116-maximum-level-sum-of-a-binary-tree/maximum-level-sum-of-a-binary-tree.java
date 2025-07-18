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
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        int maxSum = Integer.MIN_VALUE;
        int lvl = 1;
        int ans = 0;
        while(!q.isEmpty()) {
            int n = q.size();
            int sum = 0;
            for(int i = 0;i < n;i++) {
                TreeNode temp = q.poll();
                sum += temp.val;
                if(temp.left != null) q.add(temp.left);
                if(temp.right != null) q.add(temp.right);
            }
            if(sum > maxSum) {
                ans = lvl;
                maxSum = sum;
            }
            lvl++;
        }
        return ans;
    }
}