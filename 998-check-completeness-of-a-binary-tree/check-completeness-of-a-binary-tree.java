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
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean nullEncounter = false;
        while(!q.isEmpty()) {
            int n = q.size();
            for(int i = 0;i < n;i++) {
                TreeNode temp = q.poll();
                if(nullEncounter && temp.left != null) return false;
                if(temp.left == null) nullEncounter = true;
                if(temp.left != null) q.add(temp.left);

                if(nullEncounter && temp.right != null) return false;
                if(temp.right == null) nullEncounter = true;
                if(temp.right != null) q.add(temp.right);
            }
        }
        return true;
    }
}