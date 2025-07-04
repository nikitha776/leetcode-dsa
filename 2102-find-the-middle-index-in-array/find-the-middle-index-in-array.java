class Solution {
    public int findMiddleIndex(int[] nums) {
        int n = nums.length;
        int prefSum = 0;
        int sum = 0;
        int suffSum;
        for(int i = 0;i < n;i++) {
            sum += nums[i];
        }
        for(int i = 0;i < n;i++) {
            prefSum += nums[i];
            suffSum = sum - prefSum;
            if(prefSum-nums[i] == suffSum) return i;
        }
        return -1;
    }
}