class Solution {
    public int maxSum(int[] nums) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet<>();
        for(int i = 0;i < n;i++) {
            set.add(nums[i]);
            max = Math.max(nums[i],max);
        }
        if(max <= 0) return max;
        int sum = 0;
        for(int i : set) {
            if(i > 0) sum += i;
        }
        return sum;
    }
}