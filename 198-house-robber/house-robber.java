class Solution {
    public int helper(int[] nums,int idx,int[] dp) {
        if(idx < 0) return 0;
        if(idx == 0) return nums[idx];
        if(dp[idx] != -1) return dp[idx];
        int pick = nums[idx] + helper(nums,idx-2,dp);
        int notpick = helper(nums,idx-1,dp);
        return dp[idx] = Math.max(pick,notpick);
    }
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        // Arrays.fill(dp,-1);
        // return helper(nums,n-1,dp);
        dp[0] = nums[0];
        for(int i = 1;i < n;i++) {
            int pick = nums[i];
            if(i-2 >= 0) pick = nums[i] + dp[i-2];
            int notpick = dp[i-1];
            dp[i] = Math.max(pick,notpick);
        }
        return dp[n-1];
    }
}