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
    // public void helper(TreeNode root,List<Integer> list) {
    //     if(root == null) {
    //         return;
    //     }
    //     list.add(root.val);
    //     helper(root.left,list);
    //     helper(root.right,list);
    // }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        // helper(root,list);
        if(root == null) return list;

        Stack<TreeNode> st = new Stack<>();
        st.push(root);

        while(!st.isEmpty()) {
            TreeNode temp = st.pop();
            if(temp.right != null) st.push(temp.right);
            if(temp.left != null) st.push(temp.left);
            list.add(temp.val);
        }

        return list;
    }
}