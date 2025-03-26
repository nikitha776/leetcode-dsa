class Solution {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        boolean flag = false;
        for(int i = 0;i < nums.length;i++) {
            if(nums[i] == 1) {
                flag = true;
            }
            if(nums[i] <= 0 || nums[i] > n) {
                nums[i] = 1;
            }
        }
        if(!flag) return 1;
        for(int i = 0;i < nums.length;i++) {
            int val = Math.abs(nums[i]);
            if(val == n) {
                nums[0] = -Math.abs(nums[i]);
            } else {
                nums[val] = -Math.abs(nums[val]);
            }
        }
        for(int i = 1;i < n;i++) {
            if(nums[i] > 0) return i;
        }
        if(nums[0] > 0)
        {
            return n;}
        return n+1;
    }
}