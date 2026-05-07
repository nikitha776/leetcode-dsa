class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int n = nums.length;
        int count = 0;
        int ones = 0;
        for(int i = 0;i < n;i++) {
            if(nums[i] == 1) {
                ones++;
                count = Math.max(count,ones);
            }
            else ones = 0;
        }
        return count;
    }
}