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
    TreeNode parent;
    Pair(TreeNode node,TreeNode parent) {
        this.node = node;
        this.parent = parent;
    }
}
class Solution {
    public boolean isCousins(TreeNode root, int x, int y) {
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(root,null));
        while(!q.isEmpty()) {
            int n = q.size();
            List<TreeNode> list = new ArrayList<>();
            for(int i = 0;i < n;i++) {
                Pair p = q.poll();
                TreeNode temp = p.node;
                TreeNode parent = p.parent;
                if(temp.val == x || temp.val == y) {
                    if(p != null) list.add(parent);
                } 
                if(temp.left != null) q.add(new Pair(temp.left,temp));
                if(temp.right != null) q.add(new Pair(temp.right,temp));
            }
            if(list.size() == 1) return false;
            if(list.size() == 2 && (list.get(0) != list.get(1))) return true;
        }
        return false;
    }
}