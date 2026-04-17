class Solution {
    public int helper(int[] nums,int n,int[] dp) {
        if(n == 0) return dp[n] = nums[0];
        if(n < 0) return 0;
        if(dp[n] != -1) return dp[n];
        int pick = nums[n] + helper(nums,n-2,dp);
        int notpick = helper(nums,n-1,dp);
        return dp[n] = Math.max(pick,notpick);
    }
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        dp[0] = 0;
        return helper(nums,n-1,dp);
    }
}