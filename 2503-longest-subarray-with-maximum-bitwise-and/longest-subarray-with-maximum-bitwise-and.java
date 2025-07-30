class Solution {
    public int longestSubarray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int n = nums.length;
        for(int i = 0;i < n;i++) {
            max = Math.max(nums[i],max);
        }
        int len = 0;
        int maxLen = 0;
        for(int i = 0;i < n;i++) {
            if(max == nums[i]) len++;
            else {
                len = 0;
            }
            maxLen = Math.max(len,maxLen);
        }
        return maxLen;
    }
}