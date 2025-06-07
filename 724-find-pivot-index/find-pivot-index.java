class Solution {
    public int pivotIndex(int[] nums) {
        // int n = nums.length;
        // int[] prefSum = new int[n];
        // int sum = 0;
        // for(int i = 0;i < n;i++) {
        //     sum += nums[i];
        //     prefSum[i] = sum;
        // }
        // int[] suffSum = new int[n];
        // sum = 0;
        // for(int i = n-1;i >= 0;i--) {
        //     sum += nums[i];
        //     suffSum[i] = sum;
        // }
        // for(int i = 0;i < n;i++) {
        //     if(prefSum[i] == suffSum[i]) return i;
        // }
        // return -1;

        // int n = nums.length;
        // int[] suffSum = new int[n];
        // int sum = 0;
        // for(int i = n-1;i >= 0;i--) {
        //     sum += nums[i];
        //     suffSum[i] = sum;
        // }
        // sum = 0;
        // for(int i = 0;i < n;i++) {
        //     sum += nums[i];
        //     if(sum == suffSum[i]) return i;
        // }
        // return -1;

        int n = nums.length;
        int total = 0;
        for(int i = 0;i < n;i++) {
            total += nums[i];
        }
        int leftSum = 0;
        for(int i = 0;i < n;i++) {
            if(leftSum == (total-leftSum-nums[i])) return i;
            leftSum += nums[i];
        }
        return -1;
    }
}