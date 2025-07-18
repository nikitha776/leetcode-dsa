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
    public TreeNode helper(int[] inorder, int[] postorder,int is,int ie,int ps,int pe,Map<Integer,Integer> map) {
        if(is > ie || ps > pe) return null;
        TreeNode root = new TreeNode(postorder[pe]);
        int idx = map.get(postorder[pe]);
        int leftLen = idx-is;
        root.left = helper(inorder,postorder,is,idx-1,ps,ps+leftLen-1,map);
        root.right = helper(inorder,postorder,idx+1,ie,ps+leftLen,pe-1,map);
        return root;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < inorder.length;i++) {
            map.put(inorder[i],i);
        }
        TreeNode root = helper(inorder,postorder,0,inorder.length-1,0,postorder.length-1,map);
        return root;
    }
}