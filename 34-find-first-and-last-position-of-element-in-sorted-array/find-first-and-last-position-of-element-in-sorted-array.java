class Solution {
    public int[] searchRange(int[] nums, int target) {
        int s = 0;
        int e = nums.length-1;
        int[] res = new int[2];
        res[0] = -1;
        res[1] = -1;
        while(s <= e) {
            int mid = (s+e)/2;
            if(nums[mid] == target) {
                res[0] = mid;
                e = mid-1;
            } else if(nums[mid] > target) {
                e = mid-1;
            } else {
                s = mid+1;
            }
        }
        if(res[0] == -1) return res;
        s = 0;
        e = nums.length-1;
        while(s <= e) {
            int mid = (s+e)/2;
            if(nums[mid] == target) {
                res[1] = mid;
                s = mid+1;
            } else if(nums[mid] > target) {
                e = mid-1;
            } else {
                s = mid+1;
            }
        }
        return res;
    }
}