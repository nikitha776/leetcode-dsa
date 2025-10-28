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
    public TreeNode helper(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd, HashMap<Integer,Integer> map) {
        if(preStart > preEnd || inStart > inEnd) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStart]);
        int idx = map.get(preorder[preStart]);
        int leftLen = idx - inStart;
        root.left = helper(preorder,preStart+1,preStart+leftLen,inorder,inStart,idx-1,map);
        root.right = helper(preorder,preStart+leftLen+1,preEnd,inorder,idx+1,inEnd,map);
        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0;i < n;i++) {
            map.put(inorder[i],i);
        }
        return helper(preorder,0,n-1,inorder,0,n-1,map);
    }
}