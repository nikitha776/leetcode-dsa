class Solution {
    public int minimumDeletions(int[] nums) {
        int n = nums.length;
        int minIdx = 0;
        int maxIdx = 0;

        for(int i = 0;i < n;i++) {
            if(nums[minIdx] < nums[i]) minIdx = i;
            if(nums[maxIdx] > nums[i]) maxIdx = i;
        }

        // deleteing both from front
        int s1 = Math.max(minIdx,maxIdx) + 1;
        // deleting both from back
        int s2 = n - Math.min(minIdx,maxIdx);
        //deleting from both sides
        int l = Math.min(minIdx,maxIdx)+1;
        int r = n - Math.max(minIdx,maxIdx);
        int s3 = l + r;

        int ans = Math.min(s1,Math.min(s2,s3));

        return ans;
    }
}