class Solution {
    public void helper(int[] nums,List<List<Integer>> lists,List<Integer> list,int sum,int target,int idx) {
        if(sum == target) {
            lists.add(new ArrayList<>(list));
            return;
        }
        if(idx == nums.length || sum > target) {
            return;
        }
        list.add(nums[idx]);
        sum = sum + nums[idx];
        helper(nums,lists,list,sum,target,idx+1);
        while(idx+1 < nums.length && nums[idx] == nums[idx+1]) {
            idx++;
        }
        list.remove(list.size()-1);
        sum = sum - nums[idx];
        helper(nums,lists,list,sum,target,idx+1);
        return;
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(candidates,lists,list,0,target,0);
        return lists;
    }
}