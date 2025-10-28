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
class Pair {
    TreeNode node;
    int idx;
    Pair(TreeNode n,int i) {
        node = n;
        idx = i;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,1));
        int maxWidth = 0;
        while(!q.isEmpty()) {
            int n = q.size();
            int start = 0;
            int last = n-1;
            int min = q.peek().idx;
            for(int i = 0;i < n;i++) {
                Pair p = q.poll();
                TreeNode curr = p.node;
                int idx = p.idx-min;
                if(curr.left != null) {
                    q.add(new Pair(curr.left,(idx-1)*2+1));
                }
                if(curr.right != null) {
                    q.add(new Pair(curr.right,(idx-1)*2+2));
                }
                if(i == 0) start = idx;
                if(i == n-1) last = idx; 
            }
            maxWidth = Math.max(maxWidth,last-start+1);
        }
        return maxWidth;
    }
}