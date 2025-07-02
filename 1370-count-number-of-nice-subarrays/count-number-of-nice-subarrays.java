class Solution {
    public int helper(int[] nums, int k) {
        int n = nums.length;
        int left = 0;
        int right = 0;
        int odds  = 0;
        int count = 0;

        while(right < n) {
            odds += (nums[right] % 2);
            while(odds > k) {
                odds -= (nums[left] % 2);
                left++;
            }
            if(odds <= k) count += right-left+1;;
            right++;
        }
        return count;
    }

    public int numberOfSubarrays(int[] nums, int k) {
        return helper(nums,k) - helper(nums,k-1);
    }
}