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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<TreeNode> q  = new LinkedList<>();
        boolean isLeft = true;
        q.add(root);
        while(!q.isEmpty()) {
            int n = q.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0;i < n;i++) {
                TreeNode temp = q.poll();
                if(isLeft) {
                    list.add(temp.val);
                } else {
                    list.add(0,temp.val);
                }
                if(temp.left != null) q.add(temp.left);
                if(temp.right != null) q.add(temp.right);
            }
            res.add(list);
            isLeft = !isLeft;
        }
        return res;
    }
}