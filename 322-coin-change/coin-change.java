class Solution {
    public int helper(int[] coins, int amount, int idx, int[][] dp) {
        if(idx == 0) return amount % coins[idx] == 0 ? amount / coins[idx] : (int)1e9;
        if(dp[idx][amount] != -1) return dp[idx][amount];
        int pick = Integer.MAX_VALUE;
        if(amount >= coins[idx]) pick = 1 + helper(coins,amount-coins[idx],idx,dp);
        int notpick = helper(coins,amount,idx-1,dp);
        return dp[idx][amount] = Math.min(pick,notpick);
    }
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int i = 0;i < n;i++) {
            Arrays.fill(dp[i],-1);
        }
        int ans = helper(coins,amount,n-1,dp);
        return ans >= (int)1e9 ? -1 : ans;

    }
}