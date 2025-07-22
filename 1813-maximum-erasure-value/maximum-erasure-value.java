class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int maxSum = 0;
        int l = 0;
        int r = 0;
        int n = nums.length;
        int sum = 0;
        Set<Integer> set = new HashSet<>();
        while(r < n) {
            sum += nums[r];
            while(set.contains(nums[r])) {
                sum -= nums[l];
                set.remove(nums[l]);
                l++;
            }
            set.add(nums[r]);
            maxSum = Math.max(sum,maxSum);
            r++;
        }
        return maxSum;
    }
}