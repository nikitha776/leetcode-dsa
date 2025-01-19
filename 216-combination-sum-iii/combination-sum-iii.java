class Solution {
    public void helper(int[] nums,List<List<Integer>> ans,List<Integer> list,int target,int idx,int n) {
        if(list.size() == n) {
            if(target == 0 ) {
                ans.add(new ArrayList<>(list));
            }
            return;
        }
        if(idx >= nums.length || target < 0) {
            return;
        }
        list.add(nums[idx]);
        helper(nums,ans,list,target-nums[idx],idx+1,n);
        list.remove(list.size()-1);
        helper(nums,ans,list,target,idx+1,n);
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] nums = {1,2,3,4,5,6,7,8,9};
        List<List<Integer>> lists = new ArrayList<>();
        helper(nums,lists,new ArrayList<>(),n,0,k);
        return lists;
    }
}