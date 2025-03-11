class Solution {
    public int[] singleNumber(int[] nums) {
        long x = 0;
        for(int i = 0;i < nums.length;i++) {
            x = x ^ nums[i];
        }
        int r = (int)((x & (x-1)) ^ x);
        int b1 = 0;
        int b2 = 0;
        for(int i = 0;i < nums.length;i++) {
            if((nums[i] & r)!= 0) b1 = b1^nums[i];
            else b2 = b2^nums[i];
        }
        int[] res = new int[2];
        res[0] = b1;
        res[1] = b2;
        return res;
    }
}