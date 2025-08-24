class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        int maxLen = 0;
        int zeros = 0;
        // if(nums[left] == 0) zeros++;
        while(right < n) {
            if(nums[right] == 0) zeros++;
            if(zeros <= 1) {
                int len = right - left;
                maxLen = Math.max(len,maxLen);
            } else {
                if(nums[left] == 0) zeros--;
                left++;
            }
            right++;
        }
        return maxLen;
    }
}