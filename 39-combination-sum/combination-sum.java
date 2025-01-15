class Solution {
    // public void helper(List<List<Integer>> lists,int[] nums,List<Integer> list,int sum,int target,int idx) {
    //     if(sum == target) {
    //        lists.add(new ArrayList<>(list));
    //        return;
    //     }
    //     if(sum > target || idx == nums.length);
    //     list.add(nums[idx]);
    //     sum = sum + nums[idx];
    //     helper(lists,nums,list,sum,target,idx);
    //     list.remove(list.size()-1);
    //     sum = sum - nums[idx];
    //     helper(lists,nums,list,sum,target,idx+1);
    //     return;
    // }
    public void helper(List<List<Integer>> lists,int[] nums,List<Integer> list,int target,int idx) {
        if(idx == nums.length) {
            if(target == 0) {
                lists.add(new ArrayList<>(list));
            }
            return;
        }
        if(nums[idx] <= target) {
            list.add(nums[idx]);
            helper(lists,nums,list,target-nums[idx],idx);
            list.remove(list.size()-1);
        }
        helper(lists,nums,list,target,idx+1);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        // helper(lists,candidates,list,0,target,0);
        helper(lists,candidates,list,target,0);
        return lists;
    }
}