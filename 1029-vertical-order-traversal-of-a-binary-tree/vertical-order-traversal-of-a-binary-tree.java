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
class Tuple {
    TreeNode node;
    int row;
    int col;
    Tuple(TreeNode n,int r,int c) {
        node = n;
        row = r;
        col = c;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Map<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(root,0,0));
        int level = 0;
        while(!q.isEmpty()) {
            int n = q.size();
            for(int i = 0;i < n;i++) {
                Tuple t = q.poll();
                TreeNode curr = t.node;
                int r = t.row;
                int c = t.col;
                if(!map.containsKey(c)) {
                    map.put(c,new TreeMap<>());
                }
                if(map.containsKey(c)) {
                    if(map.get(c).containsKey(r)) {
                        map.get(c).get(r).add(curr.val);
                    } else {
                        map.get(c).put(r,new PriorityQueue<>());
                        map.get(c).get(r).add(curr.val);
                    }
                }
                if(curr.left != null) q.add(new Tuple(curr.left,r+1,c-1));
                if(curr.right != null) q.add(new Tuple(curr.right,r+1,c+1));
            }
        }
        for(TreeMap<Integer,PriorityQueue<Integer>> m : map.values()) {
            List<Integer> list = new ArrayList<>();
            for(PriorityQueue<Integer> pq : m.values()) {
                while(!pq.isEmpty()) list.add(pq.poll());
            }
            res.add(new ArrayList<>(list));
        }
        return res;
    }
}