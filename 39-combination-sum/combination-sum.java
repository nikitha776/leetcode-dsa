class Solution {
    public void helper(int[] nums, int target, int idx, List<List<Integer>> res, List<Integer> list, int n) {
        if(target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        if(idx == n ) {
            return;
        }
        if(target < 0) return;
        list.add(nums[idx]);
        helper(nums,target-nums[idx],idx,res,list,n);
        list.remove(list.size()-1);
        helper(nums,target,idx+1,res,list,n);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        helper(candidates,target,0,res,new ArrayList<>(),candidates.length);
        return res;
    }
}