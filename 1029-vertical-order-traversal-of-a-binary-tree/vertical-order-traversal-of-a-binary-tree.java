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
    
    Tuple(TreeNode node,int row,int col) {
        this.node = node;
        this.row = row;
        this.col = col;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer,TreeMap<Integer,PriorityQueue<Integer>>> map = new TreeMap<>();
        Queue<Tuple> q = new LinkedList<>();
        q.add(new Tuple(root,0,0));
        while(!q.isEmpty()) {
            int n = q.size();
            Tuple t = q.poll();
            int row = t.row;
            int col = t.col;
            TreeNode temp = t.node;
            if(!map.containsKey(col)) {
                map.put(col,new TreeMap<>());
            }
            if(!map.get(col).containsKey(row)) {
                map.get(col).put(row,new PriorityQueue<>());
            }
            map.get(col).get(row).add(temp.val);
            if(temp.left != null) {
                q.add(new Tuple(temp.left,row+1,col-1));
            }
            if(temp.right != null) {
                q.add(new Tuple(temp.right,row+1,col+1));
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        for(TreeMap<Integer,PriorityQueue<Integer>> v : map.values()) {
            List<Integer> list = new ArrayList<>();
            for(PriorityQueue<Integer> pq : v.values()) {
                while(!pq.isEmpty()) {
                    list.add(pq.poll());
                }
            }
            res.add(list);
        }
        return res;
    }
}