class Solution {
    public void helper(int[] nums, List<List<Integer>> res, List<Integer> list, int idx) {
        if(idx == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[idx]);
        helper(nums,res,list,idx+1);
        list.remove(list.size()-1);
        helper(nums,res,list,idx+1);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        helper(nums,res,new ArrayList<>(),0);
        return res;
    }
}