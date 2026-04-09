class Solution {
    public int helper(int[] dp, int n) {
        if(n == 0) return 1;
        if(n == 1) return 1;
        if(dp[n] != -1) return dp[n];
        int one = helper(dp, n-1);
        int two = helper(dp, n-2);
        return dp[n] = one + two;
    }
    public int climbStairs(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp,-1);
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2;i <= n;i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        // return helper(dp,n);
        return dp[n];
    }
}