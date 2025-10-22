class Solution {
    public void helper(int[] nums,List<List<Integer>> res,List<Integer> list,int idx) {
        if(idx == nums.length) {
            res.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[idx]);
        helper(nums,res,list,idx+1);
        list.remove(list.size()-1);
        while(idx < nums.length-1 && nums[idx] == nums[idx+1]) {
            idx++;
        }
        helper(nums,res,list,idx+1);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        helper(nums,res,new ArrayList<>(),0);
        return res;
    }
}