class Solution {
    public int maximumProduct(int[] nums) {
        int n = nums.length;
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;

        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;

        for(int i = 0;i < n;i++) {
            if(nums[i] > max1) {
                max3 = max2;
                max2 = max1;
                max1 = nums[i];
            } else if(nums[i] >= max2) {
                max3 = max2;
                max2 = nums[i];
            } else if(nums[i] >= max3) {
                max3 = nums[i];
            }
            if(nums[i] < min1) {
                min2 = min1;
                min1 = nums[i];
            } else if(nums[i] <= min2) {
                min2 = nums[i];
            }
        }
         System.out.println(max1 + " " + max2 + " " + max3 + " " + min1 + " " + min2);
        int prod1 = max1*max2*max3;
        int prod2 = min1*min2*max1;
        return prod1 > prod2 ? prod1 : prod2;
    }
}