class Solution {
    int[] vals;
    public int helper(int[] coins,int amount) {
        if(amount == 0) return 0;
        if(vals[amount] != -1) return vals[amount];
        vals[amount] = 10001;
        for(int i = 0;i < coins.length;i++) {
            if(coins[i] <= amount) {
                vals[amount] = Math.min(vals[amount],1+helper(coins,amount-coins[i]));
            }
        }
        return vals[amount];
    }
    public int coinChange(int[] coins, int amount) {
        vals = new int[amount + 1];
        Arrays.fill(vals,-1);
        int res = helper(coins,amount);
        if(res == 10001) return -1;
        return res;

        // if(amount == 0) return 0;
        // int[] dp = new int[amount+1];
        // Arrays.fill(dp,10001);
        // dp[0] = 0;
        // for(int val = 1;val <= amount;val++) {
        //     for(int i = 0;i < coins.length;i++) {
        //         if(coins[i] <= val) {
        //             dp[val] = Math.min(dp[val],1+dp[val-coins[i]]);
        //         }
        //     }
        // }
        // if(dp[amount] == 10001) return -1;
        // else return dp[amount]; //tabulation
    }
}