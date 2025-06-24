class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int prefProd = 1;
        int suffProd = 1;
        int max = Integer.MIN_VALUE;

        for(int i = 0;i < n;i++) {
            if(prefProd == 0) prefProd = 1;
            if(suffProd == 0) suffProd = 1;

            prefProd *= nums[i];
            suffProd *= nums[n-i-1];

            max = Math.max(max,Math.max(prefProd,suffProd));
        }

        return max;
    }
}