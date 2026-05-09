class Solution {
    public int helper(int idx,int prev,int[] nums,int n,int[][] dp) {
        if(idx == n) return 0;
        if(dp[idx][prev+1] != -1) return dp[idx][prev+1];
        int not_take = helper(idx+1,prev,nums,n,dp);
        int take = 0;
        if(prev == -1 || nums[idx] > nums[prev]) {
            take = 1 + helper(idx+1,idx,nums,n,dp);
        }
        return dp[idx][prev+1] = Math.max(take,not_take);
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n+1];
        for(int i = 0;i < n;i++) {
            Arrays.fill(dp[i],-1);
        }
        return helper(0,-1,nums,n,dp);
    }
}