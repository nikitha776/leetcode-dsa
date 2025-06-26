class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int right  = 0;
        int zeroes = 0;
        int n = nums.length;
        int len = 0;

        while(right < n) {
            if(nums[right] == 0) zeroes++;

            while(zeroes > k) {
                if(nums[left] == 0) zeroes--;
                left++;
            }

            if(zeroes <= k) {
                len = Math.max(right-left+1,len);
            }
            right++;
        }

        return len;
    }
}