class Solution {
    public List<List<Integer>> helper(int[] nums,List<List<Integer>> res,List<Integer> list,int idx) {
        if(idx == nums.length) {
            res.add(new ArrayList<>(list));
            return res;
        }
        list.add(nums[idx]);
        helper(nums,res,list,idx+1);
        list.remove(list.size()-1);
        while(idx+1 < nums.length && nums[idx] == nums[idx + 1]) {
            idx++;
        }
        helper(nums,res,list,idx+1);
        return res;
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helper(nums,res,list,0);
        return res;
    }
}