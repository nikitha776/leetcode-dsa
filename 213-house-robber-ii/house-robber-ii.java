class Solution {
    public int helper(int[] nums,int s,int e) {
        int prev2 = 0;
        int prev1 = nums[s];
        for(int i = s+1;i < e;i++) {
            int pick = nums[i] + prev2;
            int notpick = prev1;
            int res = Math.max(pick,notpick);
            prev2 = prev1;
            prev1 = res;
        }
        return prev1;
    }
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        int ans1 = helper(nums,0,n-1);
        int ans2 = helper(nums,1,n);
        return Math.max(ans1,ans2);
    }
}