class Solution {
    public void helper(int[] nums,int target,List<List<Integer>> res,List<Integer> list,int idx) {
        if(target == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        if(target < 0 || idx == nums.length) return;
        list.add(nums[idx]);
        helper(nums,target-nums[idx],res,list,idx+1);
        list.remove(list.size()-1);
        while(idx < nums.length-1 && nums[idx] == nums[idx+1]) idx++;
        helper(nums,target,res,list,idx+1);
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        helper(candidates,target,res,new ArrayList<>(),0);
        return res;
    }
}