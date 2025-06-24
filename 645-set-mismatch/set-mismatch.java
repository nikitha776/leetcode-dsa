class Solution {
    public int[] findErrorNums(int[] nums) {
        long n = nums.length;
        int[] res = new int[2];
        long SN = (n*(n+1))/2;
        long S2N = (n * (n+1) * (2*n+1)) / 6;
        long S = 0;
        long S2 = 0;
        
        for(int i = 0;i < n;i++) {
            S += nums[i];
            S2 += nums[i]*nums[i];
        }

        long val1 = SN - S;  // x - y
        long val2 = S2N - S2; // x^2 - y^2
        long val = val2 / val1; // x + y

        long x = (val1 + val)/2;
        long y = val - x;

        res[0] = (int)y;
        res[1] = (int)x;

        return res;
    }
}