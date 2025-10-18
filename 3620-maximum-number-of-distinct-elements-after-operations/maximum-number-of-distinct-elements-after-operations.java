class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        int prevMax = Integer.MIN_VALUE;
        Arrays.sort(nums);
        for(int i = 0;i < n;i++) {
            int lowerBound = nums[i] - k;
            int upperBound = nums[i] + k;
            if(prevMax < lowerBound) {
                prevMax = lowerBound;
                count++;
            } else if(prevMax < upperBound) {
                prevMax++;
                count++;
            }
        }
        return count;
    }
}