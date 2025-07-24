class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int left = 0;
        int right = k;
        int n = nums.length;
        double sum = 0;
        for(int i = 0;i < k;i++) {
            sum += (double)nums[i];
        }
        double maxAvg = sum / k;
        while(right < n) {
            sum += nums[right];
            sum -= nums[left];
            left++;
            right++;
            double avg = (double)sum/k;
            maxAvg = Math.max(avg,maxAvg);
        }
        return maxAvg;
    }
}