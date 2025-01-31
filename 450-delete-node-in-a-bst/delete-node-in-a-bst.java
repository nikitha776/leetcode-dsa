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
    public TreeNode findMax(TreeNode root) {
        if(root.right == null) return root;
        return findMax(root.right);
    }
    public void swap(TreeNode a,TreeNode b) {
        int temp = a.val;
        a.val = b.val;
        b.val = temp;
    }
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null) return null;
        if(key > root.val) root.right = deleteNode(root.right,key);
        else if(key < root.val) root.left = deleteNode(root.left,key);
        else {
            if(root.left == null && root.right == null) {
                return null;
            }
            else if(root.left == null) {
                return root.right;
            }
            else if(root.right == null) {
                return root.left;
            } else {
                TreeNode x = findMax(root.left);
                swap(root,x);
                root.left = deleteNode(root.left,key);
            }
        }
        return root;
    }
}