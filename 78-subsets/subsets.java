class Solution {
    public List<List<Integer>> helper(int[] nums,List<List<Integer>> ans,int idx,List<Integer> list) {
        if(idx == nums.length) {
            ans.add(new ArrayList<>(list));
            return ans;
        }
        list.add(nums[idx]);
        helper(nums,ans,idx+1,list);
        list.remove(list.size()-1);
        helper(nums,ans,idx+1,list);
        return ans;
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(nums,ans,0,list);
        return ans;
    }
}