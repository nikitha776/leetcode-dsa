/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        Queue<Node> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int n = q.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0;i < n;i++) {
                Node temp = q.poll();
                list.add(temp.val);
                int m = temp.children.size();
                for(int j = 0;j < m;j++) {
                    if(temp.children.get(j) != null) q.add(temp.children.get(j));
                }
            }
            res.add(list);
        }
        return res;
    }
}