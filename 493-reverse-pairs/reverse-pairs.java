class Solution {
    public int merge(int[] nums,int s,int m,int e) {
        int i = s;
        int j = m+1;
        int k = 0;
        int[] merged = new int[e-s+1];
        int count = 0;

        
        for(i = s;i <= m;i++) {
            while(j <= e && (long)nums[i] > 2L*nums[j]) {
                j++;
            }
            count += j-m-1;
        }

        i = s;
        j = m+1;

        while(i <= m && j <= e) {
            if(nums[i] <= nums[j]) {
                merged[k++] = nums[i++];
            } else {
                merged[k++] = nums[j++];
            }
        }
        
        while(i <= m) {
            merged[k++] = nums[i++];
        }
        while(j <= e) {
            merged[k++] = nums[j++];
        }

        for(i = 0,j = s;i < merged.length;i++,j++) {
            nums[j] = merged[i];
        }

        return count;
    }
    public int divide(int[] nums,int s,int e) {
        if(s < e) {
            int m = (s+e)/2;
            int leftCount = divide(nums,s,m);
            int rightCount = divide(nums,m+1,e);
            int count = merge(nums,s,m,e);
            return count + leftCount + rightCount;
        }
        return 0;
    }
    public int reversePairs(int[] nums) {
        return divide(nums,0,nums.length-1);
    }
}