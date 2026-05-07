class Solution {
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        int count = 0;
        int zeros = 0;
        int max = 0;
        while(right < n) {
            if(nums[right] == 0) zeros++;
            if(zeros >= k) {
                while(zeros > k) {
                    if(nums[left] == 0) {
                        zeros--;
                    }
                    left++;
                }
            }
            max = Math.max(right-left+1,max);
            right++;
        }
        return max;
    }
}