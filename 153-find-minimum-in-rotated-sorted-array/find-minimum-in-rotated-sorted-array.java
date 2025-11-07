class Solution {
    public int findMin(int[] nums) {
        int s = 0;
        int e = nums.length-1;
        int min = Integer.MAX_VALUE;
        while(s <= e) {
            int mid = (s+e)/2;
            if(nums[s] <= nums[mid]) {
                min = Math.min(nums[s],min);
                s = mid+1;
            } else if(nums[mid] <= nums[e]) {
                min = Math.min(nums[mid],min);
                e = mid-1;
            }
        }
        return min;
    }
}