class Solution {
    public void helper(int[] nums, int idx, int or, int maxOR, int[] count) {
        if(idx == nums.length) {
            if(or == maxOR) {
                count[0]++;
            }
            return;
        }
        helper(nums,idx+1,or|nums[idx],maxOR,count);
        helper(nums,idx+1,or,maxOR,count);
    }
    public int countMaxOrSubsets(int[] nums) {
        int maxOR = 0;
        int n = nums.length;
        for(int i = 0;i < n;i++) {
            maxOR |= nums[i];
        }
        int[] count = new int[1];
        helper(nums,0,0,maxOR,count);
        return count[0];
    }
}