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
    public TreeNode replaceValueInTree(TreeNode root) {
        Queue<TreeNode> q1 = new LinkedList<>();
        // Queue<Pair<TreeNode,TreeNode>> q2 = new LinkedList<>();
        q1.add(root);
        List<Integer> list = new ArrayList<>();
        while(!q1.isEmpty()) {
            int n = q1.size();
            int sum = 0;
            for(int i = 0;i < n;i++) {
                TreeNode temp = q1.poll();
                sum += temp.val;
                if(temp.left != null) q1.add(temp.left);
                if(temp.right != null) q1.add(temp.right);
            }
            list.add(sum);
        }
        int lvl = 1;
        q1.add(root);
        while(!q1.isEmpty()) {
            int n = q1.size();
            for(int i = 0;i < n;i++) {
                TreeNode temp = q1.poll();
                int siblingSum = (temp.left != null ? temp.left.val : 0) + (temp.right != null ? temp.right.val : 0);
                if(temp.left != null) {
                    int totalSum = list.get(lvl);
                    temp.left.val = totalSum - siblingSum;
                    q1.add(temp.left);
                }
                if(temp.right != null) {
                    int totalSum = list.get(lvl);
                    temp.right.val = totalSum - siblingSum;
                    q1.add(temp.right);
                }
            }
            lvl++;
        }
        root.val = 0;
        return root;
    }
}