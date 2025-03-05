class Solution {
    public boolean canJump(int[] nums) {
        int i = 0;
        int maxIdx = 0;
        int x = 0;
        while(i < nums.length) {
            x = i+nums[i];
            if(i > maxIdx) return false;
            maxIdx = Math.max(maxIdx,x);
            i++;
        }
        return true;
    }
}