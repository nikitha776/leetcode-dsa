class Solution {
    public int minimumCost(int[] nums) {
        int n = nums.length;
        int min = Integer.MAX_VALUE;
        int secMin = Integer.MAX_VALUE;
        for(int i = 0;i < n;i++) {
            if(nums[i] < min && i != 0) {
                secMin = min;
                min = nums[i];
            } else if(secMin >= nums[i] && nums[i] >= min && i != 0) {
                secMin = nums[i];
            }
        }
        return nums[0]+min+secMin;
    }
}