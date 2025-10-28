class Solution {
    public boolean helper(int[] arr, int idx, int dir, int n, int nz) {
        int[] nums = arr.clone();
        while(idx >= 0 && idx < n && nz > 0) {
            if(nums[idx] == 0) idx += dir;
            else {
                nums[idx]--;
                if(nums[idx] == 0) nz--;
                dir = dir*-1;
                idx += dir;
            }
        }
        if(nz == 0) return true;
        else return false;
    }
    public int countValidSelections(int[] nums) {
        int n = nums.length;
        int nz = 0;
        int count = 0;
        for(int i : nums) {
            if(i > 0) nz++;
        }
        for(int i = 0;i < n;i++) {
            if(nums[i] == 0) {
                if(helper(nums,i,1,n,nz)) count++;
                if(helper(nums,i,-1,n,nz)) count++;
            }
        }
        return count;
    }
}