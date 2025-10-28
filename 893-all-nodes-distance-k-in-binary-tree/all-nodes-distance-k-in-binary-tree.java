/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void parentMap(TreeNode root, Map<TreeNode,TreeNode> map) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            TreeNode curr = q.poll();
            if(curr.left != null) {
                q.add(curr.left);
                map.put(curr.left,curr);
            }
            if(curr.right != null) {
                q.add(curr.right);
                map.put(curr.right,curr);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode> map = new HashMap<>();
        parentMap(root,map);
        Map<TreeNode,Boolean> vis = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(target);
        vis.put(target, true);
        int dist = 0;
        while(!q.isEmpty()) {
            if(dist == k) break;
            int n = q.size();
            for(int i = 0;i < n;i++) {
                TreeNode curr = q.poll();
                if(curr.left != null && vis.get(curr.left) == null) {
                    vis.put(curr.left,true);
                    q.add(curr.left);
                }
                if(curr.right != null && vis.get(curr.right) == null) {
                    vis.put(curr.right,true);
                    q.add(curr.right);
                }
                if(map.get(curr) != null && vis.get(map.get(curr)) == null) {
                    vis.put(map.get(curr),true);
                    q.add(map.get(curr));
                }
            }
            dist++;
        }
        List<Integer> res = new ArrayList<>();
        while(!q.isEmpty()) {
            res.add(q.poll().val);
        }
        return res;
    }
}