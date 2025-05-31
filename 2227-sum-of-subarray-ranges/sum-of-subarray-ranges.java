class Solution {
    public long subArrayRanges(int[] nums) {
        // int n = nums.length;
        // int total = 0;
        // int max = Integer.MIN_VALUE;
        // int min = Integer.MAX_VALUE;
        // for(int i = 0;i < n;i++) {
        //     min = nums[i];
        //     max = nums[i];
        //     for(int j = i;j < n;j++) {
        //         min = Math.min(min,nums[j]);
        //         max = Math.max(max,nums[j]);
        //         total += max-min;
        //     }
        // }
        // return total;


        int n=nums.length;
        long res=0;
        for(int i=0;i<n;i++){
            int min=nums[i];
            int max=nums[i];
            for(int j=i;j<n;j++){
                min=Math.min(min,nums[j]);
                max=Math.max(max,nums[j]);
                res+=max-min;
            }
        }
        return res;
    
    }
}