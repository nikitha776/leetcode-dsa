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
    public void parentMap(TreeNode root,Map<TreeNode,TreeNode> map) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            TreeNode temp = q.poll();
            if(temp.left != null) {
                map.put(temp.left,temp);
                q.add(temp.left);
            }
            if(temp.right != null) {
                map.put(temp.right,temp);
                q.add(temp.right);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode,TreeNode> map = new HashMap<>();
        Map<TreeNode,Boolean> visited = new HashMap<>();
        parentMap(root,map);
        Queue<TreeNode> q = new LinkedList<>();
        int dist = 0;
        visited.put(target,true);
        q.add(target);
        while(!q.isEmpty()) {
            if(dist == k) break;
            dist++;
            int n = q.size();
            for(int i = 0;i < n;i++) {
                TreeNode temp = q.poll();
                if(temp.left != null && visited.get(temp.left) == null) {
                    q.add(temp.left);
                    visited.put(temp.left,true);
                }
                if(temp.right != null && visited.get(temp.right) == null) {
                    q.add(temp.right);
                    visited.put(temp.right,true);
                }
                TreeNode parent = map.get(temp);
                if(parent != null && visited.get(parent) == null) {
                    q.add(parent);
                    visited.put(parent,true);
                }
            }
        }
        List<Integer> list = new ArrayList<>();
        while(!q.isEmpty()) {
            list.add(q.poll().val);
        }
        return list;
    }
}