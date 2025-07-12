class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for(int i = 0;i < n-1;i++) {
            int j = i+1;
            int k = n-1;
            while(j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == target) return target;
                else if(Math.abs(target-ans) > Math.abs(target-sum)) ans = sum;
                else if(target > sum) j++;
                else k--;
            }
        }
        return ans;
    }
}