class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int maxSum = 0;
        int l = 0;
        int r = 0;
        int n = nums.length;
        int sum = 0;
        Map<Integer,Integer> map = new HashMap<>();
        while(r < n) {
            sum += nums[r];
            while(map.containsKey(nums[r])) {
                sum -= nums[l];
                map.put(nums[l],map.get(nums[l])-1);
                if(map.get(nums[l]) == 0) map.remove(nums[l]);
                l++;
            }
            map.put(nums[r],1);
            maxSum = Math.max(sum,maxSum);
            r++;
        }
        return maxSum;
    }
}