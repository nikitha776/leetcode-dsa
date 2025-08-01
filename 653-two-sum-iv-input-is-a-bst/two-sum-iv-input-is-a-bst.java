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
public class BSTiterator {
    private Stack<TreeNode> st = new Stack<>();
    boolean reverse;
    public BSTiterator(TreeNode root,boolean reverse) {
        this.reverse = reverse;
        pushAll(root);
    }
    public int next() {
        TreeNode temp = st.pop();
        if(reverse) pushAll(temp.left);
        else pushAll(temp.right);
        return temp.val;
    }
    private void pushAll(TreeNode root) {
        while(root != null) {
            st.push(root);
            if(reverse) root = root.right;
            else root = root.left;
        }
    }
} 
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        BSTiterator l = new BSTiterator(root,false);
        BSTiterator r = new BSTiterator(root,true);

        int i = l.next();
        int j = r.next();

        while(i < j) {
            int sum = i+j;
            if(sum == k) return true;
            else if(sum < k) i = l.next();
            else j = r.next();
        }

        return false;
    }
}