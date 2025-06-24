class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        int l = grid.length;
        long n = (long)l*l;
        long S = 0;
        long S2 = 0;
        long SN = (n*(n+1))/2;
        long S2N = (n * (n+1) * (2*n+1)) / 6;
        int[] res = new int[2];

        for(int i = 0;i < l;i++) {
            for(int j = 0;j < l;j++) {
                int num = grid[i][j];
                S += num;
                S2 += (long)num * (long)num;
            }
        }

        long val1 = SN - S; // x - y
        long val2 = S2N - S2; // x^2 - y^2
        long val = val2/val1; // x + y
        long x = (val + val1) / 2;
        long y = val - x;

        res[0] = (int)y;
        res[1] = (int)x;

        return res;
    }
}