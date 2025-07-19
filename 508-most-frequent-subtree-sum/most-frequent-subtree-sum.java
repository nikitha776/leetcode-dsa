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
    public int helper(TreeNode root,HashMap<Integer,Integer> map) {
        if(root == null) return 0;
        int leftSum = helper(root.left,map);
        int rightSum = helper(root.right,map);
        int sum = leftSum + rightSum + root.val;
        map.put(sum,map.getOrDefault(sum,0)+1);
        return sum;
    }
    public int[] findFrequentTreeSum(TreeNode root) {
        HashMap<Integer,Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        helper(root,map);
        int maxFreq = -1;
        int i = 0;
        for(int e : map.values()) {
            maxFreq = Math.max(maxFreq,e);
        }
        for(Map.Entry<Integer,Integer> e : map.entrySet()) {
            if(maxFreq == e.getValue()) {
                list.add(e.getKey());
            }
        }
        int n = list.size();
        int[] res = new int[n];
        for(i = 0;i < n;i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}