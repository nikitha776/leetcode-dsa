class Solution {
    public boolean helper(int[] nums,int sum,int idx,int[][] dp) {
        if(idx == 0) return nums[idx] == sum;
        if(sum == 0) return true;
        if(dp[idx][sum] != -1) return dp[idx][sum] == 1;
        boolean pick = false;
        if(sum >= nums[idx]) pick = helper(nums,sum-nums[idx],idx-1,dp);
        boolean notpick = helper(nums,sum,idx-1,dp);
        dp[idx][sum] = pick || notpick ? 1 : 0;
        return pick || notpick; 
    }
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int i = 0;i < n;i++) {
            sum += nums[i];
        }
        // int[][] dp = new int[n][sum+1];
        // for(int i = 0;i < n;i++) {
        //     Arrays.fill(dp[i],-1);
        // }
        // return helper(nums,sum/2,n-1,dp);
        if(sum % 2 != 0) return false;
        int targetSum = sum/2;
        
        // boolean[][] dp = new boolean[n][targetSum+1];
        // for(int i = 0;i < n;i++) {
        //     dp[i][0] = true;
        // }
        // if(nums[0] <= targetSum) dp[0][nums[0]] = true;
        // for(int idx = 1;idx < n;idx++) {
        //     for(int s = 1;s <= targetSum;s++) {
        //         boolean pick = false;
        //         if(s >= nums[idx]) pick = dp[idx-1][s-nums[idx]];
        //         boolean notpick = dp[idx-1][s];
        //         dp[idx][s] = pick || notpick;
        //     }
        // }
        // return dp[n-1][targetSum];

        boolean[] dp = new boolean[targetSum+1];
        dp[0] = true;
        if(nums[0] <= targetSum) dp[nums[0]] = true;

        for(int idx = 1;idx < n;idx++) {
            boolean[] temp = new boolean[targetSum+1];
            for(int s = 1;s <= targetSum;s++) {
                boolean pick = false;
                if(s >= nums[idx]) pick = dp[s-nums[idx]];
                boolean notpick = dp[s];
                temp[s] = pick || notpick;
            }
            dp = temp;
        }
        return dp[targetSum];
    }
}