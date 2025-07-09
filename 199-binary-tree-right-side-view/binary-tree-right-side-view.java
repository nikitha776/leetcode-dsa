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
//  class Pair<u, v> {
//     public u first;
//     public v second;

//     public Pair(u first, v second) {
//         this.first = first;
//         this.second = second;
//     }

//     public u getKey() {
//         return first;
//     }

//     public v getValue() {
//         return second;
//     }
// }

class Solution {
    public void reversePreorder(TreeNode root,int lvl,List<Integer> list) {
        if(root == null) return;
        if(lvl == list.size()) list.add(root.val);
        reversePreorder(root.right,lvl+1,list);
        reversePreorder(root.left,lvl+1,list);
    }
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        // if(root == null) return list;
        // Map<Integer,Integer> map = new TreeMap<>();
        // Queue<Pair<TreeNode,Integer>> q = new LinkedList<>();
        // q.add(new Pair<>(root,0));

        // while(!q.isEmpty()) {
        //     int n = q.size();
        //     for(int i = 0;i < n;i++) {
        //         Pair<TreeNode,Integer> p = q.poll();
        //         TreeNode temp = p.getKey();
        //         int lvl = p.getValue();
        //         int val = temp.val;
        //         map.put(lvl,val);
        //         if(temp.left != null) q.add(new Pair<>(temp.left,lvl+1));
        //         if(temp.right != null) q.add(new Pair<>(temp.right,lvl+1));
        //     }
        // }
        reversePreorder(root,0,list);
        
        return list;
    }
}