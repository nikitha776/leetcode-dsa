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
    public TreeNode helper(int[] inorder, int[] preorder,int is,int ie,int ps,int pe,Map<Integer,Integer> map) {
        if(is > ie || ps > pe) return null;
        TreeNode root = new TreeNode(preorder[ps]);
        int idx = map.get(preorder[ps]);
        int leftLen = idx-is;
        int rightLen = ie-idx;
        root.left = helper(inorder,preorder,is,idx-1,ps+1,ps+leftLen,map);
        root.right = helper(inorder,preorder,idx+1,ie,pe-rightLen+1,pe,map);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < inorder.length;i++) {
            map.put(inorder[i],i);
        }
        TreeNode root = helper(inorder,preorder,0,inorder.length-1,0,preorder.length-1,map);
        return root;
    }
}