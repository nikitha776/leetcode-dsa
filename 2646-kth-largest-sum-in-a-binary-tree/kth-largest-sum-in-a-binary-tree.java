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
    public long kthLargestLevelSum(TreeNode root, int k) {
        long maxSum = Integer.MIN_VALUE;
        Queue<TreeNode> q = new LinkedList<>();
        PriorityQueue<Long> pq = new PriorityQueue<>();
        q.add(root);
        while(!q.isEmpty()) {
            int n = q.size();
            long sum = 0;
            for(int i = 0;i < n;i++) {
                TreeNode temp = q.poll();
                sum += (long)temp.val;
                if(temp.left != null) q.add(temp.left);
                if(temp.right != null) q.add(temp.right);
            }
            pq.add((long)sum);
            if(pq.size() > k) pq.poll();
        }
        if(pq.size() < k) return -1;
        return pq.poll();
    }
}