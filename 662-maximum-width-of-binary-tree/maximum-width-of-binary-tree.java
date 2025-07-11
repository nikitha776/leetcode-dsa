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
    int num;
    Pair(TreeNode node,int num) {
        this.node = node;
        this.num = num;
    }
}
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Pair> q = new LinkedList<>();
        int maxWidth = 0;
        if(root == null) return maxWidth;
        q.add(new Pair(root,0));

        while(!q.isEmpty()) {
            int n = q.size();
            int minIdx = q.peek().num;
            int left = 0;
            int right = 0;
            for(int i = 0;i < n;i++) {
                Pair p = q.poll();
                TreeNode temp = p.node;
                int idx = p.num-minIdx;
                if(temp.left != null) q.add(new Pair(temp.left,(2*idx)+1));
                if(temp.right != null) q.add(new Pair(temp.right,(2*idx)+2));
                if(i == 0) left = p.num;
                if(i == n-1) right = p.num;
            }
            maxWidth = Math.max(maxWidth,right-left+1);
        }
        return maxWidth;
    }
}