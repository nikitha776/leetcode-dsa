class Solution {
    // memoization
    public int helper(int n,int[] dp) {
        if(n == 0) return 1;
        if(n == 1) return 1;
        if(dp[n] != -1) return dp[n];
        return helper(n-1,dp) + helper(n-2,dp);
    }
    public int climbStairs(int n) {
        // int[] dp = new int[n+1];
        // Arrays.fill(dp,-1);
        // dp[0] = 1;
        // dp[1] = 1;
        // for(int i = 2;i <= n;i++) {
        //     dp[i] = dp[i-1] + dp[i-2];
        // }
        // return dp[n];
        int prev1 = 1;
        int prev2 = 1;
        for(int i = 2;i <= n;i++) {
            int res = prev1 + prev2;
            prev2 = prev1;
            prev1 = res;
        }
        return prev1;
    }
}